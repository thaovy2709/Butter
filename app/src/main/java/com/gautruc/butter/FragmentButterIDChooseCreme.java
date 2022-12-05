package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FragmentButterIDChooseCreme extends AppCompatActivity {

    LinearLayout llChocolate, llSprinkles;
    Button btnBack, btnNext;
    ImageView imvCookie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_butter_idchoose_creme);
        getSupportActionBar().hide();

        linkViews();
        addEvents();
    }

    private void addEvents() {
        llChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llChocolate.setBackgroundResource(R.drawable.choosenframe);
                llSprinkles.setBackground(null);
                imvCookie.setImageResource(R.drawable.chocolate);
            }
        });
        llSprinkles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llSprinkles.setBackgroundResource(R.drawable.choosenframe);
                llChocolate.setBackground(null);
                imvCookie.setImageResource(R.drawable.sprinkles);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDChooseCreme.this,ActivityButterID.class);
                startActivity(intent);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDChooseCreme.this,FragmentButterIDChooseDip.class);
                startActivity(intent);
            }
        });
    }

    private void linkViews() {
        llChocolate = findViewById(R.id.ll_Chocolate);
        llSprinkles = findViewById(R.id.ll_Sprinkles);
        btnBack = findViewById(R.id.btn_back);
        btnNext = findViewById(R.id.btn_Next);
        imvCookie = findViewById(R.id.imv_Cookie);
    }
}