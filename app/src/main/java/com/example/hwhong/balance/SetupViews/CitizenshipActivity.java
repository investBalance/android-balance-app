package com.example.hwhong.balance.SetupViews;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.hwhong.balance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CitizenshipActivity extends AppCompatActivity {

    @BindView(R.id.citizenship_detail) TextView detail;
    @BindView(R.id.citizenship_tv)     TextView main_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_citizenship);

        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        main_text.setTypeface(roboto_light);
        detail.setTypeface(roboto_thin);
    }

    @OnClick(R.id.citizenship_continue)
    public void continueFromCitizenship() {
        Intent intent = new Intent(getApplicationContext(), SSNActivity.class);
        startActivity(intent);
    }
}
