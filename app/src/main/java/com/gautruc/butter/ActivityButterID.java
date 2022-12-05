package com.gautruc.butter;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;

public class ActivityButterID extends AppCompatActivity {

    Button btnNext;
    LinearLayout llSizeLarge, llSizeMini;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_id);
        getSupportActionBar().hide();

        linkView();
        addEvents();

    }

    private void addEvents() {

        llSizeLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llSizeLarge.setBackgroundResource(R.drawable.choosenframe);
                llSizeMini.setBackground(null);
                btnNext.setBackgroundColor(ActivityButterID.this.getResources().getColor(R.color.secondary_4));
            }
        });

        llSizeMini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llSizeMini.setBackgroundResource(R.drawable.choosenframe);
                llSizeLarge.setBackground(null);
                btnNext.setBackgroundColor(ActivityButterID.this.getResources().getColor(R.color.secondary_4));
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityButterID.this,FragmentButterIDChooseCreme.class);
                startActivity(intent);
            }
        });

    }

    private void linkView() {
        llSizeLarge = findViewById(R.id.ll_SizeLarge);
        llSizeMini = findViewById(R.id.ll_SizeMini);
        btnNext = findViewById(R.id.btn_Next);
    }
}