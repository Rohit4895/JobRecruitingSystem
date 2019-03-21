package com.example.jobrecruitingsystem.view.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobrecruitingsystem.R;
import com.example.jobrecruitingsystem.service.model.Api;
import com.example.jobrecruitingsystem.service.model.Register;
import com.example.jobrecruitingsystem.viewModel.RegisterViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner spinner;
    private  List<String> spinnerList;
    private Button register;
    private TextInputEditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText;
    private RegisterViewModel registerViewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinner = findViewById(R.id.spinner);
        register = findViewById(R.id.register);
        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.lastName);
        emailEditText = findViewById(R.id.registerEmail);
        passwordEditText = findViewById(R.id.registerPassword);
        textView = findViewById(R.id.loginHere);

        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);

        spinnerList = new ArrayList<String>();
        spinnerList.add("---select role---");
        spinnerList.add("ROLE_USER");
        spinnerList.add("ROLE_RECRUITER");

        ArrayAdapter spinnerAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,spinnerList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);
        register.setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.register:
                String role = spinner.getSelectedItem().toString();
                List roleList = new ArrayList();
                roleList.add(role);
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                registerViewModel.insertUser(firstName,lastName,email,password,roleList);
                break;

            case R.id.loginHere:
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
