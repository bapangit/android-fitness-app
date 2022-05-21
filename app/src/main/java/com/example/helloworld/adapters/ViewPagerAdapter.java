package com.example.helloworld.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.helloworld.BlankFragment2;
import com.example.helloworld.BlankFragment3;
import com.example.helloworld.BlankFragment4;
import com.example.helloworld.CoachLoginFragment;
import com.example.helloworld.CoachRegistrationFragment;
import com.example.helloworld.MemberLoginFragment;
import com.example.helloworld.MemberRegistrationFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    Context mContext;

    public ViewPagerAdapter(Context context , FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BlankFragment2();
            case 1:
                return new BlankFragment3();
            case 2:
                return  new BlankFragment4();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}