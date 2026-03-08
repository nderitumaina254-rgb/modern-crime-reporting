package com.example.crimereportingapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ReportCrimeActivity extends AppCompatActivity {

    EditText etCrimeType, etLocation, etDescription;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_crime);

        etCrimeType = findViewById(R.id.etCrimeType);
        etLocation = findViewById(R.id.etLocation);
        etDescription = findViewById(R.id.etDescription);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String crimeType = etCrimeType.getText().toString();
            String location = etLocation.getText().toString();
            String description = etDescription.getText().toString();

            if(crimeType.isEmpty() || location.isEmpty() || description.isEmpty()){
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                // For now, just show a Toast
                Toast.makeText(this, "Crime reported successfully!", Toast.LENGTH_SHORT).show();
                // TODO: Save to SQLite or server
                etCrimeType.setText("");
                etLocation.setText("");
                etDescription.setText("");
            }
        });
    }
}