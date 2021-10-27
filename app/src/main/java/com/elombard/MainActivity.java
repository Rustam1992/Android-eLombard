package com.elombard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.elombard.model.results.ClientInfoResult;
import com.elombard.services.RetrofitController;
import com.elombard.ui.ListLoansFragment;

public class MainActivity extends AppCompatActivity {
    public RetrofitController r;
    private ClientInfoResult clientInfoResult;

    public ClientInfoResult getClientInfoResult() {
        return clientInfoResult;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new RetrofitController(this);
        String token = getIntent().getExtras().getString("_key0_");
        r.setToken(token);
        r.getClientInfo(token, getClientInfoResultResponseData -> {
            clientInfoResult = getClientInfoResultResponseData.data;

        });
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root, new ListLoansFragment())
                .addToBackStack(null)
                .commit();


    }

}