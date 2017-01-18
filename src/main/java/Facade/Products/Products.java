package Facade.Products;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;

import javax.servlet.http.HttpServletResponse;

public class Products {

    public int add(AllShopItems allShopItems) {

        try{
            Session session = new Configuration().configure().buildSessionFactory().openSession();

            Transaction transaction = session.beginTransaction();
            session.persist(allShopItems);

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
        System.out.println("Item all ready registered");
    }
}
