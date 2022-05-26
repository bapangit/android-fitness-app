package com.example.helloworld;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesData {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private Context context;

    private final String TOKEN_ID = "tokenId";

    public SharedPreferencesData(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("myData",context.MODE_PRIVATE);
        editor = sp.edit();
    }
    public void setToken(String id){
        editor.putString(TOKEN_ID,id);
        editor.apply();
    }
    public String getToken(){
        return sp.getString(TOKEN_ID,null);
    }

}