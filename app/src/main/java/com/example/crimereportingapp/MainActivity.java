package com.example.crimereportingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login, signup;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.btnLogin);
        signup = findViewById(R.id.btnSignup);

        db = new DatabaseHelper(this);

        login.setOnClickListener(v -> {

            String user = username.getText().toString();
            String pass = password.getText().toString();

            if(user.isEmpty() || pass.isEmpty()){
                Toast.makeText(this,"Enter Username and Password",Toast.LENGTH_SHORT).show();
                return;
            }

            boolean checkUser = db.checkUser(user, pass);

            if(checkUser){
                Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }else{
                Toast.makeText(this,"Invalid Username or Password",Toast.LENGTH_SHORT).show();
            }
        });

        signup.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SignupActivity.class));
        });
    }
}