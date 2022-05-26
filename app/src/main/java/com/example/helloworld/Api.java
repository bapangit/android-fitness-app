package com.example.helloworld;

import com.example.helloworld.models.login.LoginSuccess;
import com.example.helloworld.models.registration.RegistrationSuccess;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    @Headers({"Accept: application/json"})
    @FormUrlEncoded
    @POST("register")
    Call<RegistrationSuccess> register(@Field("name") String name, @Field("email") String email, @Field("password") String password, @Field("conf_password") String confPassword);

    //@Headers({"Accept: application/json"})
    @FormUrlEncoded
    @POST("login")
    Call<LoginSuccess> login(@Field("email") String email, @Field("password") String password);
}