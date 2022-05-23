package com.example.helloworld;

import com.example.helloworld.models.Data;
import com.example.helloworld.models.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("registername")
    Call<Data> getName(@Field("name") String name);

    @FormUrlEncoded
    @POST("register")
    Call<RegistrationResponse> register(@Field("name") String name, @Field("email") String email, @Field("password") String password, @Field("conf_password") String confPassword);
}