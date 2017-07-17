package com.example.hwhong.balance.SetupViews;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hwhong.balance.PostSetUp.HeroPage;
import com.example.hwhong.balance.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HeroVerify extends Activity {

    @BindView(R.id.main_hero_image)     ImageView main_hero_img;
    @BindView(R.id.verify_close)        ImageView close;
    @BindView(R.id.verify_hero_heading) TextView heading;
    @BindView(R.id.verify_hero_detail)  TextView detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_hero_verify);
        ButterKnife.bind(this);

        Picasso.with(getApplicationContext()).load(R.drawable.hero).into(main_hero_img);
        Picasso.with(getApplicationContext()).load(R.drawable.close).into(close);
        Typeface dinot = Typeface.createFromAsset(getAssets(), "fonts/DINOT-Regular.ttf");

        heading.setTypeface(dinot);
        detail.setTypeface(dinot);
    }

    @OnClick(R.id.verify_close)
    public void closeInVerify() {
        HeroVerify.this.finish();
        overridePendingTransition(R.anim.stay, R.anim.slide_out_up);
    }

}
