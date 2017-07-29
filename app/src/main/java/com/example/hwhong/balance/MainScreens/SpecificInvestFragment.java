package com.example.hwhong.balance.MainScreens;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hwhong.balance.MainScreens.DummyListTwo.DummyListTwoAdapter;
import com.example.hwhong.balance.MainScreens.DummyListTwo.RowItem;
import com.example.hwhong.balance.PostSetUp.PortfolioUIComponents.RandomizedAdapter;
import com.example.hwhong.balance.R;
import com.robinhood.spark.SparkView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpecificInvestFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private String NAME;
    private String VALUE;
    private String TAG = "SPECIFIC_INVESTMENT_TAG";

    @BindView(R.id.specific_investment_name)        TextView investment_name;
    @BindView(R.id.main_value)                      TextView main_tv;
    @BindView(R.id.cents)                           TextView cents_tv;
    @BindView(R.id.dollar_sign)                     TextView dollar_sign;
    @BindView(R.id.dot)                             TextView dot;
    @BindView(R.id.current_worth)                   TextView current_worth;
    @BindView(R.id.specific_listview)               ListView listView;
    @BindView(R.id.sparkview)                       SparkView sparkView;

    private static ArrayList<RowItem> list;
    private DummyListTwoAdapter adapter;
    private RandomizedAdapter spark_adapter;

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

        // Setting up dummy data
        setUpDummy();
        adapter = new DummyListTwoAdapter(getActivity().getApplicationContext(), list);
        listView.setAdapter(adapter);

        // for spark view
        spark_adapter = new RandomizedAdapter();
        sparkView.setAdapter(spark_adapter);

        // For list item selections
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // passing bundle so that we know which item is being pressed

                // Replacing the frame with different fragments upon different list item click request
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                CompanyFragment fragment = new CompanyFragment();

                // Passing list item values
                Bundle arguments = new Bundle();
                arguments.putString("NAME", list.get(position).getName());
                arguments.putString("VALUE", list.get(position).getValue());
                arguments.putString("COMP", list.get(position).getCompName());
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

    private static void setUpDummy() {
        list = new ArrayList<>();
        list.add(new RowItem("SNAP", "$87.74", "Snap Inc.", R.drawable.ic_human_rights));
        list.add(new RowItem("TWTR", "$9.44", "Twitter Inc", R.drawable.ic_peace));
        list.add(new RowItem("GPRO", "$83.59", "GoPro Inc.", R.drawable.ic_sustainable));
        list.add(new RowItem("TSLA", "$11.34", "Tesla Inc", R.drawable.ic_environment));
    }

}
