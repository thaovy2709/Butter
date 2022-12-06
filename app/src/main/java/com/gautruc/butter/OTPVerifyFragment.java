package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gautruc.butter.HomepageActivity;
import com.gautruc.butter.R;


public class OTPVerifyFragment extends AppCompatActivity {

    TextView txtMobile, txtReSendOTP;
    EditText edtCode1, edtCode2, edtCode3, edtCode4, edtCode5, edtCode6;
    Button btnVerifyOTP;
    ImageView imvThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_otpverify);

        linkViews();
        otpInputs();
        addEvents();

        txtMobile.setText(String.format("%s", getIntent().getStringExtra("mobile")));

    }
    private void linkViews(){
        txtMobile = findViewById(R.id.txt_Mobile);

        edtCode1 = findViewById(R.id.edt_Code1);
        edtCode2 = findViewById(R.id.edt_Code2);
        edtCode3 = findViewById(R.id.edt_Code3);
        edtCode4 = findViewById(R.id.edt_Code4);
        edtCode5 = findViewById(R.id.edt_Code5);
        edtCode6 = findViewById(R.id.edt_Code6);

        btnVerifyOTP = findViewById(R.id.btn_confirmOTP);

        txtReSendOTP = findViewById(R.id.txt_resendOTP);

        imvThoat = findViewById(R.id.imv_thoat);

    }

    private void otpInputs(){
        edtCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    edtCode2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    edtCode3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    edtCode4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    edtCode5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtCode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    edtCode6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void addEvents() {
        btnVerifyOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtCode1.getText().toString().trim().isEmpty()
                        && edtCode2.getText().toString().trim().isEmpty()
                        && edtCode3.getText().toString().trim().isEmpty()
                        && edtCode4.getText().toString().trim().isEmpty()
                        && edtCode5.getText().toString().trim().isEmpty()
                        && edtCode6.getText().toString().trim().isEmpty()) {
                    Toast.makeText(OTPVerifyFragment.this, "OTP Không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(OTPVerifyFragment.this, "Xác nhận OTP thành công!", Toast.LENGTH_SHORT).show();
//                    return;

                    Intent intent = new Intent(OTPVerifyFragment.this, HomepageActivity.class);
                    startActivity(intent);
                }
            }
        });

        txtReSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OTPVerifyFragment.this, "OTP sẽ được gửi đến trong vài giây nữa. Vui lòng kiểm tra tin nhắn", Toast.LENGTH_SHORT).show();
            }
        });

        imvThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}