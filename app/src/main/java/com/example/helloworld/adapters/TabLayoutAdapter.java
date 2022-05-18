package com.example.helloworld.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.helloworld.CoachResistration;
import com.example.helloworld.MemberResistration;

public class TabLayoutAdapter extends FragmentPagerAdapter {

    Context mContext;
    int mTotalTabs;

    public TabLayoutAdapter(Context context , FragmentManager fragmentManager , int totalTabs) {
        super(fragmentManager);
        mContext = context;
        mTotalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MemberResistration();
            case 1:
                return new CoachResistration();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return mTotalTabs;
    }
}