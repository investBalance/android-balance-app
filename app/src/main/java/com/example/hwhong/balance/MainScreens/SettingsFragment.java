package com.example.hwhong.balance.MainScreens;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hwhong.balance.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    // View elements
    @BindView(R.id.heading)                     TextView heading;


    @BindView(R.id.listview_one)                ListView one;
    @BindView(R.id.listview_two)                ListView two;
    @BindView(R.id.listview_three)              ListView three;
    @BindView(R.id.listview_four)               ListView four;

    public SettingsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this, view);

        styling();
        settingsItemSetup();

        return view;
    }

    private void styling() {
        Typeface dinot = Typeface.createFromAsset(getActivity().getAssets(), "fonts/DINOT-Regular.ttf");
        heading.setTypeface(dinot);
    }

    private void  settingsItemSetup() {
        ArrayList<String> device = new ArrayList<>();
        device.add("Touch ID and PIN");
        device.add("Two-Factor Authentication");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, device);

        ArrayList<String> personal = new ArrayList<>();
        personal.add("Email");
        personal.add("Address");
        personal.add("Phone");
        personal.add("Password");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, personal);

        ArrayList<String> banking = new ArrayList<>();
        banking.add("History");
        banking.add("Connected Accounts");

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, banking);

        ArrayList<String> profile = new ArrayList<>();
        profile.add("My Values");
        profile.add("Investment Styles");
        profile.add("Help");
        profile.add("Disclosures");
        profile.add("FAQ");

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, profile);

        one.setAdapter(adapter1);
        two.setAdapter(adapter2);
        three.setAdapter(adapter3);
        four.setAdapter(adapter4);
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
}
