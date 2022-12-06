package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FragmentButterIDChooseCheeseVanilla extends AppCompatActivity {

    ImageView imv_Cookie;
    LinearLayout linearAddCheese, linearNoCheese;
    Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_butter_idchoose_cheese_vanilla);


        ImageView imvMainDip = (ImageView) findViewById(R.id.imv_Cookie);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            int step3 = bundle.getInt("step3");
            imvMainDip.setImageResource(step3);

        }

        linkView();
        addEvents();
    }

    private void addEvents() {

        linearAddCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearAddCheese.setBackgroundResource(R.drawable.choosenframe);
                linearNoCheese.setBackground(null);
                imv_Cookie.setImageResource(R.drawable.vanicheese2);

                btnNext.setBackgroundColor(FragmentButterIDChooseCheeseVanilla.this.getResources().getColor(R.color.secondary_4));

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChooseCheeseVanilla.this, FragmentButterIDChoosePackageVanilla.class);
                        intent.putExtra("step4", R.drawable.vanicheese2);
                        startActivity(intent);
                    }
                });
            }
        });

        linearNoCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearNoCheese.setBackgroundResource(R.drawable.choosenframe);
                linearAddCheese.setBackground(null);
                imv_Cookie.setImageResource(R.drawable.dipvani);

                btnNext.setBackgroundColor(FragmentButterIDChooseCheeseVanilla.this.getResources().getColor(R.color.secondary_4));

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChooseCheeseVanilla.this, FragmentButterIDChoosePackageVanilla.class);
                        intent.putExtra("step4", R.drawable.dipvani);
                        startActivity(intent);
                    }
                });
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDChooseCheeseVanilla.this,FragmentButterIDChooseDip.class);
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