package com.deluxan.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseUser currentUser;
    private EditText email, password;
    private TextView forgetPassword, needAnAccount;
    private Button login, phoneLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeFields();

        needAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToRegister();
            }
        });
    }

    private void redirectToRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void initializeFields() {
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        forgetPassword = findViewById(R.id.forget_password);
        needAnAccount = findViewById(R.id.create_account);
        login = findViewById(R.id.login_button);
        phoneLogin = findViewById(R.id.phone_button);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (currentUser != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
