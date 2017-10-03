package com.example.hwhong.balance.MainScreens;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hwhong.balance.DraggableListView.RecyclerListFragment;
import com.example.hwhong.balance.PostSetUp.PagerSetUp.AggressiveFragment;
import com.example.hwhong.balance.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ValuesFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ValuesFragment() {
        // Required empty public constructor
    }

    public static ValuesFragment newInstance(String param1, String param2) {
        ValuesFragment fragment = new ValuesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_values, container, false);
        ButterKnife.bind(this, view);

        // Replacing fragments within a fragment (woop woop!)
        Fragment fragment = new RecyclerListFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.content_fragment, fragment)
                .addToBackStack(null)
                .commit();

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @OnClick(R.id.values_continue)
    public void continueFromValues() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, new ViewInvestmentFragment());
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }
}
