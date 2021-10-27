package com.elombard.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.elombard.MainActivity;
import com.elombard.R;
import com.elombard.interfaces.Consumer;
import com.elombard.model.results.OverDraft;
import com.elombard.model.results.ResponseData;
import com.elombard.services.RetrofitController;
import com.elombard.services.SingleResponseCallBack;

public class LoanFragment extends Fragment {
    private static String LOAN_ID_PARAM = "loanId";
    private Long loanId;
    RetrofitController r;
    OverDraft overDraft;
    private TextView loanIdText;
    private TextView returnDate;
    private TextView guaranteeDate;
    private TextView creditSum;
    private TextView interestSum;
    private TextView orgBIN;
    private TextView clientIIN;
    private TextView pawnTicketNumber;
    private Button calculate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prolongation, container, false);

    }

    private void updateOverDraft() {
        loanIdText.setText(Math.toIntExact(loanId));
        returnDate.setText(overDraft.getReturnDate());
        guaranteeDate.setText(overDraft.getGuaranteeDate());
        creditSum.setText(overDraft.getCreditSum());
        interestSum.setText(overDraft.getPercentSum());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        orgBIN.findViewById(R.id.login);
        clientIIN.findViewById(R.id.client_iin);
        pawnTicketNumber.findViewById(R.id.pawn_ticket_number);
        MainActivity a = (MainActivity) requireActivity();
        r = a.r;
        a.getClientInfoResult().getIin();

        calculate.setOnClickListener(view1 -> {
            String orgBINString = orgBIN.getText().toString();
            String clientIINString = clientIIN.getText().toString();
            Long pawnTicketNumberLong = Long.parseLong(pawnTicketNumber.getText().toString());
            r.loanDebt(orgBINString, clientIINString, pawnTicketNumberLong, overDraftResponseData -> {

            }
            );
        });


    }

    public static LoanFragment newInstance(Long loanId) {
        LoanFragment fragment = new LoanFragment();
        Bundle args = new Bundle();
        args.putLong(LOAN_ID_PARAM, loanId);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            loanId = getArguments().getLong(LOAN_ID_PARAM);
        }
    }


}