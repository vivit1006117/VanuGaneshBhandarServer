package Facade.Users.Login;

import Tables.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Login {

    private final LoginParameters parameters = new LoginParameters();

    public ResponseEntity findUser(String userId, String password) throws QueryException {
        parameters.setPassword(password);
        parameters.setUserId(userId);
        try {
            Session session = new Configuration().configure().buildSessionFactory().openSession();
            Criteria criteria = setCriteria(session);
            List results = criteria.list();
            return getResponseEntity(results);
        } catch (QueryException e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ResponseEntity getResponseEntity(List results) {
        UserDetails userDetails = getUserDetails(results);
        if (userDetails == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

    private UserDetails getUserDetails(List results) {
        UserDetails userDetails = null;
        for (Object result : results) {
            userDetails = (UserDetails) result;
        }
        return userDetails;
    }

    private Criteria setCriteria(Session session) {
        Criteria criteria = session.createCriteria(UserDetails.class);
        String userIdType = parameters.getUserId().contains("@") ? "email" : "phoneNumber";
        criteria.add(Restrictions.eq(userIdType, parameters.getUserId()));
        criteria.add(Restrictions.eq("password", parameters.getPassword()));
        return criteria;
    }
}
