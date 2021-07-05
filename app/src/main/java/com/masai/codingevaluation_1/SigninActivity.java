package com.masai.codingevaluation_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SigninActivity extends AppCompatActivity {
    private EditText mTvUsername;
    private EditText mTvPassword1;
    private Button mbtnSignup1;
    private Button mbtnSignin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Intent intent =getIntent();
        Initview1();
        mbtnSignin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isUsernameValid()&&isPassword1Valid()){
                    Intent intent = new Intent(SigninActivity.this,HomeActivity.class);
                    intent.putExtra("Username",mTvUsername.getText().toString());
                    startActivity(intent);

                }

            }
        });
    }

    private void Initview1() {
        mTvUsername = findViewById(R.id.etUsername);
        mTvPassword1 =findViewById(R.id.etPassword1);
        mbtnSignin1 = findViewById(R.id.signin1);
        mbtnSignup1 = findViewById(R.id.btnsignup1);

    }
    private boolean isUsernameValid() {
        if (mTvUsername.getText().toString().length() >=4 ) {
            return true;
        } else {
            mTvUsername.setError("invalid name");
            return false;

        }
    }
    private boolean isPassword1Valid(){
        if (mTvPassword1.getText().toString().length() >= 6) {
            return true;
        } else {
            mTvPassword1.setError("password is incorrect");
            return false;
        }
    }
}