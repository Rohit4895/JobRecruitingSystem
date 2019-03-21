package com.example.jobrecruitingsystem.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.jobrecruitingsystem.service.model.Skills;
import com.example.jobrecruitingsystem.service.utils.InterfaceProvider;
import com.example.jobrecruitingsystem.viewModel.remoteRepository.WebApiRepository;

import java.util.List;

public class PostJobViewModel extends AndroidViewModel implements InterfaceProvider.CallBackForSkillList {

    private MutableLiveData<List<Skills>> skillList;

    public PostJobViewModel(@NonNull Application application) {
        super(application);
        skillList = new MutableLiveData<List<Skills>>();
    }

    public LiveData<List<Skills>> getSkillList(String token){
        new WebApiRepository(getApplication()).getAllSkills(this, token);
        return skillList;
    }


    @Override
    public void getSkillListResponse(List<Skills> skillsList) {
        skillList.postValue(skillsList);
    }
}
