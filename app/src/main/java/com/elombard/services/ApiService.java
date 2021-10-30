package com.elombard.services;

import com.elombard.model.requests.CreateLoanPaymentRequest;
import com.elombard.model.requests.DefaultRequest;
import com.elombard.model.requests.LoanDebtRequest;
import com.elombard.model.requests.LoanDebtSendSMSRequest;
import com.elombard.model.requests.LoanDebtWithSMSRequest;
import com.elombard.model.requests.PhoneBySMSREquest;

import com.elombard.model.requests.LoanDebt;

import com.elombard.model.requests.SendSMSRequest;
import com.elombard.model.requests.AuthRequest;
import com.elombard.model.results.ClientInfoResult;
import com.elombard.model.results.ResponseData;
import com.elombard.model.results.AuthResult;
import com.elombard.model.results.LoanListResult;
import com.elombard.model.results.LoanDebtResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {


    /**
     * Отправляет смс с кодом подтверждения
     */
    @POST("ClientAuth/SendSMS/MaxKSUser")
    Call<ResponseData<Void>> sendSMS(@Body SendSMSRequest s);

    /**
     * Авторизация по номеру телефона и паролю
     */
    @POST("ClientAuth/PhonePwd/MaxKSUser")
    Call<ResponseData<AuthResult>> loginByPhoneNumber(@Body PhoneBySMSREquest r);

    /**
     * Проверка кода подтверждения на корректность
     */
    @POST("ClientAuth/PhoneBySMS/MaxKSUser")
    Call<ResponseData<AuthResult>> confirmCode(@Body AuthRequest v);

    /**
     * Запрос задолженности в один этап
     */
    @POST("Lombard/LoanDebt/MaxKSUser")
    Call<ResponseData<LoanDebtResult>> loanDebt(@Body LoanDebtRequest r);

    /**
     * Запрос задолженности: Отправка СМС на номер
     */
    @POST("LoanDebtSendSMS/MaxKSUser")
    Call<ResponseData<Void>> loanDebtSendSMS(@Body LoanDebtSendSMSRequest s);

    /**
     * Запрос задолженности: Проверка кода подтверждения из СМС
     */
    @POST("LoanDebtWithCodeSMS/MaxKSUser")
    Call<ResponseData<LoanDebtResult>> loanDebtConfirmCode(@Body LoanDebtWithSMSRequest l);

    /**
     * Создание операции пролонгации займа
     */
    @POST("CreateLoanPayment/MaxKSUser")
    Call<ResponseData<LoanDebtResult>> createLoanPayment(@Body CreateLoanPaymentRequest c);

    /**
     * Получение сведения по клиенту
     */
    @POST("Client/Info/MaxKSUser")
    Call<ResponseData<ClientInfoResult>> getClientInfo(@Body DefaultRequest g);

    /**
     * Получение спика займов клиента
         */
    @POST("Lombard/LoanList/MaxKSUser")
    Call<ResponseData<LoanListResult>> getLoans(@Body DefaultRequest d);


}

