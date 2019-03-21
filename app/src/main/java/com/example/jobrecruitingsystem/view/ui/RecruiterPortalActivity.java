package com.example.jobrecruitingsystem.view.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.jobrecruitingsystem.R;

public class RecruiterPortalActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruiter_portal);

        recyclerView = findViewById(R.id.recruiterRecycler);


    }
}
