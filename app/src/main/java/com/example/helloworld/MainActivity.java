package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton button_account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //variable initialization
        button_account = findViewById(R.id.id_account);

        //main
        //attach listener
        button_account.setOnClickListener(this::onClick);


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.id_account){
            //startActivity(new Intent(MainActivity.this, RegistrationActivity.class));

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.idFragmentContainerView,new ChooseUserTypeFragment(),"CHOOSE_USER");
            ft.addToBackStack(null);
            ft.commit();
        }
    }



}