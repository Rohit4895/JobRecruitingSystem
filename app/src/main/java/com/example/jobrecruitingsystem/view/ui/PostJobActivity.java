package com.example.jobrecruitingsystem.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.jobrecruitingsystem.R;
import com.example.jobrecruitingsystem.service.model.Skills;
import com.example.jobrecruitingsystem.viewModel.PostJobViewModel;

import java.util.ArrayList;
import java.util.List;

public class PostJobActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView addSkillView;
    private Button addJob;
    private EditText cityEditText, companyEditText, salaryEditText, jobTitleEditText;
    private Spinner skillsSpinner;
    private PostJobViewModel postJobViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);

        addSkillView = findViewById(R.id.addSkill);
        addJob = findViewById(R.id.addJobs);
        cityEditText = findViewById(R.id.city);
        companyEditText = findViewById(R.id.companyName);
        salaryEditText = findViewById(R.id.salary);
        jobTitleEditText = findViewById(R.id.jobTitle);
        skillsSpinner =(Spinner) findViewById(R.id.skillsSpinner);

        addSkillView.setOnClickListener(this);
        String token = "Bearer "+getIntent().getStringExtra("token");


        postJobViewModel = ViewModelProviders.of(this).get(PostJobViewModel.class);
        postJobViewModel.getSkillList(token).observe(this, new Observer<List<Skills>>() {
            @Override
            public void onChanged(@Nullable List<Skills> skillsList) {
                if (skillsList == null)
                    return;
                List<String> sortedSkillList = new ArrayList<String>();
                for (int i=0; i<skillsList.size(); i++){
                    Skills skills = skillsList.get(i);
                    sortedSkillList.add(skills.getId()+". "+skills.getSkillname());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_spinner_item, sortedSkillList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                skillsSpinner.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.addSkill:
                String companyName = companyEditText.getText().toString();
                String city = cityEditText.getText().toString();
                String jobTitle = jobTitleEditText.getText().toString();
                String salary = salaryEditText.getText().toString();

                Intent intent = new Intent(PostJobActivity.this, AddSkillsActivity.class);
                startActivityForResult(intent,1);
                break;
        }
    }
}
