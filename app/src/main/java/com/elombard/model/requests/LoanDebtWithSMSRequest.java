package com.elombard.model.requests;

public class LoanDebtWithSMSRequest extends LoanDebtSendSMSRequest{
   private String confirmCode;

   public LoanDebtWithSMSRequest(String token, String orgBIN, String clientIIN, Long pawnTicketNumber, String confirmCode) {
      super(token, orgBIN, clientIIN, pawnTicketNumber);
      this.confirmCode = confirmCode;
   }



   public LoanDebtWithSMSRequest(String token) {
      super(token);
   }

   public String getConfirmCode() {
      return confirmCode;
   }

   public void setConfirmCode(String confirmCode) {
      this.confirmCode = confirmCode;
   }
}
