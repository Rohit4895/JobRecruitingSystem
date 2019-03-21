package com.example.jobrecruitingsystem.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JobSkill {

    @Expose
    @SerializedName("skills")
    private List<Skills> skills;
    @Expose
    @SerializedName("jobs")
    private Jobs jobs;

    public JobSkill() {
    }

    public JobSkill(List<Skills> skills, Jobs jobs) {
        this.skills = skills;
        this.jobs = jobs;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }
}
