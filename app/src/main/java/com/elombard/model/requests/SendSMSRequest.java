package com.elombard.model.requests;

public class SendSMSRequest {
    private String phone;

    public SendSMSRequest(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
