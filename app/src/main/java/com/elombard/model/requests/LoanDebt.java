package com.elombard.model.requests;

import android.widget.TextView;

public class LoanDebt extends DefaultRequest {

    private Long loanId;
    private int newPeriod;
    private Long mainDebtSum;

    public LoanDebt(Long loanId, int newPeriod, Long mainDebtSum) {
        super("");
        this.loanId = loanId;
        this.newPeriod = newPeriod;
        this.mainDebtSum = mainDebtSum;
    }


    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public int getNewPeriod() {
        return newPeriod;
    }

    public void setNewPeriod(int newPeriod) {
        this.newPeriod = newPeriod;
    }

    public Long getMainDebtSum() {
        return mainDebtSum;
    }

    public void setMainDebtSum(Long mainDebtSum) {
        this.mainDebtSum = mainDebtSum;
    }
}
