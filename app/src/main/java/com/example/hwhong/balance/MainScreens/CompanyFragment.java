package com.example.hwhong.balance.MainScreens;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hwhong.balance.PostSetUp.PortfolioUIComponents.RandomizedAdapter;
import com.example.hwhong.balance.R;
import com.robinhood.spark.SparkView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CompanyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String NAMETAG = "NAME", VALUETAG = "VALUE", COMPTAG = "COMP";
    private String NAME, VALUE, COMP;

    @BindView(R.id.symbol_tv)                       TextView symb;
    @BindView(R.id.comp_tv)                         TextView comp;
    @BindView(R.id.main_value)                      TextView main_tv;
    @BindView(R.id.cents)                           TextView cents_tv;
    @BindView(R.id.dollar_sign)                     TextView dollar_sign;
    @BindView(R.id.dot)                             TextView dot;
    @BindView(R.id.company_sparkview)               SparkView sparkView;
    @BindView(R.id.watch_but)                       Button watch;
    @BindView(R.id.favorite_but)                    Button favorite;

    @BindView(R.id.shares_tv)                       TextView shares_tv;
    @BindView(R.id.equity_tv)                       TextView equity_tv;
    @BindView(R.id.balance_tv)                      TextView balance_tv;
    @BindView(R.id.average_cost_tv)                 TextView average_tv;

    private RandomizedAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public CompanyFragment() {
        // Required empty public constructor
    }

    public static CompanyFragment newInstance(String param1, String param2) {
        CompanyFragment fragment = new CompanyFragment();
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
            // retrieves values
            NAME = getArguments().getString(NAMETAG);
            VALUE = getArguments().getString(VALUETAG);
            COMP = getArguments().getString(COMPTAG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_company, container, false);
        ButterKnife.bind(this, view);

        Typeface roboto_light = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Thin.ttf");
        Typeface dinot = Typeface.createFromAsset(getActivity().getAssets(), "fonts/DINOT-Regular.ttf");

        // set Typefaces
        typefaceCustom();

        // set textview values
        parse(VALUE);
        symb.setText(NAME);
        comp.setText(COMP);

        // For sparkview
        adapter = new RandomizedAdapter();
        sparkView.setAdapter(adapter);

        // For button customize
        watch.setTypeface(roboto_light);
        favorite.setTypeface(roboto_light);



        return view;
    }

    private void typefaceCustom() {
        Typeface roboto_light = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Thin.ttf");
        Typeface dinot = Typeface.createFromAsset(getActivity().getAssets(), "fonts/DINOT-Regular.ttf");

        shares_tv.setTypeface(dinot);
        equity_tv.setTypeface(dinot);
        balance_tv.setTypeface(dinot);
        average_tv.setTypeface(dinot);

        main_tv.setTypeface(dinot);
        cents_tv.setTypeface(dinot);
        dollar_sign.setTypeface(dinot);
        dot.setTypeface(dinot);

        symb.setTypeface(roboto_light);
        comp.setTypeface(roboto_thin);
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

    // Parses the value and sets the value
    private void parse(String value) {
        main_tv.setText(value.substring(1, value.indexOf(".")));
        cents_tv.setText(value.substring(value.indexOf(".")+1, value.length()));
    }
}
