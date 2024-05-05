package com.thestart.welcome_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class logmein extends AppCompatActivity {
    EditText userEdit, passwdEdit;
    TextView foregetText;
    Button loginButton;
    boolean IsAllFieldChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logmein);
        userEdit = findViewById(R.id.usernameid);
        passwdEdit= findViewById(R.id.passwdid);
        foregetText = findViewById(R.id.textViewid1);
        loginButton = findViewById(R.id.logButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IsAllFieldChecked = AllChecked();
                if(IsAllFieldChecked){
                    Intent intent = new Intent(logmein.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        foregetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(logmein.this, "Page under Development!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean AllChecked() {
        if (userEdit.length()==0){
            userEdit.setError("Username Field cannot be empty");
            return false;
        }
        if (passwdEdit.length()==0){
            passwdEdit.setError("Password Feild cannot be empty");
        } else if (passwdEdit.length() < 8) {
            passwdEdit.setError("Invalid Password, Password should contain minimum 8 characters");
            return  false;
        }
        return  true;
    }
}