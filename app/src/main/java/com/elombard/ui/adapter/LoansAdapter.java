package com.elombard.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.elombard.R;
import com.elombard.interfaces.Consumer;
import com.elombard.model.enums.Status;
import com.elombard.model.results.Loan;


import java.util.ArrayList;
import java.util.List;


public class LoansAdapter extends RecyclerView.Adapter<LoansAdapter.MyViewHolder> {
    Consumer<Loan> loanConsumer;
    ArrayList<Loan> items = new ArrayList<>();


   public LoansAdapter setActionInfoListener(Consumer<Loan> loanConsumer) {
        this.loanConsumer = loanConsumer;
        return this;
    }

   public void updateItems(List<Loan> loans) {
        items.clear();
        items.addAll(loans);
        notifyDataSetChanged();

    }


    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Loan loan = items.get(position);
        holder.bind(loan);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder( View itemView) {
            super(itemView);
        }

        void bind(Loan loan) {
            TextView loanId = itemView.findViewById(R.id.loan_id);
            loanId.setText(String.valueOf(loan.getId()));
            Button buttonInfo = itemView.findViewById(R.id.button_info);
            ImageView status = itemView.findViewById(R.id.status);
            buttonInfo.setOnClickListener(view -> {
                loanConsumer.accept(loan);
            });


            if (loan.getStatus().equals(Status.OPEN.toString())) {
                status.setImageResource(R.drawable.open);
            } else if (loan.getStatus().equals(Status.GUARANTEE_PERIOD.toString())) {
                status.setImageResource(R.drawable.guarantee_period);
            } else if (loan.getStatus().equals(Status.REALIZATION.toString())) {
                status.setImageResource(R.drawable.guarantee_period);
            } else if (loan.getStatus().equals(Status.CLOSED.toString())) {
                status.setImageResource(R.drawable.closed);
            }


        }
    }
}
