package com.elombard.model.results;

public class AuthResult {
   private String token;

    public AuthResult(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
