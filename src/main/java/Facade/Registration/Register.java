package Facade.Registration;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;

import javax.servlet.http.HttpServletResponse;

public class Register {

    public int registerUsersData(UserDetails userDetails) {

        try{
            Session session = new Configuration().configure().buildSessionFactory().openSession();

            Transaction transaction = session.beginTransaction();
            session.persist(userDetails);

            transaction.commit();
            session.close();

            System.out.println("successfully saved");
            return HttpServletResponse.SC_OK;
        }catch (ConstraintViolationException e) {
            userAllReadyRegisteredMessage();
            return HttpServletResponse.SC_CONFLICT;
        }catch (Exception e){
            System.out.println("Some Error has occurred");
            return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        }
    }

    private static void userAllReadyRegisteredMessage() {
        System.out.println("User All Ready Registered with same emailId or Phone number");
    }
}