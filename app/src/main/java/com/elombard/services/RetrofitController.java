package com.elombard.services;

import android.content.Context;

import com.elombard.interfaces.Consumer;
import com.elombard.interfaces.Single;
import com.elombard.model.requests.DefaultRequest;
import com.elombard.model.requests.GetOverDraftByLoanIdRequest;
import com.elombard.model.requests.LoanDebt;
import com.elombard.model.requests.LoanDebtSendSMSRequest;
import com.elombard.model.requests.LoginByPhoneNumberRequest;
import com.elombard.model.requests.SendSMSRequest;
import com.elombard.model.requests.AuthRequest;
import com.elombard.model.results.AuthResult;
import com.elombard.model.results.ClientInfoResult;
import com.elombard.model.results.LoanDebtSendSMSResult;
import com.elombard.model.results.LoanListResult;
import com.elombard.model.results.OverDraft;
import com.elombard.model.results.ProlongationResult;
import com.elombard.model.results.ResponseData;
import com.mklimek.sslutilsandroid.SslUtils;


import java.util.Collections;

import javax.net.ssl.SSLContext;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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


    public void loanDebt(String orgBIN, String clientIIN, Long pawnTicketNumber, Consumer<ResponseData<OverDraft>> f) {
        GetOverDraftByLoanIdRequest request = new GetOverDraftByLoanIdRequest(token, orgBIN,clientIIN,pawnTicketNumber);
        api.loanDebt(request).enqueue(new SingleResponseCallBack<>(f));
    }

    public void loginByPhone(String phone, String password, Consumer<ResponseData<AuthResult>> p) {
        LoginByPhoneNumberRequest loginByPhoneNumberRequest = new LoginByPhoneNumberRequest(phone, password);
        api.loginByPhoneNumber(loginByPhoneNumberRequest).enqueue(new SingleResponseCallBack<>(p));

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

    public void createLoanProlongation(LoanDebt request, Consumer<ResponseData<ProlongationResult>> resultConsumer) {
        request.token = token;
        api.createLoanProlongation(request).enqueue(new SingleResponseCallBack<>(resultConsumer));
    }
    public void getLoanDebtInfo(String orgBIN, String clientIIN, Long pawnTicketNumber, Consumer<ResponseData<AuthResult>> p) {
        LoanDebtSendSMSRequest loanDebtSendSMSRequest = new LoanDebtSendSMSRequest(token, orgBIN,clientIIN,pawnTicketNumber);
        api.getLoanDebtInfo(loanDebtSendSMSRequest).enqueue(new SingleResponseCallBack<ResponseData<LoanDebtSendSMSResult>>((Single<ResponseData<LoanDebtSendSMSResult>>) p));
    }


    public void sendSms(SendSMSRequest request) {
                      api.sendSMS(request).enqueue(new Callback<Void>() {
           @Override
           public void onResponse(Call<Void> call, Response<Void> response) {

           }

           @Override
           public void onFailure(Call<Void> call, Throwable t) {

           }
       });
    }
}
