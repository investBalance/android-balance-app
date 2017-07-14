package com.example.hwhong.balance.PostSetUp.PagerSetUp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.hwhong.balance.PostSetUp.PortfolioUIComponents.RandomizedAdapter;
import com.example.hwhong.balance.R;
import com.github.lzyzsd.circleprogress.DonutProgress;
import com.robinhood.spark.SparkView;

import org.w3c.dom.Text;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.hoang8f.android.segmented.SegmentedGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConservativeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConservativeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConservativeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    // View Elements
    @BindView(R.id.conservative_tv)            TextView heading;
    @BindView(R.id.heading_under_conservative) TextView heading_under;
    @BindView(R.id.conservative_sparkview)     SparkView sparkView;
    private RandomizedAdapter adapter;

    // Radio Button Views
    @BindView(R.id.one_con)                     RadioButton one;
    @BindView(R.id.two_con)                     RadioButton two;
    @BindView(R.id.three_con)                   RadioButton three;
    @BindView(R.id.four_con)                    RadioButton four;
    @BindView(R.id.five_con)                    RadioButton five;

    @BindView(R.id.seg_con)                     SegmentedGroup segmentedGroup;
    @BindView(R.id.bar1_conservative)           ProgressBar bar1;
    @BindView(R.id.bar2_conservative)           ProgressBar bar2;

    @BindView(R.id.bar1_text)                   TextView bar1_text;
    @BindView(R.id.bar2_text)                   TextView bar2_text;
    @BindView(R.id.bar1_value)                  TextView bar1_value;
    @BindView(R.id.bar2_value)                  TextView bar2_value;

    @BindView(R.id.pie1_text_con)               TextView pie1_text_con;
    @BindView(R.id.pie2_text_con)               TextView pie2_text_con;
    @BindView(R.id.pie3_text_con)               TextView pie3_text_con;
    @BindView(R.id.pie4_text_con)               TextView pie4_text_con;

    @BindView(R.id.donut_animal_con)            DonutProgress donut_animal;
    @BindView(R.id.donut_environment_con)       DonutProgress donut_environment;
    @BindView(R.id.donut_sustainable_con)       DonutProgress donut_sustainable;
    @BindView(R.id.donut_peace_con)             DonutProgress donut_peace;


    public ConservativeFragment() {
        // Required empty public constructor
    }

    public static ConservativeFragment newInstance(String param1, String param2) {
        ConservativeFragment fragment = new ConservativeFragment();
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conservative, container, false);
        ButterKnife.bind(this, view);

        Typeface dinot = Typeface.createFromAsset(getActivity().getAssets(), "fonts/DINOT-Regular.ttf");
        heading.setTypeface(dinot);
        heading_under.setTypeface(dinot);

        adapter = new RandomizedAdapter();
        sparkView.setAdapter(adapter);

        //segmentedGroup.setTintColor(getResources().getColor(R.color.yellow), getResources().getColor(R.color.white));
        bar1.setMax(100);
        bar1.setVisibility(View.VISIBLE);
        bar1.setProgress(35);
        bar1.setProgressTintList(ColorStateList.valueOf(Color.GREEN));

        bar2.setMax(100);
        bar1.setVisibility(View.VISIBLE);
        bar2.setProgress(75);
        bar2.setProgressTintList(ColorStateList.valueOf(Color.GREEN));

        bar1_text.setTypeface(dinot); bar2_text.setTypeface(dinot);
        bar1_value.setTypeface(dinot); bar2_value.setTypeface(dinot);

        return view;
    }

    @OnClick(R.id.one_con)
    public void randomize1() {adapter.randomize(); randomizeTexts();}
    @OnClick(R.id.two_con)
    public void randomize2() {adapter.randomize(); randomizeTexts();}
    @OnClick(R.id.three_con)
    public void randomize3() {adapter.randomize(); randomizeTexts();}
    @OnClick(R.id.four_con)
    public void randomize4() {adapter.randomize(); randomizeTexts();}
    @OnClick(R.id.five_con)
    public void randomize5() {adapter.randomize(); randomizeTexts();}

    private void randomizeTexts() {
        Random random = new Random();

        // Value texts and progress
        int value = random.nextInt(750);
        bar1_value.setText("$" + value);
        bar1.setProgress(value/10);

        // Projected texts and progress
        int projected = random.nextInt(1001);
        while(value > projected) projected = random.nextInt(1001);
        bar2.setProgress(projected/10);
        bar2_value.setText("$"+projected);
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
