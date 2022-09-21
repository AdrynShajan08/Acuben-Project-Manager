package com.example.projectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class signup extends AppCompatActivity {

    TextView username;
    TextView password;
    TextView fullname;
    TextView email;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        fullname = (EditText) findViewById(R.id.fullname);
        email = (EditText) findViewById(R.id.email);

        DB = new DBHelper (this);

        Button signup = (Button) findViewById(R.id.signupbutton);
        Button tologinpage = (Button) findViewById(R.id.logintosignupbutton);

        signup.setOnClickListener(v -> signupbuttonaction(v));
        tologinpage.setOnClickListener(v -> goToLoginPage(v));
    }

    private void goToLoginPage(View v) {
        Intent intent = new Intent(signup.this, loginactivity.class);
        startActivity(intent);
    }

    private void signupbuttonaction(View v) {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        String fname = fullname.getText().toString();
        String emailid = email.getText().toString();

        if (user.equals("") || pass.equals("") || fname.equals("") || emailid.equals("")) {
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
        } else {
            Boolean checkuser = DB.checkusername(user);
            if(!checkuser){
                Boolean insert = DB.insertData(user, pass);
                if(insert){
                    Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, dashboard.class);

                    startActivity(intent);
                }else {
                    Toast.makeText(this, "Registered unsuccessfully", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "User already exists, please log in", Toast.LENGTH_SHORT).show();
            }
        }
    }
}