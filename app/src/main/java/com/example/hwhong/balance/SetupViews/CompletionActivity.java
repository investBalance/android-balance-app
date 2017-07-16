package com.example.hwhong.balance.SetupViews;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hwhong.balance.PostSetUp.ValuesActivity;
import com.example.hwhong.balance.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CompletionActivity extends AppCompatActivity {

    @BindView(R.id.complete_tv)     TextView main;
    @BindView(R.id.complete_detail) TextView detail;
    @BindView(R.id.hero_text)       TextView hero_text;
    @BindView(R.id.completion_background) ImageView wallpaper;
    @BindView(R.id.star_completion) ImageView main_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_completion);

        ButterKnife.bind(this);
        Picasso.with(getApplicationContext()).load(R.drawable.blur_background).into(wallpaper);
        Picasso.with(getApplicationContext()).load(R.drawable.star).into(main_img);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        main.setTypeface(roboto_light);
        detail.setTypeface(roboto_thin);
        hero_text.setTypeface(roboto_thin);
    }

    @OnClick(R.id.completion_continue)
    public void continueFromCompletion() {
        Intent intent = new Intent(getApplicationContext(), ValuesActivity.class);
        startActivity(intent);
    }
}
