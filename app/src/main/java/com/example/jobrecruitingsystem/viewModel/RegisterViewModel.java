package com.example.jobrecruitingsystem.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.jobrecruitingsystem.viewModel.remoteRepository.WebApiRepository;

import java.util.List;

public class RegisterViewModel extends AndroidViewModel {

    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

    public void insertUser(String firstName, String lastName, String email, String password, List role){
        new WebApiRepository(getApplication()).sendUser(firstName,lastName,email,password,role);
    }

}
