package com.example.helloworld.models;


import com.google.gson.annotations.SerializedName;

public class ResistrationResponse {

    @SerializedName("user")
    private User user;
    @SerializedName("status")
    private Boolean status;
    @SerializedName("message")
    private String message;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}