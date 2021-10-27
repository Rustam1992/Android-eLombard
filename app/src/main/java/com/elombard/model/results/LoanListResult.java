package com.elombard.model.results;

import java.util.Date;
import java.util.List;

public class LoanListResult {
    private List<Loan> loanList;

    public LoanListResult(List<Loan> loanList) {
        this.loanList = loanList;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }
}














