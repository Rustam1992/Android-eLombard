package com.elombard.model.results;

import java.util.Date;

public class ProlongationResult {
    private String clientName;
    private Long creditSum;
    private Long interestSum;
    private Long penaltySum;
    private Long penaltyDays;
    private Long totalSum;
    private String returnDate;
    private String guaranteeDate;
    private String minPeriod;
    private String maxPeriod;

    public ProlongationResult(String clientName, Long creditSum, Long interestSum, Long penaltySum, Long penaltyDays, Long totalSum, String returnDate, String guaranteeDate, String minPeriod, String maxPeriod) {
        this.clientName = clientName;
        this.creditSum = creditSum;
        this.interestSum = interestSum;
        this.penaltySum = penaltySum;
        this.penaltyDays = penaltyDays;
        this.totalSum = totalSum;
        this.returnDate = returnDate;
        this.guaranteeDate = guaranteeDate;
        this.minPeriod = minPeriod;
        this.maxPeriod = maxPeriod;
    }

    public ProlongationResult() {
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(Long creditSum) {
        this.creditSum = creditSum;
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

    public Long getPenaltyDays() {
        return penaltyDays;
    }

    public void setPenaltyDays(Long penaltyDays) {
        this.penaltyDays = penaltyDays;
    }

    public Long getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Long totalSum) {
        this.totalSum = totalSum;
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

    public String getMinPeriod() {
        return minPeriod;
    }

    public void setMinPeriod(String minPeriod) {
        this.minPeriod = minPeriod;
    }

    public String getMaxPeriod() {
        return maxPeriod;
    }

    public void setMaxPeriod(String maxPeriod) {
        this.maxPeriod = maxPeriod;
    }
}
