package com.example.jobrecruitingsystem.viewModel.remoteRepository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.jobrecruitingsystem.service.dao.ApiInterface;
import com.example.jobrecruitingsystem.service.model.Api;
import com.example.jobrecruitingsystem.service.model.Login;
import com.example.jobrecruitingsystem.service.model.Register;
import com.example.jobrecruitingsystem.service.model.Skills;
import com.example.jobrecruitingsystem.service.model.Token;
import com.example.jobrecruitingsystem.service.utils.AppExecutor;
import com.example.jobrecruitingsystem.service.utils.InterfaceProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebApiRepository {
    private Context context;
    private ApiInterface apiInterface;

    public WebApiRepository(Context context) {
        this.context = context;
        apiInterface = Api.getClient();
    }

    public void sendUser(String firstName, String lastName, String email, String password, List role){
        Register register = new Register(firstName, lastName, email, password, role, email);
        apiInterface.createUser(register).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("roh","inserted: "+response.isSuccessful());
                Toast.makeText(context,"inserted...",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("roh","Registration Error: "+t);
            }
        });
    }

    public void apiLoginUser(final InterfaceProvider.CallBackForLogin callBackForLogin, String userName, String password){
        Login login = new Login(userName,password);
        apiInterface.userLogin(login).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                Log.d("roh","token: "+response.body().getResult().getToken());
                callBackForLogin.getTokenFromResponse(response.body());
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.d("roh","Login Error: "+t);
            }
        });
    }

    public void sendSkill(String skillName){
        Skills skills = new Skills();
        skills.setSkillname(skillName);

        apiInterface.createSkill(skills).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("roh","Skill Inserted: ");
                Toast.makeText(context,"skill inserted...",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("roh","Skill Error: "+t);
            }
        });
    }

    public void getAllSkills(final InterfaceProvider.CallBackForSkillList callBackForSkillList, String token){

        apiInterface.getSkills(token).enqueue(new Callback<List<Skills>>() {
            @Override
            public void onResponse(Call<List<Skills>> call, Response<List<Skills>> response) {
                Log.d("roh","Skill Feched: "+response.body());
                List<Skills> list = response.body();
                callBackForSkillList.getSkillListResponse(list);
            }

            @Override
            public void onFailure(Call<List<Skills>> call, Throwable t) {
                Log.d("roh","SkillList Error: "+t);
            }
        });
    }
}
