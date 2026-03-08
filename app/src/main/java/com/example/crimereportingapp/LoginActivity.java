package com.example.crimereportingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button login, signup;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.btnLogin);
        signup = findViewById(R.id.btnSignup);

        db = new DatabaseHelper(this);

        login.setOnClickListener(v -> {

            String user = username.getText().toString();
            String pass = password.getText().toString();

            if(db.checkUser(user, pass)){
                Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeActivity.class));
            }
            else{
                Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
            }
        });

        signup.setOnClickListener(v ->
                startActivity(new Intent(this, SignupActivity.class))
        );
    }
}