package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ButterIdPackage extends AppCompatActivity {

    ImageView imv_Main, imv_Bag, imv_Box1, imv_PaperBox6C, imv_Box6c;
    Button btn_next, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_id_package);

        ImageView imvMain = (ImageView) findViewById(R.id.imv_Main);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            int step4 = bundle.getInt("step4");
            imvMain.setImageResource(step4);
        }

        linkView();
        addEvents();
    }


    private void addEvents() {

        imv_Bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imv_Bag.setBackgroundResource(R.drawable.chosenframe);
                imv_Box6c.setBackground(null);
                imv_Box1.setBackground(null);
                imv_PaperBox6C.setBackground(null);

                imv_Main.setImageResource(R.drawable.bag1);


            }
        });

        imv_Box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imv_Box1.setBackgroundResource(R.drawable.chosenframe);
                imv_Bag.setBackground(null);
                imv_Box6c.setBackground(null);
                imv_PaperBox6C.setBackground(null);

                imv_Main.setImageResource(R.drawable.box1);
            }
        });

        imv_Box6c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imv_Box6c.setBackgroundResource(R.drawable.chosenframe);
                imv_Bag.setBackground(null);
                imv_Box1.setBackground(null);
                imv_PaperBox6C.setBackground(null);

                imv_Main.setImageResource(R.drawable.boxkinh6);
            }
        });

        imv_PaperBox6C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imv_PaperBox6C.setBackgroundResource(R.drawable.chosenframe);
                imv_Bag.setBackground(null);
                imv_Box1.setBackground(null);
                imv_Box6c.setBackground(null);

                imv_Main.setImageResource(R.drawable.boxgiay6);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ButterIdPackage.this, ButterIdCheese.class);
                startActivity(intent);

            }
        });


    }

    private void linkView() {
        imv_Main = findViewById(R.id.imv_Main);
        imv_Bag = findViewById(R.id.imv_Bag);
        imv_Box1 = findViewById(R.id.imv_Box1);
        imv_PaperBox6C = findViewById(R.id.imv_PaperBox6C);
        imv_Box6c = findViewById(R.id.imv_Box6c);
        btn_next = findViewById(R.id.btn_next);
        btn_back = findViewById(R.id.btn_back);
    }
}