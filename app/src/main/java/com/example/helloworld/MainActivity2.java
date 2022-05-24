package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.helloworld.models.Data;
import com.example.helloworld.models.Errors;
import com.example.helloworld.models.RegistrationResponse;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.lang.annotation.Annotation;

import kotlin.io.TextStreamsKt;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.ErrorCode;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
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
                //fetch();
                registerUser();
            }
        });
        
        //DynamicToast.makeError(this, "Error toast").show();
    }
    void fetch(){
        Call<Data> call = RetrofitClient.getInstance().getMyApi().getName("Chandan");
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Log.d("jsonres",new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
                if(response.isSuccessful()){
                    Data data = response.body();


                }else{
                    Toast.makeText(MainActivity2.this,"unsuccessful "+response.code()+" ", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("errmsg",t.getMessage());
                Toast.makeText(MainActivity2.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    void registerUser(){
        Call<RegistrationResponse> call = RetrofitClient.getInstance().getMyApi().register("name","user15@gmail.com","password","password");
        call.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                if(response.isSuccessful()){
                    RegistrationResponse data = response.body();
                    Toast.makeText(MainActivity2.this, ""+data.getUser().getEmail(), Toast.LENGTH_SHORT).show();

                }else{
                    if(response.errorBody()!=null){
                        RegistrationResponse errors = new Gson().fromJson(response.errorBody().charStream(), RegistrationResponse.class);
                        Toast.makeText(MainActivity2.this, ""+errors.getErrors().getEmail().get(0), Toast.LENGTH_SHORT).show();
                        
                    }else{
                        Toast.makeText(MainActivity2.this, "Something Went Wrong !", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Log.d("errmsg",t.getMessage());
                Toast.makeText(MainActivity2.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}