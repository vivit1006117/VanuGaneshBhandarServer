package Facade.Login;

import Facade.Registeration.Register;

class toTest {
    public static void main(String args[]) {
        Register.registerUsersData();
        Login login = new Login();
        login.findUser("'96800048'", "password");
    }
}
