package com.elombard.services;

import android.util.Log;

import com.elombard.interfaces.Consumer;
import com.elombard.interfaces.Single;
import com.elombard.model.results.AuthResult;
import com.elombard.model.results.Error;
import com.elombard.model.results.ResponseData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleResponseCallBack<T extends ResponseData> implements Callback<T> {
    Single<T> f;
    Consumer<T> c;


    public SingleResponseCallBack(Single<T> f) {
        this.f = f;
    }

    public SingleResponseCallBack(Consumer<T> c) {
        this.c = c;
        this.f = new Single<T>() {
            @Override
            public void send(T t) {
                c.accept(t);
            }

            @Override
            public void success() {

            }

            @Override
            public void failure(Error e) {

            }


        };
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.body() != null) {
            List<Error> errors = response.body().errors;
            if (errors != null) {
                logErrors(errors);
                f.failure(errors.get(0));
            } else {
                f.send(response.body());
                f.success();
            }
        }
    }


    @Override
    public void onFailure(Call<T> call, Throwable t) {


    }

    private void logErrors(List<Error> errors) {
        errors.forEach(e -> {
            Log.i("M5", e.toString());
        });
    }
}

