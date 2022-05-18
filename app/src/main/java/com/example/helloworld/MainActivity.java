package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton button_account;
    FragmentResistration membersResistration;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        //variable initialization
        button_account = findViewById(R.id.id_account);


        fragmentManager = getSupportFragmentManager();
        //fragments
        membersResistration = new FragmentResistration();


        //main
        //attach listener
        button_account.setOnClickListener(this::onClick);


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.id_account){
           FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.addToBackStack("TAG_OF_FRAGMENT");
            ft.add(R.id.fragmentContainerView, membersResistration).commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 0)
            fragmentManager.popBackStackImmediate();
        else super.onBackPressed();
    }

}