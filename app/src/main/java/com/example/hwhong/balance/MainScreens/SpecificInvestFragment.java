package com.example.hwhong.balance.MainScreens;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hwhong.balance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpecificInvestFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private String NAME;
    private String VALUE;

    @BindView(R.id.specific_investment_name)        TextView investment_name;
    @BindView(R.id.main_value)                      TextView main_tv;
    @BindView(R.id.cents)                           TextView cents_tv;
    @BindView(R.id.dollar_sign)                     TextView dollar_sign;
    @BindView(R.id.dot)                             TextView dot;
    @BindView(R.id.current_worth)                   TextView current_worth;

    public SpecificInvestFragment() {
        // Required empty public constructor
    }

    public static SpecificInvestFragment newInstance(String param1, String param2) {
        SpecificInvestFragment fragment = new SpecificInvestFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            NAME = getArguments().getString("NAME", "Fail");
            VALUE = getArguments().getString("VALUE", "$999.9");
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "Value not retrieved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_specific_invest, container, false);
        ButterKnife.bind(this, view);

        Typeface dinot = Typeface.createFromAsset(getActivity().getAssets(), "fonts/DINOT-Regular.ttf");

        // The investment name heading
        investment_name.setText(NAME);
        // The value
        parse(VALUE);

        // For customizations
        investment_name.setTypeface(dinot);
        main_tv.setTypeface(dinot);
        cents_tv.setTypeface(dinot);
        dollar_sign.setTypeface(dinot);
        dot.setTypeface(dinot);
        current_worth.setTypeface(dinot);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void parse(String value) {
        main_tv.setText(value.substring(1, value.indexOf(".")));
        cents_tv.setText(value.substring(value.indexOf(".")+1, value.length()));
    }

}
