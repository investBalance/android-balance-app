package com.example.hwhong.balance.MainScreens;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hwhong.balance.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewInvestmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewInvestmentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // View bindings
    @BindView(R.id.dollar_sign)             TextView dollar_sign;
    @BindView(R.id.main_value)              TextView main_value;
    @BindView(R.id.dot)                     TextView dot;
    @BindView(R.id.cents)                   TextView cents;
    @BindView(R.id.view_investment_detail)  TextView detail;

    public ViewInvestmentFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ViewInvestmentFragment newInstance(String param1, String param2) {
        ViewInvestmentFragment fragment = new ViewInvestmentFragment();
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
        View view = inflater.inflate(R.layout.fragment_view_investment, container, false);
        ButterKnife.bind(this, view);

        Typeface dinot = Typeface.createFromAsset(getActivity().getAssets(), "fonts/DINOT-Regular.ttf");

        // Setting type face for custom dollar textviews
        dollar_sign.setTypeface(dinot); dot.setTypeface(dinot);
        main_value.setTypeface(dinot); cents.setTypeface(dinot);
        detail.setTypeface(dinot);


        return view;
    }

}
