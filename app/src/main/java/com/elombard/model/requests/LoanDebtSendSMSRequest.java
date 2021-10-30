package com.elombard.model.requests;

public class LoanDebtSendSMSRequest extends DefaultRequest{
    private String orgBIN;
    private String clientIIN;
    private Long pawnTicketNumber;


    public LoanDebtSendSMSRequest(String token, String orgBIN, String clientIIN, Long pawnTicketNumber) {
        super(token);
        this.orgBIN = orgBIN;
        this.clientIIN = clientIIN;
        this.pawnTicketNumber = pawnTicketNumber;
    }

    public LoanDebtSendSMSRequest(String token) {
        super(token);
    }

    public String getOrgBIN() {
        return orgBIN;
    }

    public void setOrgBIN(String orgBIN) {
        this.orgBIN = orgBIN;
    }

    public String getClientIIN() {
        return clientIIN;
    }

    public void setClientIIN(String clientIIN) {
        this.clientIIN = clientIIN;
    }

    public Long getPawnTicketNumber() {
        return pawnTicketNumber;
    }

    public void setPawnTicketNumber(Long pawnTicketNumber) {
        this.pawnTicketNumber = pawnTicketNumber;
    }
}
