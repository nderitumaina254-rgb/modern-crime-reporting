package com.example.crimereportingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button reportCrime, viewReports, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize buttons
        reportCrime = findViewById(R.id.btnReportCrime);
        viewReports = findViewById(R.id.btnViewReports);
        logout = findViewById(R.id.btnLogout);

        // Navigate to ReportCrimeActivity
        reportCrime.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ReportCrimeActivity.class);
            startActivity(intent);
        });

        // Navigate to ViewReportsActivity
        viewReports.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ViewReportsActivity.class);
            startActivity(intent);
        });

        // Logout back to MainActivity
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear activity stack
            startActivity(intent);
            finish();
        });
    }
}