package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gautruc.butter.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding activityLoginBinding;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);


        activityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBinding.getRoot());


        activityLoginBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activityLoginBinding.edtPhonenumber.getText().toString().trim().isEmpty())
                {
                   openErrorNotifyDialog();
                } else
                {
                    Intent intent = new Intent(LoginActivity.this, OTPVerifyFragment.class);
                    intent.putExtra("mobile", activityLoginBinding.edtPhonenumber.getText().toString());
                    startActivity(intent);
                }

            }
        });
        activityLoginBinding.btnLoginFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://facebook.com";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        activityLoginBinding.btnLoginGG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://accounts.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        activityLoginBinding.txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ClientHomepageActivity.class);
                startActivity(intent);
            }
        });

    }


    private void openErrorNotifyDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.fragment_errornotify_dialog);
        dialog.setCanceledOnTouchOutside(false);
        Button btnnhaplai = dialog.findViewById(R.id.btn_nhaplai);
        btnnhaplai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                dialog.dismiss();
                Toast.makeText(LoginActivity.this,"Vui l??ng nh???p l???i s??? ??i???n tho???i", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}