package com.shyamanu.merakivendor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shyamanu.merakivendor.R;

/**
 * Created by shwettank.ramteke on 4/5/2018.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtEmailId = null;
    private EditText edtPassword = null;
    private Button btnSignIn = null;
    private Button btnSignUp = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initialize components
        init();

        //add listener
        addOnClickListener();
    }


    private void init() {
         edtEmailId = (EditText) findViewById(R.id.editTextEmailAddress);
         edtPassword = (EditText) findViewById(R.id.editTextPassword);
         btnSignIn = (Button) findViewById(R.id.buttonSignIn);
         btnSignUp = (Button) findViewById(R.id.buttonSignUp);
    }

    private void addOnClickListener() {
        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.buttonSignIn:
                if(edtEmailId.length()==0 && edtPassword.length()==0){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_login_screen),Toast.LENGTH_SHORT).show();
                }else if(edtEmailId.length()==0){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_email_id),Toast.LENGTH_SHORT).show();
                }else if(edtPassword.length()==0){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_password),Toast.LENGTH_SHORT).show();
                }else{
                    validateFields();
                }

                break;

            case R.id.buttonSignUp:
                Intent intentProfileReg = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intentProfileReg);
                break;

            default:
                break;

        }
    }

    private void validateFields() {
        final String emailId = edtEmailId.getText().toString().trim();
        final String password = edtPassword.getText().toString().trim();

        if(emailId.equals("")){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_email_id),Toast.LENGTH_SHORT).show();
        }else if(password.equals("")){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_password),Toast.LENGTH_SHORT).show();
        }else{
            // showCongratsDialog();

            Intent intentProfileReg = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intentProfileReg);
        }
    }
}
