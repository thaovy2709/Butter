package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FragmentButterIDChoosePackage extends AppCompatActivity {
    
    LinearLayout llBag, llBox1c, llBoxgiay6c, llBoxkieng6c;
    ImageView imvBag, imvBox1c, imvBoxgiay6c, imvBoxkieng6c, imvCookie;
    Button btnConfirmOrder, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_butter_idchoose_package);


        ImageView imvMain = (ImageView) findViewById(R.id.imv_Main);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            int step4 = bundle.getInt("step4");
            imvMain.setImageResource(step4);
        }
        
        linkViews();
        addEvents();
    }

    private void addEvents() {

        llBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llBag.setBackgroundResource(R.drawable.choosenframe);
                llBox1c.setBackground(null);
                llBoxgiay6c.setBackground(null);
                llBoxkieng6c.setBackground(null);
                imvCookie.setImageResource(R.drawable.bag1);

                btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChoosePackage.this,FragmentButterIDConfirmOrder.class);
                        intent.putExtra("step5", R.drawable.bag1);
                        startActivity(intent);
                    }
                });
            }
        });

        llBox1c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llBox1c.setBackgroundResource(R.drawable.choosenframe);
                llBag.setBackground(null);
                llBoxgiay6c.setBackground(null);
                llBoxkieng6c.setBackground(null);
                imvCookie.setImageResource(R.drawable.box1);

                btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChoosePackage.this,FragmentButterIDConfirmOrder.class);
                        intent.putExtra("step5", R.drawable.box1);
                        startActivity(intent);
                    }
                });
            }
        });

        llBoxgiay6c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llBoxgiay6c.setBackgroundResource(R.drawable.choosenframe);
                llBag.setBackground(null);
                llBox1c.setBackground(null);
                llBoxkieng6c.setBackground(null);
                imvCookie.setImageResource(R.drawable.boxgiay6);

                btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChoosePackage.this,FragmentButterIDConfirmOrder.class);
                        intent.putExtra("step5", R.drawable.boxgiay6);
                        startActivity(intent);
                    }
                });
            }
        });

        llBoxkieng6c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llBoxkieng6c.setBackgroundResource(R.drawable.choosenframe);
                llBag.setBackground(null);
                llBox1c.setBackground(null);
                llBoxgiay6c.setBackground(null);
                imvCookie.setImageResource(R.drawable.boxkinh6);

                btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChoosePackage.this,FragmentButterIDConfirmOrder.class);
                        intent.putExtra("step5", R.drawable.boxkinh6);
                        startActivity(intent);
                    }
                });
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDChoosePackage.this,FragmentButterIDChooseCheese.class);
                startActivity(intent);
            }
        });

    }

    private void linkViews() {
        llBag = findViewById(R.id.ll_bag1c);
        llBox1c = findViewById(R.id.ll_box1c);
        llBoxgiay6c = findViewById(R.id.ll_boxgiay6c);
        llBoxkieng6c = findViewById(R.id.ll_boxkieng6c);
        imvBag = findViewById(R.id.imv_Bag);
        imvBox1c = findViewById(R.id.imv_Box1);
        imvBoxgiay6c = findViewById(R.id.imv_PaperBox6C);
        imvBoxkieng6c = findViewById(R.id.imv_Box6c);
        imvCookie = findViewById(R.id.imv_Main);
        btnBack = findViewById(R.id.btn_back);
        btnConfirmOrder = findViewById(R.id.btn_ConfirmOrder);
    }
}