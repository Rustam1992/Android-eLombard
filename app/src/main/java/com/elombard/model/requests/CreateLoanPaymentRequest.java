package com.elombard.model.requests;

public class CreateLoanPaymentRequest extends DefaultRequest {
    private String orgBIN;
    private Long pawnTickedNumber;
    private int newPeriod;
    private String referenceId;

    public String getOrgBIN() {
        return orgBIN;
    }

    public void setOrgBIN(String orgBIN) {
        this.orgBIN = orgBIN;
    }

    public Long getPawnTickedNumber() {
        return pawnTickedNumber;
    }

    public void setPawnTickedNumber(Long pawnTickedNumber) {
        this.pawnTickedNumber = pawnTickedNumber;
    }

    public int getNewPeriod() {
        return newPeriod;
    }

    public void setNewPeriod(int newPeriod) {
        this.newPeriod = newPeriod;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public CreateLoanPaymentRequest(String token, String orgBIN, Long pawnTickedNumber, int newPeriod, String referenceId) {
        super(token);
        this.orgBIN = orgBIN;
        this.pawnTickedNumber = pawnTickedNumber;
        this.newPeriod = newPeriod;
        this.referenceId = referenceId;

    }
}
