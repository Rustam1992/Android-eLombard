package com.elombard.model.requests;

public class AuthRequest {
    String login;
    String password;

    public AuthRequest(String phone, String password) {
        this.login = phone;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
