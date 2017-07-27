package com.example.hwhong.balance.MainScreens;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.hwhong.balance.PostSetUp.PagerSetUp.ConservativeFragment;
import com.example.hwhong.balance.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

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

    // For dummy values

    private String TAG = "VIEW_INVESTMENT_TAG";
    private String[] strs = new String[]{
            "Small Company Stocks",
            "Emerging Market Stocks",
            "Large Company Stocks",
            "Corporate Bonds",
            "Real Estate Stocks"};
    private String[] vals = new String[]{
            "$287.74",
            "$91.44",
            "$401.34",
            "$11.34",
            "$49.04" };


    // View bindings
    @BindView(R.id.dollar_sign)             TextView dollar_sign;
    @BindView(R.id.main_value)              TextView main_value;
    @BindView(R.id.dot)                     TextView dot;
    @BindView(R.id.cents)                   TextView cents;
    @BindView(R.id.view_investment_detail)  TextView detail;
    @BindView(R.id.view_investment_explain) TextView explain;

    @BindView(R.id.dollar_seg_but)          RadioButton dollar_button;
    @BindView(R.id.percentage_seg_but)      RadioButton percentage_button;
    @BindView(R.id.shares_seg_but)          RadioButton shares_button;

    @BindView(R.id.dummy_listview)          ListView listView;

    // For populating list data
    private ArrayList<Item> list;
    private DummyListAdapter adapter;

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

        explain.setTypeface(dinot);

        dollar_button.setTypeface(dinot);
        percentage_button.setTypeface(dinot);
        shares_button.setTypeface(dinot);

        setUpDummyData();
        adapter = new DummyListAdapter(getActivity().getApplicationContext(), list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // passing bundle so that we know which item is being pressed

                // Replacing the frame with different fragments upon different list item click request
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                SpecificInvestFragment fragment = new SpecificInvestFragment();
                Bundle arguments = new Bundle();
                arguments.putString("NAME", strs[position]);
                arguments.putString("VALUE", vals[position]);
                fragment.setArguments(arguments);

                fragmentManager.
                        beginTransaction().
                        setCustomAnimations(
                                R.anim.enter_from_right,
                                R.anim.exit_to_left,
                                R.anim.enter_from_left,
                                R.anim.exit_to_right).
                        replace(R.id.content_frame, fragment).
                        addToBackStack(TAG).
                        commit();
            }
        });

        return view;
    }

    private void setUpDummyData() {
        list = new ArrayList<>();
        list.add(new Item("Small Company Stocks", "$287.74"));
        list.add(new Item("Emerging Market Stocks", "$91.44"));
        list.add(new Item("Large Company Stocks", "$401.34"));
        list.add(new Item("Corporate Bonds", "$11.34"));
        list.add(new Item("Real Estate Stocks", "$49.04"));
    }

}
