package com.example.hwhong.balance.PostSetUp;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hwhong.balance.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HeroPage extends Activity {

    @BindView(R.id.pager_hero_heading) TextView heading;
    @BindView(R.id.pager_hero_detail)  TextView detail;
    @BindView(R.id.close_icon)         ImageView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_hero_page);

        ButterKnife.bind(this);

        Typeface dinot = Typeface.createFromAsset(getAssets(), "fonts/DINOT-Regular.ttf");
        heading.setTypeface(dinot);
        detail.setTypeface(dinot);

        Picasso.with(getApplicationContext()).load(R.drawable.close).into(close);
    }

    @OnClick(R.id.close_icon)
    public void close() {
        HeroPage.this.finish();
        overridePendingTransition(R.anim.stay, R.anim.slide_out_up);
    }
}
