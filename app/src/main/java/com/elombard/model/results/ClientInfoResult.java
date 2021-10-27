package com.elombard.model.results;

public class ClientInfoResult {
    private Long id;
    private String name;
    private String iin;
    private String documentNumber;
    private int sex;
    private String birthDate;
    private String eMail;
    private String phone;

    public ClientInfoResult(Long id, String name, String iin, String documentNumber, int sex, String birthDate, String eMail, String phone) {
        this.id = id;
        this.name = name;
        this.iin = iin;
        this.documentNumber = documentNumber;
        this.sex = sex;
        this.birthDate = birthDate;
        this.eMail = eMail;
        this.phone = phone;
    }

    public ClientInfoResult() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
