package com.example.hwhong.balance.Views;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hwhong.balance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SSNActivity extends AppCompatActivity {

    @BindView(R.id.ssn_detail) TextView detail;
    @BindView(R.id.ssn_tv)     TextView textView;
    @BindView(R.id.ssn_et)     EditText ssn_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ssn);

        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        textView.setTypeface(roboto_light); detail.setTypeface(roboto_thin); ssn_input.setTypeface(roboto_thin);
        ssn_input.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        ssn_input.setHintTextColor(getResources().getColor(R.color.white));
    }

    @OnClick(R.id.ssn_continue)
    public void continueFromSSN() {
        Intent intent = new Intent(getApplicationContext(), CompletionActivity.class);
        if(TextUtils.isEmpty(ssn_input.getText().toString())) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        if(!TextUtils.isEmpty(ssn_input.getText().toString())) {
            startActivity(intent);
        }
    }
}
