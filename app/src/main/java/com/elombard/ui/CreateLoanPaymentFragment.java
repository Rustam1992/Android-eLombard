package com.elombard.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.elombard.MainActivity;
import com.elombard.R;
import com.elombard.model.results.LoanDebtResult;

public class CreateLoanPaymentFragment extends Fragment {

    //response
    private LoanDebtResult loanDebtResult;
    private TextView creditSum;
    private TextView percentSum;
    private TextView totalSum;
    private TextView returnDate;
    private TextView guaranteeDate;

    private EditText orgBIN;
    private EditText pawnTickedNumber;
    private EditText newPeriod;
    private EditText referenceId;




    public void setLoanDebtResult(LoanDebtResult loanDebtResult) {
        this.loanDebtResult = loanDebtResult;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_loan_payment, container, false);

    }

    private void updateProlongation() {
        creditSum.setText(Math.toIntExact(loanDebtResult.getCreditSum()));
        percentSum.setText(Math.toIntExact(loanDebtResult.getPercentSum()));
        totalSum.setText(Math.toIntExact(loanDebtResult.getTotalSum()));
        returnDate.setText(loanDebtResult.getReturnDate());
        guaranteeDate.setText(loanDebtResult.getGuaranteeDate());

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // результат запроса
        creditSum = view.findViewById(R.id.credit_sum);
        percentSum = view.findViewById(R.id.percent_sum);
        totalSum = view.findViewById(R.id.total_sum);
        returnDate = view.findViewById(R.id.return_date);
        guaranteeDate = view.findViewById(R.id.guarantee_date);


        //request
        orgBIN.findViewById(R.id.orgBIN);
        pawnTickedNumber.findViewById(R.id.pawn_ticked_number);
        newPeriod.findViewById(R.id.pawn_ticked_number);
        referenceId.findViewById(R.id.reference_id);


        Button prolongation = view.findViewById(R.id.prolongation);

        MainActivity a = (MainActivity) requireActivity();


        prolongation.setOnClickListener(v -> {

           //TODO make validation
            String orgBINText = orgBIN.getText().toString();
            Long pawnTickedNumberLong = (Long.parseLong(pawnTickedNumber.getText().toString()));
            int localNewInt = (Integer.parseInt(newPeriod.getText().toString()));
            String referenceIdString = referenceId.getText().toString();

            a.r.createLoanPayment(orgBINText,pawnTickedNumberLong,localNewInt,referenceIdString, loanDebtResultResponseData -> {
                setLoanDebtResult(loanDebtResultResponseData.data);
                updateProlongation();

            });
        });


    }
}
