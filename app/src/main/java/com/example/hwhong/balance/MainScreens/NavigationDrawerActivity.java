package com.example.hwhong.balance.MainScreens;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.hwhong.balance.PostSetUp.PagerSetUp.AggressiveFragment;
import com.example.hwhong.balance.PostSetUp.PagerSetUp.ConservativeFragment;
import com.example.hwhong.balance.PostSetUp.PagerSetUp.ModerateFragment;
import com.example.hwhong.balance.PostSetUp.ValuesActivity;
import com.example.hwhong.balance.R;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable the Title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // for full screen view
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // makes the action bar transparent
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            selectItem(1);
        } else if (id == R.id.nav_gallery) {
            selectItem(2);

        } else if (id == R.id.nav_slideshow) {
            selectItem(3);

        } else if (id == R.id.nav_manage) {
            selectItem(4);

        } else {
            selectItem(0);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new ValuesFragment();
                break;
            case 1:
                fragment = new AggressiveFragment();
                break;
            case 2:
                fragment = new ConservativeFragment();
                break;
            default:
                fragment = new ModerateFragment();
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            //mDrawerList.setItemChecked(position, true);
            //mDrawerList.setSelection(position);
            //setTitle(mNavigationDrawerItemTitles[position]);
            //drawer.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
}
