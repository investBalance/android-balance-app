package com.example.hwhong.balance.SetupViews;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.media.Image;
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
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DobActivity extends AppCompatActivity {

    @BindView(R.id.dob_detail) TextView dob_info;
    @BindView(R.id.dob_tv)     TextView dob;
    @BindView(R.id.dob_et)     EditText dob_input;
    @BindView(R.id.dob_background) ImageView wallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dob);
        ButterKnife.bind(this);

        Picasso.with(getApplicationContext()).load(R.drawable.blur_background).into(wallpaper);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        dob.setTypeface(roboto_light); dob_info.setTypeface(roboto_thin); dob_input.setTypeface(roboto_thin);
        dob_input.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        dob_input.setHintTextColor(getResources().getColor(R.color.white));
    }

    // Register Button click event
    @OnClick(R.id.dob_continue)
    public void continueFromDob(){
        Intent intent = new Intent(getApplicationContext(), AddressActivity.class);
        if(TextUtils.isEmpty(dob_input.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        if(!TextUtils.isEmpty(dob_input.getText().toString())) {
            startActivity(intent);
        }
    }

}
