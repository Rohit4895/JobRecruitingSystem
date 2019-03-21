package com.example.jobrecruitingsystem.view.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jobrecruitingsystem.R;
import com.example.jobrecruitingsystem.viewModel.AddSkillsViewModel;

public class AddSkillsActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText skillEditText;
    private Button insertSkill;
    private AddSkillsViewModel addSkillsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_skills);

        skillEditText = findViewById(R.id.skillEditText);
        insertSkill = findViewById(R.id.insertSkill);

        addSkillsViewModel = ViewModelProviders.of(this).get(AddSkillsViewModel.class);

        insertSkill.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.insertSkill:
                String skillName = skillEditText.getText().toString();
                addSkillsViewModel.insertSkills(skillName);
                finish();
                break;
        }
    }
}
