package com.elombard;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testObjJson() {
        Gson gson = new Gson();
        LoanRequest loanTest = new LoanRequest("eyG", "201140020349", "980114300171", 6002744L);
        System.out.println(gson.toJson(loanTest));
    }



    @Test
    public void testRetrofitController2() throws InterruptedException {

        //RetrofitController r = new RetrofitController();
        String phoneNumber = "87776573581";
        SendSMSRequest request = new SendSMSRequest(phoneNumber);
        CountDownLatch waitForSmsResult= new CountDownLatch(1);
        //r.sendSms(request);
        waitForSmsResult.await();
    }

}