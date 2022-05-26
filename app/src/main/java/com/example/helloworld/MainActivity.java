package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Interpolator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.adapters.ViewPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton button_account;
    ViewPager pager;
    View viewIndicatorOne,viewIndicatorTwo,viewIndicatorThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //variable initialization
        button_account = findViewById(R.id.id_account);
        viewIndicatorOne = findViewById(R.id.idViewIndicatorOne);
        viewIndicatorTwo = findViewById(R.id.idViewIndicatorTwo);
        viewIndicatorThree = findViewById(R.id.idViewIndicatorThree);
        //main

        //attach listener
        button_account.setOnClickListener(this::onClick);

        // Set the ViewPager adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(this,getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.idViewPagerPlans);
        pager.setAdapter(adapter);
        activeIndicator(0);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                
            }

            @Override
            public void onPageSelected(int position) {
                activeIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.id_account){
            startActivity(new Intent(MainActivity.this, new SharedPreferencesData(this).getToken()!=null?DashBoardActivity.class:RegistrationActivity.class));
            
            /*FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.idFragmentContainerView,new ChooseUserTypeFragment(),"CHOOSE_USER");
            ft.addToBackStack(null);
            ft.commit();*/
        }
    }
    
    void activeIndicator(int position){
        viewIndicatorOne.setBackgroundColor(Color.DKGRAY);
        viewIndicatorTwo.setBackgroundColor(Color.DKGRAY);
        viewIndicatorThree.setBackgroundColor(Color.DKGRAY);
        switch (position){
            case 0:
                viewIndicatorOne.setBackgroundColor(Color.WHITE);
                break;
            case 1:
                viewIndicatorTwo.setBackgroundColor(Color.WHITE);
                break;
            case 2:
                viewIndicatorThree.setBackgroundColor(Color.WHITE);
                break;
        }
    }
}