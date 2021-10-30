package com.elombard.services;

import android.content.Context;

import com.elombard.interfaces.Consumer;
import com.elombard.interfaces.Single;
import com.elombard.model.requests.AuthRequest;
import com.elombard.model.requests.CreateLoanPaymentRequest;
import com.elombard.model.requests.DefaultRequest;
import com.elombard.model.requests.LoanDebtRequest;
import com.elombard.model.requests.LoanDebtSendSMSRequest;
import com.elombard.model.requests.LoanDebtWithSMSRequest;
import com.elombard.model.requests.PhoneBySMSREquest;
import com.elombard.model.results.AuthResult;
import com.elombard.model.results.ClientInfoResult;
import com.elombard.model.results.LoanDebtResult;
import com.elombard.model.results.LoanListResult;
import com.elombard.model.results.ResponseData;
import com.mklimek.sslutilsandroid.SslUtils;

import java.util.Collections;

import javax.net.ssl.SSLContext;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitController {

    private Retrofit r;
    private String token;
    private ApiService api;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RetrofitController(Context context) {
        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .allEnabledCipherSuites()
                .allEnabledTlsVersions()
                .build();
        SSLContext sslContext = SslUtils.getSslContextForCertificateFile(context, "elombard.cer");
        OkHttpClient testClient = new OkHttpClient.Builder()
                .connectionSpecs(Collections.singletonList(spec))
                .sslSocketFactory(sslContext.getSocketFactory())
                .build();

        r = new Retrofit.Builder()
                .baseUrl("https://api.elombard.kz:53126/Api/")
                .client(testClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = r.create(ApiService.class);
    }


    public void loanDebt(String orgBIN, String clientIIN, Long pawnTicketNumber, Consumer<ResponseData<LoanDebtResult>> f) {
        LoanDebtRequest request = new LoanDebtRequest(token, orgBIN, clientIIN, pawnTicketNumber);
        api.loanDebt(request).enqueue(new SingleResponseCallBack<>(f));
    }


    public void loginByPhone(String phone, String password, Consumer<ResponseData<AuthResult>> p) {
        PhoneBySMSREquest phoneBySMSREquest = new PhoneBySMSREquest(phone, password);
        api.loginByPhoneNumber(phoneBySMSREquest).enqueue(new SingleResponseCallBack<>(p));

    }


    public void getClientInfo(String token, Consumer<ResponseData<ClientInfoResult>> g) {
        DefaultRequest defaultRequest = new DefaultRequest(token);
        api.getClientInfo(defaultRequest).enqueue(new SingleResponseCallBack<>(g));
    }

    public void confirm(AuthRequest v, Single<ResponseData<AuthResult>> f) {
        api.confirmCode(v).enqueue(new SingleResponseCallBack<>(f));
    }

    public void getLoans(Consumer<ResponseData<LoanListResult>> f) {
        DefaultRequest d = new DefaultRequest(token);
        api.getLoans(d).enqueue(new SingleResponseCallBack<>(f));
    }


    public void createLoanPayment(String orgBIN, Long pawnTickedNumber, int newPeriod, String referenceId, Consumer<ResponseData<LoanDebtResult>> resultConsumer) {
        CreateLoanPaymentRequest request = new CreateLoanPaymentRequest(token, orgBIN, pawnTickedNumber, newPeriod, referenceId);
        api.createLoanPayment(request).enqueue(new SingleResponseCallBack<>(resultConsumer));

    }

    public void loanDebtSendSMS(String orgBIN, String clientIIN, Long pawnTicketNumber) {
        LoanDebtSendSMSRequest loanDebtSendSMSRequest = new LoanDebtSendSMSRequest(token, orgBIN, clientIIN, pawnTicketNumber);
        api.loanDebtSendSMS(loanDebtSendSMSRequest).enqueue(new SingleResponseCallBack<>(voidResponseData -> {
        }));
    }


    public void loanDebtWithCodeSMS(String orgBIN, String clientIIN, Long pawnTicketNumber, String confirmCode, Consumer<ResponseData<LoanDebtResult>> p) {
        LoanDebtWithSMSRequest loanDebtWithSMSRequest = new LoanDebtWithSMSRequest(token, orgBIN, clientIIN, pawnTicketNumber, confirmCode);
        api.loanDebtConfirmCode(loanDebtWithSMSRequest).enqueue(new SingleResponseCallBack<>(p));
    }


}
