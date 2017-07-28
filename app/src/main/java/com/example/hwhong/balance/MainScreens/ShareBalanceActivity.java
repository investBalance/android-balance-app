package com.example.hwhong.balance.MainScreens;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.example.hwhong.balance.MainScreens.GridView.Card;
import com.example.hwhong.balance.MainScreens.GridView.ItemOffsetDecoration;
import com.example.hwhong.balance.MainScreens.GridView.RecyclerViewAdapter;
import com.example.hwhong.balance.PostSetUp.HeroPage;
import com.example.hwhong.balance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
*
*
* DONT FORGET TO USE PICASSO FOR IMAGE LOADIN
*
*
*/

public class ShareBalanceActivity extends Activity {

    private Card[] array;
    private int NUMBER_OF_COLUMNS = 2;
    private RecyclerViewAdapter adapter;

    @BindView(R.id.recyclerview)        RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_share_balance);
        ButterKnife.bind(this);

        setUpData();

        adapter = new RecyclerViewAdapter(this, array);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getApplicationContext(), R.dimen.item_offset);
        recyclerView.setLayoutManager(new GridLayoutManager(this, NUMBER_OF_COLUMNS));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(itemDecoration);
    }

    private void setUpData() {
        array = new Card[6];
        array[0] = new Card("Twitter", R.drawable.ic_twitter, R.color.twitter);
        array[1] = new Card("Facebook", R.drawable.ic_facebook, R.color.facebook);
        array[2] = new Card("Google", R.drawable.ic_google, R.color.google);
        array[3] = new Card("Email", R.drawable.ic_email, R.color.email);
        array[4] = new Card("SNS", R.drawable.ic_sms, R.color.sns);
        array[5] = new Card("Pinterest", R.drawable.ic_pinterest, R.color.pinterest);
    }

    @OnClick(R.id.close_icon)
    public void close() {
        ShareBalanceActivity.this.finish();
        overridePendingTransition(R.anim.stay, R.anim.slide_out_up);
    }
}
