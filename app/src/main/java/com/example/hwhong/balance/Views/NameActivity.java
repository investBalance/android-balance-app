package com.example.hwhong.balance.Views;

import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hwhong.balance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NameActivity extends AppCompatActivity {

    @BindView(R.id.firstname_et) EditText firstname;
    @BindView(R.id.lastname_et)  EditText lastname;
    @BindView(R.id.name_tv)      TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_name);

        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        name.setTypeface(roboto_light);
        firstname.setTypeface(roboto_thin); lastname.setTypeface(roboto_thin);
        firstname.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        lastname.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        firstname.setHintTextColor(getResources().getColor(R.color.white));
        lastname.setHintTextColor(getResources().getColor(R.color.white));
    }
}
