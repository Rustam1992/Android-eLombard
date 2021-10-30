package com.elombard.model.requests;

public class PhoneBySMSREquest {
    private String phone;
    private String confirmCode;

    public PhoneBySMSREquest(String phone, String confirmCode) {
        this.phone = phone;
        this.confirmCode = confirmCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }
}
