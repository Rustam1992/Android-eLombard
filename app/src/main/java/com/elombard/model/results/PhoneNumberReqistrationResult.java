package com.elombard.model.results;

public class PhoneNumberReqistrationResult {
   private String token;


    public PhoneNumberReqistrationResult(String s, String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
