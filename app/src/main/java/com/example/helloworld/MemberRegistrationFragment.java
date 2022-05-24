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

import com.example.helloworld.models.RegistrationResponse;
import com.google.gson.Gson;
import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonSizeSpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemberRegistrationFragment extends Fragment {
    EditText editTextNameField,editTextEmailField,editTextPasswordField,editTextConfPasswordField;
    TextView signUp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_member_resistration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        editTextNameField = view.findViewById(R.id.idEditTextNameField);
        editTextEmailField = view.findViewById(R.id.idEditTextEmailField);
        editTextPasswordField = view.findViewById(R.id.idEditTextPasswordField);
        editTextConfPasswordField = view.findViewById(R.id.idEditTextConfPasswordField);
        signUp = view.findViewById(R.id.idSignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resister(editTextNameField.getText().toString(),editTextEmailField.getText().toString(),editTextPasswordField.getText().toString(),editTextConfPasswordField.getText().toString());
            }
        });
        
    }
    
    void resister(String name, String email, String password,String confPassword){
        Call<RegistrationResponse> call = RetrofitClient.getInstance().getMyApi().register(name,email,password,confPassword);
        call.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                if(response.isSuccessful()){
                RegistrationResponse data = response.body();
                    Toast.makeText(getContext(), "Registration Successful with email "+data.getUser().getEmail(), Toast.LENGTH_SHORT).show();

                }else{
                    if(response.errorBody()!=null){
                        RegistrationResponse errors = new Gson().fromJson(response.errorBody().charStream(), RegistrationResponse.class);
                        if(errors.getErrors().getName()!=null){
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
                                    .setText(errors.getErrors().getName().get(0))
                                    .setTextColor(ContextCompat.getColor(getContext(), R.color.accent))
                                    .setTextIsHtml(true)
                                    .setIconDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_help_24))
                                    .setBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary_light))
                                    .setBalloonAnimation(BalloonAnimation.FADE)
                                    .setLifecycleOwner(getActivity())
                                    .build();
                                    balloon.showAlignTop(editTextNameField);
                                    
                        }else if(errors.getErrors().getEmail()!=null){
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
                                    .setBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary_light))
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
                                    .setBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary_light))
                                    .setBalloonAnimation(BalloonAnimation.FADE)
                                    .setLifecycleOwner(getActivity())
                                    .build();
                            balloon.showAlignTop(editTextPasswordField);
                        }else if(errors.getErrors().getConf_password()!=null){
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
                                    .setText(errors.getErrors().getConf_password().get(0))
                                    .setTextColor(ContextCompat.getColor(getContext(), R.color.accent))
                                    .setTextIsHtml(true)
                                    .setIconDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_help_24))
                                    .setBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary_light))
                                    .setBalloonAnimation(BalloonAnimation.FADE)
                                    .setLifecycleOwner(getActivity())
                                    .build();
                            balloon.showAlignTop(editTextConfPasswordField);
                        }

                    }else{
                        Toast.makeText(getContext(), "Something Went Wrong !", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}