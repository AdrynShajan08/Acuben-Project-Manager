package com.example.projectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProjectDetailActivity extends AppCompatActivity {

    private EditText titleET, descET, subjectET, duedateET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newproject);
        initWidgets();
    }

    private void initWidgets() {
        titleET =findViewById(R.id.projtitle);
        descET = findViewById(R.id.projdescription);
        subjectET = findViewById(R.id.projsubject);
        duedateET = findViewById(R.id.projduedate);
    }

    public void saveproject(View view) {
        SQLiteManager sqLiteManager = SQLiteManager.instanceofDB(this);
        String title = String.valueOf(titleET.getText());
        String desc = String.valueOf(descET.getText());
        String subject = String.valueOf(subjectET.getText());
        String duedate = String.valueOf(duedateET.getText());

        int id = project.projectArrayList.size();

        project newproj = new project(id, title, desc, subject, duedate);
        project.projectArrayList.add(newproj);
        sqLiteManager.addProjectToDatabase(newproj);

        finish();
    }
}