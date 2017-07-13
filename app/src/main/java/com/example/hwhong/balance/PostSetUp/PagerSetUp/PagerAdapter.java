package com.example.hwhong.balance.PostSetUp.PagerSetUp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hwhong on 7/13/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ConservativeFragment();
            case 1:
                return new ModerateFragment();
            case 2:
                return new AggressiveFragment();
            default: break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
