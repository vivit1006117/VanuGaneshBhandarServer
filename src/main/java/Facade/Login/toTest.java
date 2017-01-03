package Facade.Login;

import Facade.Registration.Register;

class toTest {
    public static void main(String args[]) {
        Register register = new Register();
        register.registerUsersData();
        Login login = new Login();
        login.findUser("'96800048'", "password");
    }
}
