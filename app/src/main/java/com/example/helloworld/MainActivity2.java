package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.helloworld.models.registration.RegistrationSuccess;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    Button fetchBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fetchBtn = findViewById(R.id.idButtonFetch);

        fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetch();
                //registerUser();
            }
        });
        
        //DynamicToast.makeError(this, "Error toast").show();
    }
    void fetch(){

    }
    void registerUser(){
        Call<RegistrationSuccess> call = RetrofitClient.getInstance().getMyApi().register("trht4rh","user4@gmail.com","password","passcode");
        call.enqueue(new Callback<RegistrationSuccess>() {
            @Override
            public void onResponse(Call<RegistrationSuccess> call, Response<RegistrationSuccess> response) {
                Toast.makeText(MainActivity2.this, "response "+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("jsonres",new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
            }

            @Override
            public void onFailure(Call<RegistrationSuccess> call, Throwable t) {
                Toast.makeText(MainActivity2.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("mss",t.getMessage());
            }
        });
    }
}