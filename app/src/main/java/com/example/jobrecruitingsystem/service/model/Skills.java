package com.example.jobrecruitingsystem.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Skills {
    @Expose
    @SerializedName("skillName")
    private String skillname;
    @Expose
    @SerializedName("id")
    private int id;

    public Skills() {
    }

    public Skills(String skillname, int id) {
        this.skillname = skillname;
        this.id = id;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
