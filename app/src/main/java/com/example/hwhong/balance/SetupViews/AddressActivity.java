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

public class AddressActivity extends AppCompatActivity {

    @BindView(R.id.address_detail) TextView address_detail;
    @BindView(R.id.address_tv) TextView address_tv;
    @BindView(R.id.address_et) EditText address_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_address);

        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        // TextView customize
        address_detail.setTypeface(roboto_thin); address_tv.setTypeface(roboto_light);

        // EditText customize
        address_et.setTypeface(roboto_thin);
        address_et.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        address_et.setHintTextColor(getResources().getColor(R.color.white));
    }

    @OnClick(R.id.address_continue)
    public void continueFromAddress() {
        Intent intent = new Intent(getApplicationContext(), CitizenshipActivity.class);
        if(TextUtils.isEmpty(address_et.getText().toString())) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        if(!TextUtils.isEmpty(address_et.getText().toString())){
            startActivity(intent);
        }
    }
}
