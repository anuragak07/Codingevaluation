package com.masai.codingevaluation_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mbtnSignup;
    private Button mbtnSignin;
    private String emailValidation ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initView();
        mbtnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmailValid()&& isPasswordValid()){
                    Intent intent =new Intent(SignupActivity.this,SigninActivity.class);

                    startActivity(intent);
                }

            }
        });
    }

    private void initView(){
        mEtEmail =findViewById(R.id.etEmail);
        mEtPassword=findViewById(R.id.etPassword);
        mbtnSignup = findViewById(R.id.btnsignup);
        mbtnSignin = findViewById(R.id.signin);


    }
    private boolean isEmailValid() {
        if (mEtEmail.getText().toString().length() > 1 && mEtEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mEtEmail.setError("invalid Email");
            return false;

        }
    }
    private boolean isPasswordValid(){
            if (mEtPassword.getText().toString().length() >= 6) {
                return true;
            } else {
                mEtPassword.setError("password is weak");
                return false;
            }
        }

    }
