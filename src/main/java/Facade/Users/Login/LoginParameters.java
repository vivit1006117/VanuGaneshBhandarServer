package Facade.Users.Login;

import Facade.Miscellaneous.EncryptAndDecrypt;

class LoginParameters {
    private String userId;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() throws Exception {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
