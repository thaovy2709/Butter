package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FragmentButterIDChooseCreme extends AppCompatActivity {

    LinearLayout llChocolate, llSprinkles, llVani, llMatcha, llStrawberry;
    Button btnBack, btnNext;
    ImageView imvCookie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_butter_idchoose_creme);

        linkViews();
        addEvents();
    }



    private void addEvents() {
        llChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llChocolate.setBackgroundResource(R.drawable.choosenframe);
                llSprinkles.setBackground(null);
                llVani.setBackground(null);
                llMatcha.setBackground(null);
                llStrawberry.setBackground(null);
                imvCookie.setImageResource(R.drawable.chocolate);

                btnNext.setBackgroundColor(FragmentButterIDChooseCreme.this.getResources().getColor(R.color.secondary_4));

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChooseCreme.this,FragmentButterIDChooseDip.class);
                        startActivity(intent);
                    }
                });

            }
        });
        llVani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llVani.setBackgroundResource(R.drawable.choosenframe);
                llSprinkles.setBackground(null);
                llStrawberry.setBackground(null);
                llMatcha.setBackground(null);
                llChocolate.setBackground(null);
                imvCookie.setImageResource(R.drawable.vanilla);

                btnNext.setBackgroundColor(FragmentButterIDChooseCreme.this.getResources().getColor(R.color.secondary_4));

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChooseCreme.this,FragmentButterIDChooseDip.class);
                        startActivity(intent);
                    }
                });
            }
        });
        llMatcha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llMatcha.setBackgroundResource(R.drawable.choosenframe);
                llSprinkles.setBackground(null);
                llStrawberry.setBackground(null);
                llVani.setBackground(null);
                llChocolate.setBackground(null);
                imvCookie.setImageResource(R.drawable.matcha);

                btnNext.setBackgroundColor(FragmentButterIDChooseCreme.this.getResources().getColor(R.color.secondary_4));

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChooseCreme.this,FragmentButterIDChooseDip.class);
                        startActivity(intent);
                    }
                });
            }
        });
        llStrawberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llStrawberry.setBackgroundResource(R.drawable.choosenframe);
                llSprinkles.setBackground(null);
                llVani.setBackground(null);
                llMatcha.setBackground(null);
                llChocolate.setBackground(null);
                imvCookie.setImageResource(R.drawable.strawberry);

                btnNext.setBackgroundColor(FragmentButterIDChooseCreme.this.getResources().getColor(R.color.secondary_4));

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChooseCreme.this,FragmentButterIDChooseDip.class);
                        startActivity(intent);
                    }
                });
            }
        });
        llSprinkles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llSprinkles.setBackgroundResource(R.drawable.choosenframe);
                llStrawberry.setBackground(null);
                llVani.setBackground(null);
                llMatcha.setBackground(null);
                llChocolate.setBackground(null);
                imvCookie.setImageResource(R.drawable.sprinkles);

                btnNext.setBackgroundColor(FragmentButterIDChooseCreme.this.getResources().getColor(R.color.secondary_4));

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChooseCreme.this,FragmentButterIDChooseDip.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDChooseCreme.this,ActivityButterID.class);
                startActivity(intent);
            }
        });
    }

    private void linkViews() {
        llChocolate = findViewById(R.id.ll_Chocolate);
        llSprinkles = findViewById(R.id.ll_Sprinkles);
        llVani = findViewById(R.id.ll_Vani);
        llMatcha = findViewById(R.id.ll_Matcha);
        llStrawberry = findViewById(R.id.ll_Strawberry);
        btnBack = findViewById(R.id.btn_back);
        btnNext = findViewById(R.id.btn_Next);
        imvCookie = findViewById(R.id.imv_Cookie);
    }
}