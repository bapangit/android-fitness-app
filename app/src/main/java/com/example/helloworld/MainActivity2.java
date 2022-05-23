package com.example.helloworld;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.helloworld.models.Data;
import com.example.helloworld.models.Post;
import com.example.helloworld.models.ResistrationResponse;
import com.pranavpandey.android.dynamic.toasts.DynamicToast;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonSizeSpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    Balloon balloon;
    Button fetchBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         fetchBtn = findViewById(R.id.idButtonFetch);
        fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetch();
                balloon.showAlignTop(fetchBtn);
            }
        });

       balloon = new Balloon.Builder(this)
               .setWidthRatio(1.0f)
                .setHeight(BalloonSizeSpec.WRAP)
                .setText("Edit your profile here!")
                .setTextColorResource(R.color.primary_light)
                .setTextSize(15f)
                .setIconDrawableResource(R.drawable.ic_baseline_help_24)
                .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
                .setArrowSize(10)
                .setArrowPosition(0.5f)
                .setPadding(12)
                .setCornerRadius(8f)
                .setBackgroundColorResource(R.color.primary)
                .setBalloonAnimation(BalloonAnimation.ELASTIC)
                .setLifecycleOwner(this)
                .build();
                
                balloon.showAlignTop(fetchBtn);
        
        //DynamicToast.makeError(this, "Error toast").show();
    }
    void fetch(){
        Call<Data> call = RetrofitClient.getInstance().getMyApi().getData("Bapan");
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(response.isSuccessful()){
                    Data data = response.body();

                    Toast.makeText(MainActivity2.this, ""+data.getEmail(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("errmsg",t.getMessage());
                Toast.makeText(MainActivity2.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}