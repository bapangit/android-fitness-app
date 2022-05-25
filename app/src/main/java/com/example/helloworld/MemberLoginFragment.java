package com.example.helloworld;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld.models.login.LoginError;
import com.example.helloworld.models.login.LoginFailed;
import com.example.helloworld.models.login.LoginSuccess;
import com.example.helloworld.models.registration.RegistrationError;
import com.google.gson.Gson;
import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonSizeSpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MemberLoginFragment extends Fragment {
    EditText editTextEmailField, editTextPasswordField;
    TextView buttonSignIn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_member_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        editTextEmailField = view.findViewById(R.id.idEditTextEmailField);
        editTextPasswordField = view.findViewById(R.id.idEditTextPasswordField);

        buttonSignIn = view.findViewById(R.id.idButtonSignIn);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(editTextEmailField.getText().toString(),editTextPasswordField.getText().toString());
            }
        });

    }

    void signIn(String email,String password){
        Call<LoginSuccess> call = RetrofitClient.getInstance().getMyApi().login(email, password);
        call.enqueue(new Callback<LoginSuccess>() {
            @Override
            public void onResponse(Call<LoginSuccess> call, Response<LoginSuccess> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getContext(), ""+response.body().getToken(), Toast.LENGTH_SHORT).show();
                }else{
                    if(response.code()==422){
                        LoginError errors = new Gson().fromJson(response.errorBody().charStream(), LoginError.class);
                        if(errors.getErrors().getEmail()!=null){
                            Balloon balloon = new Balloon.Builder(getContext())
                                    .setArrowSize(10)
                                    .setArrowOrientation(ArrowOrientation.TOP)
                                    .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
                                    .setArrowPosition(0.5f)
                                    .setWidth(BalloonSizeSpec.WRAP)
                                    .setHeight(65)
                                    .setTextSize(15f)
                                    .setCornerRadius(4f)
                                    .setAlpha(0.9f)
                                    .setText(errors.getErrors().getEmail().get(0))
                                    .setTextColor(ContextCompat.getColor(getContext(), R.color.accent))
                                    .setTextIsHtml(true)
                                    .setIconDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_help_24))
                                    .setBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary))
                                    .setBalloonAnimation(BalloonAnimation.FADE)
                                    .setLifecycleOwner(getActivity())
                                    .build();
                            balloon.showAlignTop(editTextEmailField);

                        }else if(errors.getErrors().getPassword()!=null){

                            Balloon balloon = new Balloon.Builder(getContext())
                                    .setArrowSize(10)
                                    .setArrowOrientation(ArrowOrientation.TOP)
                                    .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
                                    .setArrowPosition(0.5f)
                                    .setWidth(BalloonSizeSpec.WRAP)
                                    .setHeight(65)
                                    .setTextSize(15f)
                                    .setCornerRadius(4f)
                                    .setAlpha(0.9f)
                                    .setText(errors.getErrors().getPassword().get(0))
                                    .setTextColor(ContextCompat.getColor(getContext(), R.color.accent))
                                    .setTextIsHtml(true)
                                    .setIconDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_help_24))
                                    .setBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary))
                                    .setBalloonAnimation(BalloonAnimation.FADE)
                                    .setLifecycleOwner(getActivity())
                                    .build();
                            balloon.showAlignTop(editTextPasswordField);
                        }
                    }else if(response.code()==401){
                        LoginFailed failed = new Gson().fromJson(response.errorBody().charStream(), LoginFailed.class);
                        if(failed.getError()!=null){
                            Toast.makeText(getContext(), failed.getError(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginSuccess> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}