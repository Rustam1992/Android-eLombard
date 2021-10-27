package com.elombard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.elombard.interfaces.Single;
import com.elombard.model.requests.SendSMSRequest;
import com.elombard.model.requests.AuthRequest;
import com.elombard.model.results.AuthResult;
import com.elombard.model.results.Error;
import com.elombard.model.results.ResponseData;
import com.elombard.services.RetrofitController;
import com.google.android.material.textfield.TextInputLayout;

import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.parser.PhoneNumberUnderscoreSlotsParser;
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser;
import ru.tinkoff.decoro.slots.Slot;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

public class AuthActivity extends AppCompatActivity {

    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        RetrofitController controller = new RetrofitController(getApplicationContext());

        TextInputLayout inputNumber = findViewById(R.id.inputNumber);
        inputNumber.getEditText().setText("");
        Button sent = findViewById(R.id.sent);
        TextInputLayout sms = findViewById(R.id.sms);
        Button login = findViewById(R.id.login);
        TextView loginByPhone = findViewById(R.id.login_by_phone);

        Slot[] slots = new PhoneNumberUnderscoreSlotsParser().parseSlots("+7__________");
        FormatWatcher formatWatcherPhoneNumber = new MaskFormatWatcher( // форматировать текст будет вот он
                MaskImpl.createTerminated(slots)
        );
        formatWatcherPhoneNumber.installOn(inputNumber.getEditText());

        Slot[] slot2 = new UnderscoreDigitSlotsParser().parseSlots("______");
        FormatWatcher formatWatcherCvv = new MaskFormatWatcher( // форматировать текст будет вот он
                MaskImpl.createTerminated(slot2)
        );
        formatWatcherCvv.installOn(sms.getEditText());

        sent.setOnClickListener(e -> {
            String phoneNumber = inputNumber.getEditText().getText().toString();
            Log.i("M5", phoneNumber);
            SendSMSRequest request = new SendSMSRequest(phoneNumber);
            controller.sendSms(request);

        });


        login.setOnClickListener(e -> {
            AuthRequest verify = new AuthRequest(inputNumber.getEditText().getText().toString(), sms.getEditText().getText().toString());
            controller.confirm(verify, new Single<ResponseData<AuthResult>>() {

                @Override
                public void send(ResponseData<AuthResult> authResult) {
                    token = authResult.data.getToken();
                    Log.i("M5", "token:" + token);
                }

                @Override
                public void success() {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("_key0_", token);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void failure(Error e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG)
                            .show();
                }
            });
        });

        loginByPhone.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginByPhoneActivity.class);
            startActivity(intent);
            finish();
        });

        //87776573581


    }
}