package com.elombard.model.results;


public class LoanDebtResult {

    private Integer creditSum;
    private Integer percentSum;
    private Integer totalSum;
    private String returnDate;
    private String guaranteeDate;


    public LoanDebtResult(Integer creditSum, Integer percentSum, Integer totalSum, String returnDate, String guaranteeDate) {
        this.creditSum = creditSum;
        this.percentSum = percentSum;
        this.totalSum = totalSum;
        this.returnDate = returnDate;
        this.guaranteeDate = guaranteeDate;
    }

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

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
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
}

