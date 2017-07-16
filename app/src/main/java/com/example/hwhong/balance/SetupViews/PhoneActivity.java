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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hwhong.balance.R;
import com.hbb20.CountryCodePicker;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneActivity extends AppCompatActivity {

    @BindView(R.id.ccp)              CountryCodePicker ccp;
    @BindView(R.id.phone_tv)         TextView phone;
    @BindView(R.id.phone_et)         EditText phone_number;
    @BindView(R.id.phone_background) ImageView wallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_phone);
        ButterKnife.bind(this);

        Picasso.with(getApplicationContext()).load(R.drawable.blur_background).into(wallpaper);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        phone.setTypeface(roboto_light);
        ccp.setTypeFace(roboto_light);
        phone_number.setTypeface(roboto_thin);
        phone_number.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        phone_number.setHintTextColor(getResources().getColor(R.color.white));
    }

    @OnClick(R.id.phone_continue)
    public void continueFromPhone() {
        Intent intent = new Intent(getApplicationContext(), VerificationActivity.class);
        if(TextUtils.isEmpty(phone_number.getText().toString())) {
            Toast.makeText(this, "Please Enter all fields", Toast.LENGTH_SHORT).show();
        }
        if(!TextUtils.isEmpty(phone_number.getText().toString())) {
            startActivity(intent);
        }
    }
}
