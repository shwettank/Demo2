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

public class PurchaseProductActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnDate = null;
    private EditText edtVendorName = null;
    private EditText edtPrice = null;
    private EditText edtQuantity = null;
    private EditText edtUnit = null;
    private Button btnPay = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_product);

        // initialize components
        initView();

        // add listener
        addOnClickListener();
    }

    /**
    * initialize components
    */
    private void initView() {
       edtVendorName = (EditText) findViewById(R.id.editTextVendorName);
       edtPrice = (EditText) findViewById(R.id.editTextPrice);
       edtQuantity = (EditText) findViewById(R.id.editTextQuantity);
       edtUnit = (EditText) findViewById(R.id.editTextUnit);
       btnDate = (Button) findViewById(R.id.buttonDate);
       btnPay = (Button) findViewById(R.id.buttonPay);
    }

    private void addOnClickListener() {
      btnDate.setOnClickListener(this);
      btnPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonDate:

            break;

            case R.id.buttonPay:

                if(edtVendorName.length()==0 && edtPrice.length()==0 &&
                        edtQuantity.length() == 0 && edtUnit.length() ==0){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_sign_up_screen),Toast.LENGTH_SHORT).show();
                }else if(edtVendorName.length() ==0){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_vendor_name),Toast.LENGTH_SHORT).show();
                }else if(edtPrice.length()==0){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_price),Toast.LENGTH_SHORT).show();
                }else if(edtQuantity.length()==0){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_quantity),Toast.LENGTH_SHORT).show();
                }else if(edtUnit.length()==0){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.validate_unit),Toast.LENGTH_SHORT).show();
                }else{
                    // go to verify customer Activity

                    Intent intentVerifyCustomer = new Intent(PurchaseProductActivity.this,VerifyCustomer.class);
                    startActivity(intentVerifyCustomer);

                }

                break;

            default:
                break;
        }
    }
}
