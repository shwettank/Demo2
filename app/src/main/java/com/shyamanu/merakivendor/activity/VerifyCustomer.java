package com.shyamanu.merakivendor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shyamanu.merakivendor.R;

/**
 * Created by shwettank.ramteke on 4/6/2018.
 */

public class VerifyCustomer extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout linearLayoutBg;
    private TextView txtCardNumber;
    private EditText edtMerakiCardNo;
    private Button btnGenerateOTP;
    private Button btnSkip;
    //   private Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_customer_card_registration);

        // initialize content
        init();

        // add listener
        addListener();

        // text watcher for entering card number in proper format
        textWatcherListener();
    }

    /**
     * Initialize content
     */
    private void init() {
        linearLayoutBg = (LinearLayout) findViewById(R.id.mainLayout);
        txtCardNumber = (TextView) findViewById(R.id.textViewEnterCode);
        edtMerakiCardNo = (EditText) findViewById(R.id.cardNumberEditText);
        btnGenerateOTP = (Button) findViewById(R.id.buttonGenerateOTP);
    }

    /**
     * ass click listener
     */
    private void addListener() {
        btnGenerateOTP.setOnClickListener(this);
    }

    private void textWatcherListener() {
        edtMerakiCardNo.addTextChangedListener(new TextWatcher() {

            private static final int TOTAL_SYMBOLS = 19; // size of pattern 0000-0000-0000-0000
            private static final int TOTAL_DIGITS = 16; // max numbers of digits in pattern: 0000 x 4
            private static final int DIVIDER_MODULO = 5; // means divider position is every 5th symbol beginning with 1
            private static final int DIVIDER_POSITION = DIVIDER_MODULO - 1; // means divider position is every 4th symbol beginning with 0
            private static final char DIVIDER = '-';

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // noop
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtCardNumber.setText(s);
                // noop
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!isInputCorrect(s, TOTAL_SYMBOLS, DIVIDER_MODULO, DIVIDER)) {
                    s.replace(0, s.length(), buildCorrectString(getDigitArray(s, TOTAL_DIGITS), DIVIDER_POSITION, DIVIDER));
                }
            }

            private boolean isInputCorrect(Editable s, int totalSymbols, int dividerModulo, char divider) {
                boolean isCorrect = s.length() <= totalSymbols; // check size of entered string
                for (int i = 0; i < s.length(); i++) { // check that every element is right
                    if (i > 0 && (i + 1) % dividerModulo == 0) {
                        isCorrect &= divider == s.charAt(i);
                    } else {
                        isCorrect &= Character.isDigit(s.charAt(i));
                    }
                }
                return isCorrect;
            }

            private String buildCorrectString(char[] digits, int dividerPosition, char divider) {
                final StringBuilder formatted = new StringBuilder();

                for (int i = 0; i < digits.length; i++) {
                    if (digits[i] != 0) {
                        formatted.append(digits[i]);
                        if ((i > 0) && (i < (digits.length - 1)) && (((i + 1) % dividerPosition) == 0)) {
                            formatted.append(divider);
                        }
                    }
                }

                return formatted.toString();
            }

            private char[] getDigitArray(final Editable s, final int size) {
                char[] digits = new char[size];
                int index = 0;
                for (int i = 0; i < s.length() && index < size; i++) {
                    char current = s.charAt(i);
                    if (Character.isDigit(current)) {
                        digits[index] = current;
                        index++;
                    }
                }
                return digits;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.buttonGenerateOTP:
                Intent verifyOTPIntent = new Intent(VerifyCustomer.this,VerifyOTPActivity.class);
                startActivity(verifyOTPIntent);
                break;

            default:
                break;

        }
    }
}
