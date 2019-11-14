package com.fragments.bottomnavassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.xml.namespace.NamespaceContext;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText loginpassword, emailid;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        emailid = findViewById(R.id.login_emailid);
        loginpassword = findViewById(R.id.login_password);
        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {


        if (emailid.getText().toString().equals("sandip") && loginpassword.getText().toString().equals("sandip")) {
            Intent i = new Intent(MainActivity.this, NavActivity.class);
            startActivity(i);


        } else {
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();

        }

    }
}


