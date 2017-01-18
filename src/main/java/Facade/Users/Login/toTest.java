package Facade.Users.Login;

import Facade.Miscellaneous.EncryptAndDecrypt;
import Facade.Users.Registration.Register;
import Facade.Users.Registration.UserDetails;

class toTest {
    public static void main(String args[]) throws Exception {


        Register register = new Register();
        String password = EncryptAndDecrypt.encrypt("password");
        System.out.println(password);
        UserDetails userDetails = new UserDetails("vivi@xcdsfg.com", "968600048", password, "vivek");
        register.registerUsersData(userDetails);

        Login login = new Login();
        login.findUser("968600048", password);
    }
}