package com.example.hwhong.balance.PostSetUp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hwhong.balance.MainScreens.NavigationDrawerActivity;
import com.example.hwhong.balance.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreditCardActivity extends AppCompatActivity {

    @BindView(R.id.creditcard_tv)       TextView heading;
    @BindView(R.id.creditcard_detail)   TextView detail;
    @BindView(R.id.more_info_cdc)       TextView cdc_more_info;
    @BindView(R.id.lock_text)           TextView lock_text;
    @BindView(R.id.cdc_background)      ImageView wallpaper;
    @BindView(R.id.cdc_main_img)        ImageView main_img;

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
        Picasso.with(getApplicationContext()).load(R.drawable.blur_background).into(wallpaper);
        Picasso.with(getApplicationContext()).load(R.drawable.cdc).into(main_img);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        heading.setTypeface(roboto_light);
        detail.setTypeface(roboto_thin);
        cdc_more_info.setTypeface(roboto_thin);
        lock_text.setTypeface(roboto_thin);
    }

    @OnClick(R.id.later_button)
    public void continueFromCreditCard(){
        startActivity(new Intent(getApplicationContext(), NavigationDrawerActivity.class));
    }
}
