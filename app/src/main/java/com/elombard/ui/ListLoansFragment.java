package com.elombard.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.elombard.MainActivity;
import com.elombard.R;
import com.elombard.interfaces.Consumer;
import com.elombard.interfaces.Single;
import com.elombard.model.results.LoanListResult;
import com.elombard.ui.adapter.LoansAdapter;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;


public class ListLoansFragment extends Fragment {
    private SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_loans, container, false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSwipeRefreshLayout = requireView().findViewById(R.id.refresh_layout);
        mSwipeRefreshLayout.setRefreshing(true);
        RecyclerView recycler_view = view.findViewById(R.id.recycler_view);
        recycler_view.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));
        LoansAdapter adapter = new LoansAdapter();
        recycler_view.setAdapter(adapter);
        TextView noResult = view.findViewById(R.id.no_result);

        MainActivity a = (MainActivity) requireActivity();
        adapter.setActionInfoListener(loan -> {
            a.getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                    .replace(R.id.root, LoanFragment.newInstance(loan.getId()))
                    .addToBackStack(null)
                    .commit();
        });

        a.r.getLoans(loanListResult -> {
            mSwipeRefreshLayout.setRefreshing(false);
            if (loanListResult.data.getLoanList() != null) {
                adapter.updateItems(loanListResult.data.getLoanList());

            } else {
                noResult.setVisibility(View.VISIBLE);
            }
        });

    }


}

