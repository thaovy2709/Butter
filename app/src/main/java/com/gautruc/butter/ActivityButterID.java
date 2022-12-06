package com.gautruc.butter;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;

import com.gautruc.butter.databinding.ActivityButterIdBinding;
import com.google.android.material.navigation.NavigationBarView;

public class ActivityButterID extends AppCompatActivity {

    Button btnNext;
    LinearLayout llSizeLarge, llSizeMini;

    ActivityButterIdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_butter_id);

        binding = ActivityButterIdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_butter_id);

        linkView();
        manipulateMenu();
        addEvents();

    }

    private void manipulateMenu() {
        binding.bottomNavigation.setSelectedItemId(R.id.bottom_navigation);
        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_ButterId:
                        return true;
                    case R.id.nav_Homepage:
                        startActivity(new Intent(getApplicationContext(), HomepageActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_Menu:
                        startActivity(new Intent(getApplicationContext(), MenuScreenActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_Promotion:
                        startActivity(new Intent(getApplicationContext(), PromotionScreenActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_Order:
                        startActivity(new Intent(getApplicationContext(), OngoingScreenActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                }

                return false;
            }
        });
    }

    private void addEvents() {

        llSizeLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llSizeLarge.setBackgroundResource(R.drawable.choosenframe);
                llSizeMini.setBackground(null);
                btnNext.setBackgroundColor(ActivityButterID.this.getResources().getColor(R.color.secondary_4));

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ActivityButterID.this,FragmentButterIDChooseCreme.class);
                        startActivity(intent);
                    }
                });
            }
        });

        llSizeMini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llSizeMini.setBackgroundResource(R.drawable.choosenframe);
                llSizeLarge.setBackground(null);
                btnNext.setBackgroundColor(ActivityButterID.this.getResources().getColor(R.color.secondary_4));

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ActivityButterID.this,FragmentButterIDChooseCreme.class);
                        startActivity(intent);
                    }
                });
            }
        });


    }

    private void linkView() {
        llSizeLarge = findViewById(R.id.ll_SizeLarge);
        llSizeMini = findViewById(R.id.ll_SizeMini);
        btnNext = findViewById(R.id.btn_Next);
    }
}