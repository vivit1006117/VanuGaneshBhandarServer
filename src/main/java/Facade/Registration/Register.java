package Facade.Registration;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;

public class Register {

    public void registerUsersData(UserDetails userDetails) {

        try{
            Session session = new Configuration().configure().buildSessionFactory().openSession();

            Transaction transaction = session.beginTransaction();
            session.persist(userDetails);

            transaction.commit();
            session.close();

            System.out.println("successfully saved");
        }catch (ConstraintViolationException e) {
            userAllReadyRegisteredMessage();
        }catch (Exception e){
            System.out.println("Some Error has occurred");
            System.out.println(e);
        }
    }

    private static void userAllReadyRegisteredMessage() {
        System.out.println("User All Ready Registered with same emailId or Phone number");
    }
}
