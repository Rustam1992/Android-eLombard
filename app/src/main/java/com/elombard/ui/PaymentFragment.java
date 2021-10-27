package com.elombard.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.elombard.R;

import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser;
import ru.tinkoff.decoro.slots.PredefinedSlots;
import ru.tinkoff.decoro.slots.Slot;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

public class PaymentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_payment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText card_number = view.findViewById(R.id.card_number);
        EditText mm_yy = view.findViewById(R.id.mm_yy);
        EditText cvv = view.findViewById(R.id.cvv);
        EditText full_name = view.findViewById(R.id.full_name);
        FormatWatcher formatWatcher = new MaskFormatWatcher(MaskImpl.createTerminated(PredefinedSlots.CARD_NUMBER_STANDART));
        formatWatcher.installOn(card_number);

        Slot[] slot1 = new UnderscoreDigitSlotsParser().parseSlots("__/__");
        FormatWatcher formatWatcherMm_yy = new MaskFormatWatcher( // форматировать текст будет вот он
                MaskImpl.createTerminated(slot1)
        );
        formatWatcherMm_yy.installOn(mm_yy);


        Slot[] slot2 = new UnderscoreDigitSlotsParser().parseSlots("___");
        FormatWatcher formatWatcherCvv = new MaskFormatWatcher( // форматировать текст будет вот он
                MaskImpl.createTerminated(slot2)
        );
        formatWatcherCvv.installOn(cvv);

    }


}