package com.example.jobrecruitingsystem.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {

    @Expose
    @SerializedName("result")
    private Result result;
    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("status")
    private int status;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
