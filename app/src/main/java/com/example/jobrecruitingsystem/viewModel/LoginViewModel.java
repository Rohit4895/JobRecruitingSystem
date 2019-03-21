package com.example.jobrecruitingsystem.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.jobrecruitingsystem.service.model.Token;
import com.example.jobrecruitingsystem.service.utils.InterfaceProvider;
import com.example.jobrecruitingsystem.viewModel.remoteRepository.WebApiRepository;

public class LoginViewModel extends AndroidViewModel implements InterfaceProvider.CallBackForLogin {

    private MutableLiveData<Token> tokenStatus;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        tokenStatus = new MutableLiveData<Token>();
    }

    public LiveData<Token> loginUser(String userName, String password){
        new WebApiRepository(getApplication()).apiLoginUser(this,userName,password);
        return tokenStatus;
    }

    @Override
    public void getTokenFromResponse(Token token) {
        tokenStatus.postValue(token);
    }
}
