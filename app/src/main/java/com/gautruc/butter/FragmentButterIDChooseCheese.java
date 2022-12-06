package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FragmentButterIDChooseCheese extends AppCompatActivity {

    ImageView imv_Cookie;
    LinearLayout linearAddCheese, linearNoCheese;
    Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_butter_idchoose_cheese);


        linkView();
        addEvents();

    }

    private void addEvents() {
        linearAddCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearAddCheese.setBackgroundResource(R.drawable.choosenframe);
                linearNoCheese.setBackground(null);
                imv_Cookie.setImageResource(R.drawable.chococheese);
            }
        });

        linearNoCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearNoCheese.setBackgroundResource(R.drawable.choosenframe);
                linearAddCheese.setBackground(null);
                imv_Cookie.setImageResource(R.drawable.dipchoco);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDChooseCheese.this,FragmentButterIDChooseDip.class);
                startActivity(intent);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDChooseCheese.this,FragmentButterIDChoosePackage.class);
                startActivity(intent);
            }
        });


    }

    private void linkView() {
        linearAddCheese = findViewById(R.id.ll_AddCheese);
        linearNoCheese = findViewById(R.id.ll_NoCheese);
        imv_Cookie = findViewById(R.id.imv_Cookie);
        btnBack = findViewById(R.id.btn_back);
        btnNext = findViewById(R.id.btn_Next);
    }

}