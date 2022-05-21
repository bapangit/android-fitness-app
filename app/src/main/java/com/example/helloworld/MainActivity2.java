package com.example.helloworld;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.helloworld.models.Post;
import com.example.helloworld.models.ResistrationResponse;
import com.pranavpandey.android.dynamic.toasts.DynamicToast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Call<ResistrationResponse> call = RetrofitClient.getInstance().getMyApi().register("example@gmail.com","name","password","confirm_password");
        /*call.enqueue(new Callback<ResistrationResponse>() {
            @Override
            public void onResponse(Call<ResistrationResponse> call, Response<ResistrationResponse> response) {
                ResistrationResponse resistrationResponse = response.body();
                Log.d("res",resistrationResponse.getMessage());
            }

            @Override
            public void onFailure(Call<ResistrationResponse> call, Throwable t) {
                Toast.makeText(MainActivity2.this, "failure", Toast.LENGTH_SHORT).show();
            }
        });*/
        DynamicToast.makeError(this, "Error toast").show();
    }
}