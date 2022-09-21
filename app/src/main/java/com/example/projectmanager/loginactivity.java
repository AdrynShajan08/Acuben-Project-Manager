package com.example.projectmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class loginactivity extends AppCompatActivity {

    TextView username;
    TextView password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        username =(TextView) findViewById(R.id.username);
        password =(TextView) findViewById(R.id.password);

        DB = new DBHelper(this);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbutton);
        MaterialButton tosignuppage = (MaterialButton) findViewById(R.id.logintosignupbutton);

        loginbtn.setOnClickListener(v -> loginbuttonaction(v));
        tosignuppage.setOnClickListener(v -> goToSignupPage(v));
    }

    public void loginbuttonaction(View v){
        String user = username.getText().toString();
        String pass = password.getText().toString();

        if(user.equals("") || pass.equals("")){
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
        }else{
            Boolean checkuser = DB.checkusernamepassword(user, pass);
            if(checkuser){
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (this, dashboard.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void goToSignupPage(View v){
        //Toast.makeText(loginactivity.this,"Button was clicked",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
}