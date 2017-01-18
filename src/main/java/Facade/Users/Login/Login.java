package Facade.Users.Login;

import Facade.Users.Registration.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Login {

    private final LoginParameters parameters = new LoginParameters();

    public void findUser(String userId, String password) {
        parameters.setPassword(password);
        parameters.setUserId(userId);
        try {
            Session session = new Configuration().configure().buildSessionFactory().openSession();

            Criteria cr = session.createCriteria(UserDetails.class);

            String userIdType = parameters.getUserId().contains("@") ? "email" : "phoneNumber";
            cr.add(Restrictions.eq(userIdType, parameters.getUserId()));
            cr.add(Restrictions.eq("password", parameters.getPassword()));
            List results = cr.list();
            for (Object result : results) {
                UserDetails userDetails = (UserDetails) result;

                System.out.println("\nemail: " + userDetails.getEmail());
                System.out.println("name: " + userDetails.getName());
                System.out.println("Phone: " + userDetails.getPhoneNumber());
            }
        } catch (QueryException e) {
            System.out.println("User is not registered");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
