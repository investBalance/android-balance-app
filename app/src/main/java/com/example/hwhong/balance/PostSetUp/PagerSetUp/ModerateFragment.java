package com.example.hwhong.balance.PostSetUp.PagerSetUp;

import android.content.Context;
import android.content.Intent;
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

import com.example.hwhong.balance.PostSetUp.CreditCardActivity;
import com.example.hwhong.balance.PostSetUp.PortfolioUIComponents.RandomizedAdapter;
import com.example.hwhong.balance.R;
import com.github.lzyzsd.circleprogress.DonutProgress;
import com.robinhood.spark.SparkView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.hoang8f.android.segmented.SegmentedGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ModerateFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ModerateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ModerateFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    // View Elements
    @BindView(R.id.moderate_tv)
    TextView heading;
    @BindView(R.id.heading_under_moderate)      TextView heading_under;
    @BindView(R.id.moderate_sparkview)          SparkView sparkView;
    private RandomizedAdapter adapter;

    // Radio Button Views
    @BindView(R.id.one_mod)
    RadioButton one;
    @BindView(R.id.two_mod)                     RadioButton two;
    @BindView(R.id.three_mod)                   RadioButton three;
    @BindView(R.id.four_mod)                    RadioButton four;
    @BindView(R.id.five_mod)                    RadioButton five;

    @BindView(R.id.seg_mod)                     SegmentedGroup segmentedGroup;
    @BindView(R.id.bar1_moderate)               ProgressBar bar1;
    @BindView(R.id.bar2_moderate)               ProgressBar bar2;

    @BindView(R.id.bar1_text_moderate)          TextView bar1_text;
    @BindView(R.id.bar2_text_moderate)          TextView bar2_text;
    @BindView(R.id.bar1_value_moderate)         TextView bar1_value;
    @BindView(R.id.bar2_value_moderate)         TextView bar2_value;

    @BindView(R.id.pie1_text_mod)               TextView pie1_text_mod;
    @BindView(R.id.pie2_text_mod)               TextView pie2_text_mod;
    @BindView(R.id.pie3_text_mod)               TextView pie3_text_mod;
    @BindView(R.id.pie4_text_mod)               TextView pie4_text_mod;

    @BindView(R.id.donut_animal_mod)            DonutProgress donut_animal;
    @BindView(R.id.donut_environment_mod)       DonutProgress donut_environment;
    @BindView(R.id.donut_sustainable_mod)       DonutProgress donut_sustainable;
    @BindView(R.id.donut_peace_mod)             DonutProgress donut_peace;

    public ModerateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ModerateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ModerateFragment newInstance(String param1, String param2) {
        ModerateFragment fragment = new ModerateFragment();
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
        View view = inflater.inflate(R.layout.fragment_moderate, container, false);
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

        donutSetUp();

        return view;
    }

    @OnClick(R.id.moderate_continue)
    public void continueFromModerate() {
        Intent intent = new Intent(getActivity(), CreditCardActivity.class);
        startActivity(intent);
    }

    private void donutSetUp() {
        Typeface dinot = Typeface.createFromAsset(getActivity().getAssets(), "fonts/DINOT-Regular.ttf");
        Random random = new Random();
        int i1 = random.nextInt(101);
        donut_animal.setProgress((float)i1);
        pie1_text_mod.setText(i1 + "%");

        int i2 = random.nextInt(101);
        donut_environment.setProgress((float)i2);
        pie2_text_mod.setText(i2 + "%");

        int i3 = random.nextInt(101);
        donut_peace.setProgress((float)i3);
        pie3_text_mod.setText(i3 + "%");

        int i4 = random.nextInt(101);
        donut_sustainable.setProgress((float)i4);
        pie4_text_mod.setText(i4 + "%");

        pie1_text_mod.setTypeface(dinot);
        pie2_text_mod.setTypeface(dinot);
        pie3_text_mod.setTypeface(dinot);
        pie4_text_mod.setTypeface(dinot);
    }

    @OnClick(R.id.one_mod)
    public void randomize1() {adapter.randomize(); randomizeTexts(); donutSetUp();}
    @OnClick(R.id.two_mod)
    public void randomize2() {adapter.randomize(); randomizeTexts(); donutSetUp();}
    @OnClick(R.id.three_mod)
    public void randomize3() {adapter.randomize(); randomizeTexts(); donutSetUp();}
    @OnClick(R.id.four_mod)
    public void randomize4() {adapter.randomize(); randomizeTexts(); donutSetUp();}
    @OnClick(R.id.five_mod)
    public void randomize5() {adapter.randomize(); randomizeTexts(); donutSetUp();}

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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
