package com.elombard.services;

import com.elombard.model.requests.DefaultRequest;
import com.elombard.model.requests.GetOverDraftByLoanIdRequest;
import com.elombard.model.requests.LoanDebtSendSMSRequest;
import com.elombard.model.requests.LoginByPhoneNumberRequest;

import com.elombard.model.requests.LoanDebt;

import com.elombard.model.requests.SendSMSRequest;
import com.elombard.model.requests.AuthRequest;
import com.elombard.model.results.ClientInfoResult;
import com.elombard.model.results.LoanDebtSendSMSResult;
import com.elombard.model.results.ResponseData;
import com.elombard.model.results.AuthResult;
import com.elombard.model.results.LoanListResult;
import com.elombard.model.results.OverDraft;
import com.elombard.model.results.ProlongationResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("Lombard/LoanDebt/MaxKSUser")
    Call<ResponseData<OverDraft>> loanDebt(@Body GetOverDraftByLoanIdRequest r);


    @POST("ClientAuth/PhoneBySMS/MaxKSUser")
    Call<ResponseData<AuthResult>> confirmCode(@Body AuthRequest v);

    @POST("Lombard/LoanList/MaxKSUser")
    Call<ResponseData<LoanListResult>> getLoans(@Body DefaultRequest d);

    @POST("LoanDebt/MaxKSUser")
    Call<ResponseData<ProlongationResult>> createLoanProlongation(@Body LoanDebt r);

    @POST("ClientAuth/PhonePwd/MaxKSUser")
    Call<ResponseData<AuthResult>> loginByPhoneNumber(@Body LoginByPhoneNumberRequest r);

    @POST("ClientAuth/SendSMS/MaxKSUser")
    Call<Void> sendSMS(@Body SendSMSRequest s);


    @POST("Client/Info/MaxKSUser")
    Call<ResponseData<ClientInfoResult>> getClientInfo(@Body DefaultRequest g);

    @POST("LoanDebtSendSMS/MaxKSUser")
    Call<ResponseData<LoanDebtSendSMSResult>> getLoanDebtInfo(@Body LoanDebtSendSMSRequest l);

}

