package com.example.projectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class dashboard extends AppCompatActivity {

    private ListView projlistview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initWidgets();
        //loadFromDBtoMemory();
        setProjectAdapter();
    }

    private void initWidgets() {
        projlistview = findViewById(R.id.projectlist);
    }

    private void loadFromDBtoMemory() {
        SQLiteManager sqLiteManager = SQLiteManager.instanceofDB(this);
        sqLiteManager.populateProjectListArray();
    }

    private void setProjectAdapter() {
        project_adapter projadapter = new project_adapter(getApplicationContext(), project.projectArrayList);
        projlistview.setAdapter(projadapter);

    }

    public void gotonewproject(View view) {
        Intent intent = new Intent(this, ProjectDetailActivity.class);
        startActivity(intent);
    }
}