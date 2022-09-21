package com.example.projectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setContentView(R.layout.activity_loginactivity);

        final Button button = findViewById(R.id.proceed);
        button.setOnClickListener(v -> goToLoginPage(v));
    }

    public void goToLoginPage(View v) {
        //Toast.makeText(MainActivity.this,"App launched successfully",Toast.LENGTH_SHORT).show();

        Intent i = new Intent(MainActivity.this, loginactivity.class);

        startActivity(i);
    }
}