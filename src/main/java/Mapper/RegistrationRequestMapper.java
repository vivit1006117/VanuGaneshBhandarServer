package Mapper;

import com.fasterxml.jackson.annotation.JsonSetter;

public class RegistrationRequestMapper{

    private String email;
    private String phoneNumber;
    private String password;
    private String name;

    public RegistrationRequestMapper(String[] parameters) {
        setEmail(parameters[0]);
        setPhoneNumber(parameters[1]);
        setPassword(parameters[2]);
        setName(parameters[3]);
    }

//    public RegistrationRequestMapper(String email, String phoneNumber, String password, String name){
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.password = password;
//        this.name = name;
//    }

    public String getEmail() {
        return email;
    }

    @JsonSetter
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonSetter
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }
}
