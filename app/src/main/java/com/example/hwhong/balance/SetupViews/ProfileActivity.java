package com.example.hwhong.balance.SetupViews;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hwhong.balance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.profile_tv)       TextView profile;
    @BindView(R.id.username_et)      EditText username;
    @BindView(R.id.password_et)      EditText passowrd;
    @BindView(R.id.profile_continue) Button profileContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        profile.setTypeface(roboto_light);
        username.setTypeface(roboto_thin); passowrd.setTypeface(roboto_thin);
        username.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        passowrd.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        username.setHintTextColor(getResources().getColor(R.color.white));
        passowrd.setHintTextColor(getResources().getColor(R.color.white));
    }

    @OnClick(R.id.profile_continue)
    public void continueFromProfile() {
        Intent intent = new Intent(getApplicationContext(), NameActivity.class);
        if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(passowrd.getText().toString())) {
            Toast.makeText(this, "Please Enter all fields", Toast.LENGTH_SHORT).show();
        }
        if(!TextUtils.isEmpty(username.getText().toString()) && !TextUtils.isEmpty(passowrd.getText().toString())) {
            startActivity(intent);
        }
    }
}
