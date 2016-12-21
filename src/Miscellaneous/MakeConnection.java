package Miscellaneous;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakeConnection {

    public Connection MakeConnectionToDatabase() throws ClassNotFoundException, SQLException {
        Connection connection;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "ganesh", "ganesh");
        System.out.println("Connected database successfully...");
        return connection;
    }
}
