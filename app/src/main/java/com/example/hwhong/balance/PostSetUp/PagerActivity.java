package com.example.hwhong.balance.PostSetUp;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.hwhong.balance.PostSetUp.PagerSetUp.PagerAdapter;
import com.example.hwhong.balance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagerActivity extends FragmentActivity {

    @BindView(R.id.pager)     ViewPager vPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        ButterKnife.bind(this);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        vPager.setAdapter(adapter);


    }
}
