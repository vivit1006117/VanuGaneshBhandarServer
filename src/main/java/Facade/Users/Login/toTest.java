package Facade.Users.Login;

import Facade.Miscellaneous.EncryptAndDecrypt;
import Tables.UserDetails;

class toTest {
    public static void main(String args[]) throws Exception {

        String password = EncryptAndDecrypt.encrypt("password");
        System.out.println(password);
        UserDetails userDetails = new UserDetails("vivi@xcdsfg.com", "968600048", password, "vivek");
        userDetails.addToTable();

        Login login = new Login();
        login.findUser("968600048", password);
    }
}