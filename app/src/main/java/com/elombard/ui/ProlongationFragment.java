package com.elombard.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.elombard.MainActivity;
import com.elombard.R;
import com.elombard.model.requests.LoanDebt;
import com.elombard.model.results.ProlongationResult;

public class ProlongationFragment extends Fragment {

    //response
    private ProlongationResult prolongationResult;
    private TextView creditSum;
    private TextView percentSum;
    private TextView totalSum;
    private TextView returnDate;
    private TextView guaranteeDate;

    public ProlongationResult getProlongationResult() {
        return prolongationResult;
    }

    public void setProlongationResult(ProlongationResult prolongationResult) {
        this.prolongationResult = prolongationResult;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prolongation, container, false);

    }

    private void updateProlongation() {
        creditSum.setText(Math.toIntExact(prolongationResult.getCreditSum()));
        percentSum.setText(Math.toIntExact(prolongationResult.getPenaltySum()));
        totalSum.setText(Math.toIntExact(prolongationResult.getTotalSum()));
        returnDate.setText(prolongationResult.getReturnDate());
        guaranteeDate.setText(prolongationResult.getGuaranteeDate());
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        creditSum = view.findViewById(R.id.credit_sum);
        percentSum = view.findViewById(R.id.percent_sum);
        totalSum = view.findViewById(R.id.total_sum);
        returnDate = view.findViewById(R.id.return_date);
        guaranteeDate = view.findViewById(R.id.guarantee_date);
        //request
        TextView loanId = view.findViewById(R.id.loan_id);
        TextView newPeriod = view.findViewById(R.id.new_period);
        TextView mainDebtSum = view.findViewById(R.id.main_debt_sum);
        Button calculate = view.findViewById(R.id.calculate);
        Button prolongation = view.findViewById(R.id.prolongation);
        MainActivity a = (MainActivity) requireActivity();

        calculate.setOnClickListener(v -> {
            //make validation
            Long id = (Long.parseLong(loanId.getText().toString()));
            int localNewPeriod = (Integer.parseInt(newPeriod.getText().toString()));
            Long localMainDebtSum = (Long.parseLong(mainDebtSum.getText().toString()));
            LoanDebt loanDebt = new LoanDebt(id, localNewPeriod, localMainDebtSum);
            a.r.createLoanProlongation(loanDebt, prolongationResult -> {
                setProlongationResult(prolongationResult.data);
                updateProlongation();

            });
        });
        prolongation.setOnClickListener(v -> {

        });

    }
}
