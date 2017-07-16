package com.example.hwhong.balance.SetupViews;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hwhong.balance.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VerificationActivity extends AppCompatActivity {

    @BindView(R.id.verification_tv)     TextView verification_tv;
    @BindView(R.id.verification_detail) TextView detail;
    @BindView(R.id.more_info)           TextView info_text;
    @BindView(R.id.lock_text)           TextView lock_text;

    @BindView(R.id.hero)                    ImageView hero;
    @BindView(R.id.verification_background) ImageView wallpaper;
    @BindView(R.id.verification_imgv)       ImageView main_pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_verification);

        ButterKnife.bind(this);

        Picasso.with(getApplicationContext()).load(R.drawable.blur_background).into(wallpaper);
        Picasso.with(getApplicationContext()).load(R.drawable.privacy).into(main_pic);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        verification_tv.setTypeface(roboto_light);
        detail.setTypeface(roboto_thin);
        info_text.setTypeface(roboto_thin);
        lock_text.setTypeface(roboto_thin);
    }

    @OnClick(R.id.verification_continue)
    public void continueFromVerifcation() {
        Intent intent = new Intent(getApplicationContext(), DobActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.hero)
    public void moreInformationHero() {
        Toast.makeText(this, "This is work in Progress", Toast.LENGTH_SHORT).show();
    }
}
