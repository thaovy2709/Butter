package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FragmentButterIDChooseDip extends AppCompatActivity {

    LinearLayout llChocoDip, llVaniDip;
    ImageView imvCookie;
    Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_butter_idchoose_dip);
        getSupportActionBar().hide();

        linkViews();
        addEvents();
    }

    private void addEvents() {
        llChocoDip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llChocoDip.setBackgroundResource(R.drawable.choosenframe);
                llVaniDip.setBackground(null);
                imvCookie.setImageResource(R.drawable.dipchoco);
            }
        });
        llVaniDip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llVaniDip.setBackgroundResource(R.drawable.choosenframe);
                llChocoDip.setBackground(null);
                imvCookie.setImageResource(R.drawable.dipvani);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDChooseDip.this,FragmentButterIDChooseCreme.class);
                startActivity(intent);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDChooseDip.this,FragmentButterIDChooseCheese.class);
                startActivity(intent);
            }
        });
    }

    private void linkViews() {
        llChocoDip = findViewById(R.id.ll_ChocoDip);
        llVaniDip = findViewById(R.id.ll_VaniDip);
        imvCookie = findViewById(R.id.imv_Cookie);
        btnBack = findViewById(R.id.btn_back);
        btnNext = findViewById(R.id.btn_Next);
    }
}