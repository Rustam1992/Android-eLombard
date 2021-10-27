package com.elombard.model.results;

public class LoanDebtSendSMSResult extends ResponseData{
   private String smsSent;

    public LoanDebtSendSMSResult(String smsSent) {
        this.smsSent = smsSent;
    }

    public String getSmsSent() {
        return smsSent;
    }

    public void setSmsSent(String smsSent) {
        this.smsSent = smsSent;
    }
}
