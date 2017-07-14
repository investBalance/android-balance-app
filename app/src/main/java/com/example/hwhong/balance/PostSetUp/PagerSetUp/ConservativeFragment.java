package com.example.hwhong.balance.PostSetUp.PagerSetUp;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.hwhong.balance.PostSetUp.PortfolioUIComponents.RandomizedAdapter;
import com.example.hwhong.balance.R;
import com.robinhood.spark.SparkView;

import org.w3c.dom.Text;

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


        return view;
    }

    @OnClick(R.id.one_con)
    public void randomize1() {adapter.randomize();}
    @OnClick(R.id.two_con)
    public void randomize2() {adapter.randomize();}
    @OnClick(R.id.three_con)
    public void randomize3() {adapter.randomize();}
    @OnClick(R.id.four_con)
    public void randomize4() {adapter.randomize();}
    @OnClick(R.id.five_con)
    public void randomize5() {adapter.randomize();}

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
