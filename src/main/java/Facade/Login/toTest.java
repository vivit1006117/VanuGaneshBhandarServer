package Facade.Login;

class toTest {
    public static void main(String args[]) {
        Register.registerUsersData();
        Login login = new Login();
        login.findUser();
    }
}
