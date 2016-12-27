package Facade.Login;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;

class Register {

    public static void registerUsersData() {

        try{
            Session session = new Configuration().configure().buildSessionFactory().openSession();

            Transaction t = session.beginTransaction();

            UserDetails userDetails = new UserDetails();
            userDetails.setEmail("asasa@xcdsfg.com");
            userDetails.setPassword("password");
            userDetails.setPhoneNumber("96800048");
            userDetails.setName("vivek");

            session.persist(userDetails);

            t.commit();
            session.close();
            System.out.println("successfully saved");
        }catch (ConstraintViolationException e){
            userAllReadyRegisteredMessage();
        }
    }

    private static void userAllReadyRegisteredMessage() {
        System.out.println("User All Ready Registered with same emailId or Phone number");
    }
}
