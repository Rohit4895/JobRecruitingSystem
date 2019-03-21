package com.example.jobrecruitingsystem.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jobrecruitingsystem.R;
import com.example.jobrecruitingsystem.service.model.Api;
import com.example.jobrecruitingsystem.service.model.Login;
import com.example.jobrecruitingsystem.service.model.Token;
import com.example.jobrecruitingsystem.viewModel.LoginViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView userNameEditText, passwordEditText, gotoRegister;
    private Button login;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameEditText = findViewById(R.id.loginEmail);
        passwordEditText = findViewById(R.id.loginPassword);
        login = findViewById(R.id.loginButton);
        gotoRegister = findViewById(R.id.registerHere);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        login.setOnClickListener(this);
        gotoRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.loginButton:
                String userName = userNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                loginViewModel.loginUser(userName,password).observe(LoginActivity.this, new Observer<Token>() {
                    @Override
                    public void onChanged(@Nullable Token token) {
                        Log.d("roh","Login Activity: "+token.getResult().getToken());
                        Intent intent = new Intent(LoginActivity.this, PostJobActivity.class);
                        intent.putExtra("token",token.getResult().getToken());
                        startActivity(intent);
                    }
                });
                break;

            case R.id.registerHere:
               /* Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);*/
                Intent intent = new Intent(LoginActivity.this, PostJobActivity.class);
                startActivity(intent);
                break;
        }
    }
}
