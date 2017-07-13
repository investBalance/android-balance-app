package com.example.hwhong.balance.PostSetUp;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.hwhong.balance.DraggableListView.RecyclerListFragment;
import com.example.hwhong.balance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ValuesActivity extends AppCompatActivity{

    @BindView(R.id.values)         TextView heading;
    @BindView(R.id.values_explain) TextView explanation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_values);

        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto_light = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        Typeface dinot = Typeface.createFromAsset(getAssets(), "fonts/DINOT-Regular.ttf");

        heading.setTypeface(dinot);
        explanation.setTypeface(roboto_thin);

        Fragment fragment = new RecyclerListFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .addToBackStack(null)
                .commit();
    }
}
