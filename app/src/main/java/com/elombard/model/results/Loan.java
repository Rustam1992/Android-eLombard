package com.elombard.model.results;

import com.elombard.model.enums.Status;

public class Loan {
    private Long id;
    private String issueDate;
    private String returnDate;
    private String guaranteeDate;
    private Long creditSum;
    private String lastPaymentDate;
    private int creditPeriod;
    private Long saldoSum;
    private Long interestSum;
    private Long penaltySum;
    private Long totalSum;
    private Long totalSumOnReturnDate;
    private String status;


    public Loan(Long id, String issueDate, String returnDate, String guaranteeDate, Long creditSum, String lastPaymentDate, int creditPeriod, Long saldoSum, Long interestSum, Long penaltySum, Long totalSum, Long totalSumOnReturnDate, String status) {
        this.id = id;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.guaranteeDate = guaranteeDate;
        this.creditSum = creditSum;
        this.lastPaymentDate = lastPaymentDate;
        this.creditPeriod = creditPeriod;
        this.saldoSum = saldoSum;
        this.interestSum = interestSum;
        this.penaltySum = penaltySum;
        this.totalSum = totalSum;
        this.totalSumOnReturnDate = totalSumOnReturnDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getGuaranteeDate() {
        return guaranteeDate;
    }

    public void setGuaranteeDate(String guaranteeDate) {
        this.guaranteeDate = guaranteeDate;
    }

    public Long getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(Long creditSum) {
        this.creditSum = creditSum;
    }

    public String getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(String lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public int getCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(int creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    public Long getSaldoSum() {
        return saldoSum;
    }

    public void setSaldoSum(Long saldoSum) {
        this.saldoSum = saldoSum;
    }

    public Long getInterestSum() {
        return interestSum;
    }

    public void setInterestSum(Long interestSum) {
        this.interestSum = interestSum;
    }

    public Long getPenaltySum() {
        return penaltySum;
    }

    public void setPenaltySum(Long penaltySum) {
        this.penaltySum = penaltySum;
    }

    public Long getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Long totalSum) {
        this.totalSum = totalSum;
    }

    public Long getTotalSumOnReturnDate() {
        return totalSumOnReturnDate;
    }

    public void setTotalSumOnReturnDate(Long totalSumOnReturnDate) {
        this.totalSumOnReturnDate = totalSumOnReturnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
