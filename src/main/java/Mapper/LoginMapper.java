package Mapper;

import Facade.Miscellaneous.EncryptAndDecrypt;

public class LoginMapper {
    private String userId;
    private String password;

    public LoginMapper() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() throws Exception {
        return EncryptAndDecrypt.encrypt(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
