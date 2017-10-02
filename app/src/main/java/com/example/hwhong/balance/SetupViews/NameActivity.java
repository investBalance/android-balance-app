package com.example.hwhong.balance.SetupViews;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
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

public class NameActivity extends AppCompatActivity {

    @BindView(R.id.firstname_et) EditText firstname;
    @BindView(R.id.lastname_et)  EditText lastname;
    @BindView(R.id.name_tv)      TextView name;
    @BindView(R.id.name_background) ImageView wallpaper;

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
        Picasso.with(getApplicationContext()).load(R.drawable.blur_background).into(wallpaper);

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

        // for automatic capitalization of first letter in editTexts
        firstname.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        lastname.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
    }

    @OnClick(R.id.name_continue)
    public void continueFromName() {
        Intent intent = new Intent(getApplicationContext(), PhoneActivity.class);
        if(TextUtils.isEmpty(firstname.getText().toString()) || TextUtils.isEmpty(lastname.getText().toString())) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        // Only if both fields are present, only then can we proceed
        if(!TextUtils.isEmpty(firstname.getText().toString()) && !TextUtils.isEmpty(lastname.getText().toString())) {
            startActivity(intent);
        }
    }
}
