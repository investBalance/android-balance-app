package com.example.hwhong.balance;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import com.example.hwhong.balance.PostSetUp.CreditCardActivity;
import com.example.hwhong.balance.PostSetUp.PagerActivity;
import com.example.hwhong.balance.PostSetUp.ValuesActivity;
import com.example.hwhong.balance.SetupViews.EmailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.logInBut)         Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


    }

    @OnClick(R.id.createAccountBut)
    public void createAccount() {
        Intent intent = new Intent(getApplicationContext(), EmailActivity.class);
        startActivity(intent);

        //Intent intent = new Intent(getApplicationContext(), CreditCardActivity.class);
        //startActivity(intent);
    }
}
