package com.shyamanu.merakivendor.activity;

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

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtVendorName = null;
    private EditText edtEmailId = null;
    private EditText edtPinCode = null;
    private EditText edtFileName = null;
    private EditText edtDealsIn = null;
    private EditText edtPassword = null;
    private Button btnSignUp = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // initialize components
        initView();

        // add listener
        addOnClickListener();
    }

    private void initView() {
        edtVendorName = (EditText) findViewById(R.id.editTextVendorName);
        edtEmailId = (EditText) findViewById(R.id.editTextEmailId);
        edtPinCode = (EditText) findViewById(R.id.editTextPinCode);
        edtFileName = (EditText) findViewById(R.id.editTextFileName);
        edtDealsIn = (EditText) findViewById(R.id.editTextDealsIn);
        edtPassword = (EditText) findViewById(R.id.editTextPassword);
        btnSignUp = (Button) findViewById(R.id.buttonSignUp);

    }

    private void addOnClickListener() {
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        case R.id.buttonSignUp:
            if(edtVendorName.length()==0 && edtEmailId.length()==0 && edtPinCode.length()==0 &&
                    edtDealsIn.length()==0 && edtPassword.length()==0){
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.validate_sign_up_screen), Toast.LENGTH_SHORT).show();
            }else if(edtVendorName.length()==0){
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_vendor_name),Toast.LENGTH_SHORT).show();
            }else if(edtEmailId.length()==0){
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_email_id),Toast.LENGTH_SHORT).show();
            }else if(edtPinCode.length()==0){
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_pin_code),Toast.LENGTH_SHORT).show();
            }else if(edtDealsIn.length()==0){
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_deals_in),Toast.LENGTH_SHORT).show();
            }else if(edtPassword.length()==0){
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_password),Toast.LENGTH_SHORT).show();
            }else{
                validateFields();
            }
             break;

        default:
             break;

        }

    }

    private void validateFields() {
        final String vendorName = edtVendorName.getText().toString().trim();
        final String emailId = edtEmailId.getText().toString().trim();
        final String pinCode = edtPinCode.getText().toString().trim();
        final String dealsIn = edtDealsIn.getText().toString().trim();
        final String password = edtPassword.getText().toString().trim();

        if(vendorName.equals("")){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_vendor_name),Toast.LENGTH_SHORT).show();
        }else if(emailId.equals("")){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_email_id),Toast.LENGTH_SHORT).show();
        }else if(pinCode.equals("")){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_pin_code),Toast.LENGTH_SHORT).show();
        }else if(dealsIn.equals("")){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_deals_in),Toast.LENGTH_SHORT).show();
        }else if(password.equals("")){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_password),Toast.LENGTH_SHORT).show();
        }else{
            // showCongratsDialog();
            /*Intent intentProfileReg = new Intent(VerifyOTPActivity.this,RegistrationActivity.class);
            startActivity(intentProfileReg);*/
        }
    }
}
