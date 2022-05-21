package com.example.helloworld;

import com.example.helloworld.models.ResistrationResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "https://gym.apsdp.in/api/";

    @POST("register")
    Call<ResistrationResponse> register(
            @Field("email") String email     ,
            @Field("name") String name,
            @Field("password") String password,
            @Field("conf_password") String conf_password
    );
}