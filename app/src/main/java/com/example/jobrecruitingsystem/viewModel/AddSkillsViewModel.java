package com.example.jobrecruitingsystem.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.jobrecruitingsystem.viewModel.remoteRepository.WebApiRepository;

public class AddSkillsViewModel extends AndroidViewModel {

    public AddSkillsViewModel(@NonNull Application application) {
        super(application);
    }

    public void insertSkills(String skillName){
        new WebApiRepository(getApplication()).sendSkill(skillName);
    }
}
