package com.example.helloworld;

import com.example.helloworld.models.Data;
import com.example.helloworld.models.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("getdata")
    Call<Data> getData(@Field("name") String name);
}