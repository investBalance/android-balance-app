package com.example.hwhong.balance.PostSetUp;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.hwhong.balance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreditCardActivity extends AppCompatActivity {

    @BindView(R.id.creditcard_tv)       TextView heading;
    @BindView(R.id.creditcard_detail)   TextView detail;
    @BindView(R.id.more_info_cdc)       TextView cdc_more_info;
    @BindView(R.id.lock_text)           TextView lock_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_credit_card);

        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        heading.setTypeface(roboto_light);
        detail.setTypeface(roboto_thin);
        cdc_more_info.setTypeface(roboto_thin);
        lock_text.setTypeface(roboto_thin);
    }
}
