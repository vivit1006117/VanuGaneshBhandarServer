package Facade.Login;

import Facade.Miscellaneous.EncryptAndDecrypt;
import Facade.Registration.Register;
import Facade.Registration.UserDetails;

class toTest {
    public static void main(String args[]) throws Exception {


        Register register = new Register();
        EncryptAndDecrypt encryptAndDecrypter = new EncryptAndDecrypt();
        String password = encryptAndDecrypter.encrypt("password");
        System.out.println(password);
        UserDetails userDetails = new UserDetails("vivi@xcdsfg.com", "968600048", password, "vivek");
        register.registerUsersData(userDetails);



        final LoginParameters parameters = new LoginParameters();

        Login login = new Login();
        login.findUser("968600048", password);
    }
}