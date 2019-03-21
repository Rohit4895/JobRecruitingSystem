package com.example.jobrecruitingsystem.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Jobs {
    @Expose
    @SerializedName("salary")
    private int salary;
    @Expose
    @SerializedName("jobTitle")
    private String jobtitle;
    @Expose
    @SerializedName("companyName")
    private String companyname;
    @Expose
    @SerializedName("city")
    private String city;
    @Expose
    @SerializedName("id")
    private int id;

    public Jobs() {
    }

    public Jobs(int salary, String jobtitle, String companyname, String city) {
        this.salary = salary;
        this.jobtitle = jobtitle;
        this.companyname = companyname;
        this.city = city;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
