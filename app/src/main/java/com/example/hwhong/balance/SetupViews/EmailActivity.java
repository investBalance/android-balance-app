package com.example.hwhong.balance.SetupViews;

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

public class EmailActivity extends AppCompatActivity {

    @BindView(R.id.started_tv)     TextView started;
    @BindView(R.id.question_email) TextView question_email;
    @BindView(R.id.email_editText) EditText email_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_email);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // Creating typeface fonts for textviews and editText
        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        // Setting style for textviews and editText
        started.setTypeface(roboto_light);
        question_email.setTypeface(roboto_thin);
        email_editText.setTypeface(roboto_light);
        email_editText.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
    }

    @OnClick(R.id.continueBut)
    public void continueFromEmail() {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        if(TextUtils.isEmpty(email_editText.getText().toString())) {
            Toast.makeText(this, "Please enter your email address", Toast.LENGTH_SHORT).show();
        }
        if(!TextUtils.isEmpty(email_editText.getText().toString())) startActivity(intent);
    }
}
