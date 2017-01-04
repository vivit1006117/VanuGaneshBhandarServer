package Facade.Login;

import Facade.Registration.Register;
import Facade.Registration.UserDetails;

class toTest {
    public static void main(String args[]) {


        Register register = new Register();
        UserDetails userDetails = new UserDetails("vivi@xcdsfg.com", "968600048", "password", "vivek");
        register.registerUsersData(userDetails);



        Login login = new Login();
        login.findUser("'96800048'", "password");
    }
}
