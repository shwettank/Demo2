package com.shyamanu.merakivendor.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shyamanu.merakivendor.R;
import com.shyamanu.merakivendor.utils.Utility;

/**
 * Created by shwettank.ramteke on 3/28/2018.
 */

public class VerifyOTPActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edt_otp1= null;
    private EditText edt_otp2= null;
    private EditText edt_otp3= null;
    private EditText edt_otp4= null;
    private Button btnResendOTP = null;
    private ImageView roundedImage =  null;
    private TextView txtCountDownTimer = null;
    private FloatingActionButton submitFloatingActionButton = null;
    private Dialog dialog = null;
    StringBuilder sb;
    private final long startTime = 60 * 1000;
    private final long interval = 1 * 1000;

    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;

    @Override
    protected void  onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        // initView
        init();

        // add listener
        addListener();

        // keyboard done button event
        keyboardDone();


        countDownTimer = new MyCountDownTimer(startTime, interval);
        txtCountDownTimer.setText(txtCountDownTimer.getText() + String.valueOf(startTime / 1000));

        if (!timerHasStarted) {
            countDownTimer.start();
            timerHasStarted = true;
        } else {
            countDownTimer.cancel();
            timerHasStarted = false;
        }

        Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.phone_hand_one);
        roundedImage.setImageBitmap(icon);

        /*edt_otp4.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    // Your action on done

                    if(edt_otp1.getText().length()==0 && edt_otp2.getText().length()==0 &&
                            edt_otp3.getText().length()==0 && edt_otp4.getText().length()==0){
                        Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
                    }else if(edt_otp1.getText().length()==0){
                        Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
                    }else if(edt_otp2.getText().length()==0){
                        Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
                    }else if(edt_otp3.getText().length()==0){
                        Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
                    }else if(edt_otp4.getText().length()==0){
                        Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
                    }else{
                        validateFields();
                    }

                    return true;
                }
                return false;
            }
        });*/



        sb=new StringBuilder();

        edt_otp1.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if(sb.length()==0&edt_otp1.length()==1)
                {
                    sb.append(s);
                    edt_otp1.clearFocus();
                    edt_otp2.requestFocus();
                    edt_otp2.setCursorVisible(true);

                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

                if(sb.length()==1)
                {

                    sb.deleteCharAt(0);

                }

            }

            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {

                    edt_otp1.requestFocus();
                }

            }
        });


        edt_otp2.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if(sb.length()==0&edt_otp2.length()==1)
                {
                    sb.append(s);
                    edt_otp2.clearFocus();
                    edt_otp3.requestFocus();
                    edt_otp3.setCursorVisible(true);

                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

                if(sb.length()==1)
                {

                    sb.deleteCharAt(0);

                }

            }

            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {

                    edt_otp2.requestFocus();
                }

            }
        });

        edt_otp3.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if(sb.length()==0&edt_otp2.length()==1)
                {
                    sb.append(s);
                    edt_otp3.clearFocus();
                    edt_otp4.requestFocus();
                    edt_otp4.setCursorVisible(true);

                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

                if(sb.length()==1)
                {
                    sb.deleteCharAt(0);
                }

            }

            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {

                    edt_otp3.requestFocus();
                }

            }
        });


        edt_otp4.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

                if(sb.length()==1)
                {

                    sb.deleteCharAt(0);

                }

            }

            public void afterTextChanged(Editable s) {
               /* if(sb.length()==0)
                {

                    edt_otp1.requestFocus();
                }*/
                Utility.hideSoftKeyboard(VerifyOTPActivity.this);
                submitFloatingActionButton.setVisibility(View.VISIBLE);

            }
        });

    }

    /**
     * initialize components
     */
    private void init() {
        edt_otp1 = (EditText) findViewById(R.id.editTextOtp1);
        edt_otp2 = (EditText) findViewById(R.id.editTextOtp2);
        edt_otp3 = (EditText) findViewById(R.id.editTextOtp3);
        edt_otp4 = (EditText) findViewById(R.id.editTextOtp4);
        btnResendOTP = (Button) findViewById(R.id.buttonResendOTP);
        roundedImage = (ImageView) findViewById(R.id.imageView3);
        txtCountDownTimer = (TextView) findViewById(R.id.textViewCountDownTimer);
        submitFloatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        btnResendOTP.setEnabled(false);
        btnResendOTP.setTextColor(getResources().getColor(R.color.gray));
    }

    /**
     * add click listener
     */

    private void addListener() {
        btnResendOTP.setOnClickListener(this);
    //    edt_otp4.setImeOptions(EditorInfo.IME_ACTION_DONE);
        submitFloatingActionButton.setOnClickListener(this);
    }

    /**
     *
     */

    private void keyboardDone() {
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonResendOTP:
                Toast.makeText(getApplicationContext(),"OTP send to registered mobile number",Toast.LENGTH_SHORT).show();
                if (!timerHasStarted) {
                    countDownTimer.start();
                    timerHasStarted = true;
                } else {
                    countDownTimer.cancel();
                    timerHasStarted = false;
                }
                break;

            case R.id.floatingActionButton:
                if(edt_otp1.getText().length()==0 && edt_otp2.getText().length()==0 &&
                        edt_otp3.getText().length()==0 && edt_otp4.getText().length()==0){
                    Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
                }else if(edt_otp1.getText().length()==0){
                    Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
                }else if(edt_otp2.getText().length()==0){
                    Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
                }else if(edt_otp3.getText().length()==0){
                    Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
                }else if(edt_otp4.getText().length()==0){
                    Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
                }else{
                    validateFields();
                }
                break;
            default:
                break;
        }
    }

    private void validateFields() {
        final String otp1 = edt_otp1.getText().toString().trim();
        final String otp2 = edt_otp2.getText().toString().trim();
        final String otp3 = edt_otp3.getText().toString().trim();
        final String otp4 = edt_otp4.getText().toString().trim();

        if(otp1.equals("")){
            Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
        }else if(otp2.equals("")){
            Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
        }else if(otp3.equals("")){
            Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
        }else if(otp4.equals("")){
            Toast.makeText(getApplicationContext(),"Please enter 4 digit OTP code",Toast.LENGTH_SHORT).show();
        }else{

            countDownTimer.cancel();
            timerHasStarted = false;

            Toast.makeText(getApplicationContext(),"Product added in customer premium tab",Toast.LENGTH_SHORT).show();
         // showCongratsDialog();
            /*Intent intentProfileReg = new Intent(VerifyOTPActivity.this,RegistrationActivity.class);
            startActivity(intentProfileReg);*/
        }
    }

   /* private void showCongratsDialog() {
        // Create custom dialog object
        dialog = new Dialog(VerifyOTPActivity.this);

        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
        dialog.setContentView(R.layout.custom_dialog);
        // this will remove rectangle frame around the Dialog
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
  //      dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        TextView txtHeader = (TextView) dialog.findViewById(R.id.textViewHeader);
        TextView txtContent = (TextView) dialog.findViewById(R.id.textViewContent);
        Button btnOk = (Button) dialog.findViewById(R.id.buttonLetsBegin);

        txtHeader.setText(getResources().getString(R.string.congrats));
        txtContent.setText(getResources().getString(R.string.account_creation_msg));
        btnOk.setText(getResources().getString(R.string.btn_lets_begin));

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intentProfileReg = new Intent(VerifyOTPActivity.this,RegistrationActivity.class);
                startActivity(intentProfileReg);
            }
        });
    }*/

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            txtCountDownTimer.setText("0.0");
            btnResendOTP.setEnabled(true);
            btnResendOTP.setTextColor(getResources().getColor(R.color.gradient_end_color));
        }

        @Override
        public void onTick(long millisUntilFinished) {
            txtCountDownTimer.setText("0."+ millisUntilFinished / 1000);
         }
    }

}
