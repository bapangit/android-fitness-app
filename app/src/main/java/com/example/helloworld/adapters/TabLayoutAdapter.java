package com.example.helloworld.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.helloworld.CoachLoginFragment;
import com.example.helloworld.CoachRegistrationFragment;
import com.example.helloworld.MemberLoginFragment;
import com.example.helloworld.MemberRegistrationFragment;

public class TabLayoutAdapter extends FragmentPagerAdapter {

    Context mContext;
    int mTotalTabs;
    int userType;

    public TabLayoutAdapter(Context context , FragmentManager fragmentManager , int totalTabs) {
        super(fragmentManager);
        mContext = context;
        mTotalTabs = totalTabs;
        this.userType = userType;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //userType = 0; //maintaining usertype always member
        switch (position) {
            case 0:
                return new MemberLoginFragment();
            case 1:
                return new MemberRegistrationFragment();
            default:
                return null;}
    }

    @Override
    public int getCount() {
        return mTotalTabs;
    }
}