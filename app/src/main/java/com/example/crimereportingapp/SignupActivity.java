package com.example.crimereportingapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText fullname,email,username,password;
    Button register;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullname = findViewById(R.id.etFullName);
        email = findViewById(R.id.etEmail);
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        register = findViewById(R.id.btnRegister);

        db = new DatabaseHelper(this);

        register.setOnClickListener(v -> {

            String fn = fullname.getText().toString();
            String em = email.getText().toString();
            String us = username.getText().toString();
            String ps = password.getText().toString();

            boolean inserted = db.insertUser(fn,em,us,ps);

            if(inserted){
                Toast.makeText(this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this,"Registration Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}