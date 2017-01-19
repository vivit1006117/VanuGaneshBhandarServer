package Tables;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseTable {

    public ResponseEntity addToTable() {

        try {
            Session session = new Configuration().configure().buildSessionFactory().openSession();

            Transaction transaction = session.beginTransaction();
            session.persist(this);

            transaction.commit();
            session.close();

            return new ResponseEntity(HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

