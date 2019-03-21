package com.example.jobrecruitingsystem.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("token")
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
