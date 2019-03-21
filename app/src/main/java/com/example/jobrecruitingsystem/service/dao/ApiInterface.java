package com.example.jobrecruitingsystem.service.dao;

import com.example.jobrecruitingsystem.service.model.Login;
import com.example.jobrecruitingsystem.service.model.Register;
import com.example.jobrecruitingsystem.service.model.Skills;
import com.example.jobrecruitingsystem.service.model.Token;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("/register/users")
    Call<Void> createUser(@Body Register register);

    @POST("/login/user")
    Call<Token> userLogin(@Body Login login);

    @POST("/register/skills")
    Call<Void> createSkill(@Body Skills skills);

    @GET("/get/skillList")
    Call<List<Skills>> getSkills(@Header("Authorization") String authHeader);
}
