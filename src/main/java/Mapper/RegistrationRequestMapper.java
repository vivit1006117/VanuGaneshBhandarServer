package Mapper;

import Facade.Miscellaneous.EncryptAndDecrypt;

public class RegistrationRequestMapper{

    private String email;
    private String phoneNumber;
    private String password;
    private String name;

    public RegistrationRequestMapper(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() throws Exception {
        return EncryptAndDecrypt.encrypt(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
