package Login;

import Miscellaneous.MakeConnection;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class Register {

    public static void registerUsersData() {
        MakeConnection makeConn = new MakeConnection();
        Connection connection;
        Statement stmt;
        try {
            connection = makeConn.MakeConnectionToDatabase();
            stmt = connection.createStatement();
            try {
                insertUserDetails(stmt);
            }catch (PSQLException e){
                if(e.getMessage().contains("already exists")) userAllReadyRegistered();
                else if(e.getMessage().contains("does not exist")) CreateUsersTable(stmt);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private static void userAllReadyRegistered() {
        System.out.println("User All Ready Registered with same emailId or Phone number");
    }

    private static void CreateUsersTable(Statement stmt) throws SQLException {
        String sql = "CREATE TABLE USERS " +
            "(Name VARCHAR(255) not NULL, " +
            " Email VARCHAR(255), " +
            " password VARCHAR(255), " +
            " phoneNumber BIGINT, " +
            " PRIMARY KEY ( Email, phoneNumber ))";
        stmt.executeUpdate(sql);

        insertUserDetails(stmt);
    }

    private static void insertUserDetails(Statement stmt) throws SQLException {
        String sql = "INSERT INTO USERS " +
                "VALUES ('vivek', 'asasa@xcsc.com', 'password', 9680002349)";
        stmt.executeUpdate(sql);
    }
}
