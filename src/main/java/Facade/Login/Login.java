package Facade.Login;

import Facade.Miscellaneous.Connector;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Login {

    private final LoginParameters parameters = new LoginParameters();
    private final UserDetails userDetails = new UserDetails();

    public void findUser() {
        Connector makeConn = new Connector();
        Connection connection;
        Statement stmt;
        try {
            connection = makeConn.MakeConnectionToDatabase();
            stmt = connection.createStatement();
            try {
                ResultSet resultSet = getUserDetails(stmt);
                while(resultSet.next()){
                    setUserDetails(resultSet);

                    //Display values
                    System.out.println("\nemail: " + userDetails.getEmail());
                    System.out.println("name: " + userDetails.getName());
                    System.out.println("Phone: " + userDetails.getPhoneNumber());
                }
            }catch (PSQLException e){
                if(e.getMessage().contains("does not exist")){
                    System.out.println("User is not registered");
                }else {
                    System.out.println(e.getMessage());
                }
            }
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private void setUserDetails(ResultSet resultSet) throws SQLException {
        userDetails.setEmail(resultSet.getString("Email"));
        userDetails.setName(resultSet.getString("Name"));
        userDetails.setPhoneNumber(resultSet.getString("phoneNumber"));
    }

    private ResultSet getUserDetails(Statement stmt) throws SQLException {
        parameters.setPassword("password");
        parameters.setUserId("'96800048'");
        String selectFrom = "SELECT * FROM USERDETAILS WHERE";
        String userId = parameters.getUserId().contains("@") ? " Email =" + parameters.getUserId() : " phoneNumber =" + parameters.getUserId();
        String password = "password =" + parameters.getPassword();
        String sql = selectFrom + userId + " AND " + password;
        System.out.println(sql);
        return stmt.executeQuery(sql);
    }
}
