package Facade.Miscellaneous;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static final String JDBC_POSTGRESQL_LOCALHOST_5433_POSTGRES = "jdbc:postgresql://localhost:5433/postgres";
    private static final String ORG_POSTGRESQL_DRIVER = "org.postgresql.Driver";
    private static final String USER = "ganesh";
    private static final String PASSWORD = "ganesh";

    public Connection MakeConnectionToDatabase() throws ClassNotFoundException, SQLException {
        Connection connection;
        Class.forName(ORG_POSTGRESQL_DRIVER);
        connection = DriverManager.getConnection(JDBC_POSTGRESQL_LOCALHOST_5433_POSTGRES, USER, PASSWORD);
        System.out.println("Connected database successfully...");
        return connection;
    }
}