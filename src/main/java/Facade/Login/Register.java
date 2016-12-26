package Facade.Login;

import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;

class Register {

    public static void registerUsersData() {

        try{
            Session session = new AnnotationConfiguration().configure("hibernatePostgres.cfg.xml").buildSessionFactory().openSession();

            Transaction t = session.beginTransaction();

            UserDetails userDetails = new UserDetails();
            userDetails.setEmail("asasa@xcsfg.com");
            userDetails.setPassword("password");
            userDetails.setPhoneNumber("9680003489");
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
