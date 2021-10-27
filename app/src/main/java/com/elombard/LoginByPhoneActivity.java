package com.elombard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.elombard.interfaces.Single;
import com.elombard.model.results.AuthResult;
import com.elombard.model.results.Error;
import com.elombard.model.results.ResponseData;
import com.elombard.services.RetrofitController;
import com.google.android.material.textfield.TextInputLayout;

import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.parser.PhoneNumberUnderscoreSlotsParser;
import ru.tinkoff.decoro.slots.Slot;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;


public class LoginByPhoneActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_by_phone_main2);
        RetrofitController controller = new RetrofitController(getApplicationContext());

        TextInputLayout inputNumber = findViewById(R.id.inputNumber);
        inputNumber.getEditText().setText("");
        Button enter = findViewById(R.id.enter);
        TextInputLayout password = findViewById(R.id.password);


        Slot[] slots = new PhoneNumberUnderscoreSlotsParser().parseSlots("+7__________");
        FormatWatcher formatWatcherPhoneNumber = new MaskFormatWatcher( // форматировать текст будет вот он
                MaskImpl.createTerminated(slots)
        );
        formatWatcherPhoneNumber.installOn(inputNumber.getEditText());




        enter.setOnClickListener(e -> {
           String phone = inputNumber.getEditText().getText().toString();
           String pass = password.getEditText().getText().toString();
            controller.loginByPhone(phone,pass,authResultResponseData -> {
                String token = authResultResponseData.data.getToken();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("_key0_", token);
                startActivity(intent);
                finish();


            });

        });





    }
}