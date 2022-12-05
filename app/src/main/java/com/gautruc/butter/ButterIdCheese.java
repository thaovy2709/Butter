package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ButterIdCheese extends AppCompatActivity {

    ImageView imv_AddCheese, imv_NoCheese, imv_Main;
    Button btn_next, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_id_cheese);

        linkView();
        addEvents();
    }

    private void addEvents() {
        imv_AddCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imv_AddCheese.setBackgroundResource(R.drawable.chosenframe);
                imv_NoCheese.setBackground(null);
                imv_Main.setImageResource(R.drawable.chococheese);

                btn_next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ButterIdCheese.this,ButterIdPackage.class);
                        intent.putExtra("step4",R.drawable.chococheese);
                        startActivity(intent);
                    }
                });
            }
        });


        imv_NoCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imv_NoCheese.setBackgroundResource(R.drawable.chosenframe);
                imv_AddCheese.setBackground(null);
                imv_Main.setImageResource(R.drawable.dipchoco);

                btn_next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                Intent intent = new Intent(ButterIdCheese.this, ButterIdPackage.class);
//                startActivity(intent);

                        Intent intent = new Intent(ButterIdCheese.this,ButterIdPackage.class);
                        intent.putExtra("step4",R.drawable.dipchoco);
                        startActivity(intent);
                    }
                });
            }
        });

//        btn_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(ButterIdCheese.this, ButterIdPackage.class);
////                startActivity(intent);
//
//                Intent intent = new Intent(ButterIdCheese.this,ButterIdPackage.class);
//                intent.putExtra("chococheese",R.drawable.chococheese);
//                startActivity(intent);
//            }
//        });
    }

    private void linkView() {

        imv_AddCheese = findViewById(R.id.imv_AddCheese);
        imv_NoCheese = findViewById(R.id.imv_NoCheese);
        imv_Main = findViewById(R.id.imv_Main);
        btn_next = findViewById(R.id.btn_next);
        btn_back = findViewById(R.id.btn_back);



    }
}