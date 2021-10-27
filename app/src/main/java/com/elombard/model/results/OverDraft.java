package com.elombard.model.results;


public class OverDraft {

    private Integer creditSum;
    private Integer percentSum;
    private String returnDate;
    private String guaranteeDate;
    private String maxPeriod;

    public Integer getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(Integer creditSum) {
        this.creditSum = creditSum;
    }

    public Integer getPercentSum() {
        return percentSum;
    }

    public void setPercentSum(Integer percentSum) {
        this.percentSum = percentSum;
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

    public String getMaxPeriod() {
        return maxPeriod;
    }

    public void setMaxPeriod(String maxPeriod) {
        this.maxPeriod = maxPeriod;
    }
}

