package com.example.jobrecruitingsystem.service.utils;

import com.example.jobrecruitingsystem.service.model.Skills;
import com.example.jobrecruitingsystem.service.model.Token;

import java.util.List;

public class InterfaceProvider {
    public interface CallBackForLogin{
        void getTokenFromResponse(Token token);
    }

    public interface CallBackForSkillList{
        void getSkillListResponse(List<Skills> skillsList);
    }
}
