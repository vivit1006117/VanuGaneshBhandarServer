package Tables;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;

import javax.servlet.http.HttpServletResponse;

public class BaseTable {

    public int addToTable() {

        try {
            Session session = new Configuration().configure().buildSessionFactory().openSession();

            Transaction transaction = session.beginTransaction();
            session.persist(this);

            transaction.commit();
            session.close();

            return HttpServletResponse.SC_OK;
        } catch (ConstraintViolationException e) {
            return HttpServletResponse.SC_CONFLICT;
        } catch (Exception e) {
            return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        }
    }
}

