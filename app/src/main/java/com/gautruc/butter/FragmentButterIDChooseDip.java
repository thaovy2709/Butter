package com.gautruc.butter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gautruc.butter.databinding.ActivityFragmentButterIdchooseDipBinding;
import com.google.android.material.navigation.NavigationBarView;

public class FragmentButterIDChooseDip extends AppCompatActivity {

    LinearLayout llChocoDip, llVaniDip;
    ImageView imvCookie;
    Button btnBack, btnNext;

    ActivityFragmentButterIdchooseDipBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_butter_idchoose_dip);

        binding = ActivityFragmentButterIdchooseDipBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        linkViews();
        manipulateMenu();
        addEvents();
    }

    private void manipulateMenu() {
        binding.bottomNavigation.setSelectedItemId(R.id.nav_ButterId);
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
        llChocoDip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llChocoDip.setBackgroundResource(R.drawable.choosenframe);
                llVaniDip.setBackground(null);
                imvCookie.setImageResource(R.drawable.dipchoco);

                btnNext.setBackgroundResource(R.drawable.item_checkouttag);

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChooseDip.this, FragmentButterIDChooseCheese.class);
                        intent.putExtra("step3", R.drawable.dipchoco);
                        startActivity(intent);
                    }
                });

            }
        });
        llVaniDip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llVaniDip.setBackgroundResource(R.drawable.choosenframe);
                llChocoDip.setBackground(null);
                imvCookie.setImageResource(R.drawable.dipvani);

                btnNext.setBackgroundResource(R.drawable.item_checkouttag);

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChooseDip.this, FragmentButterIDChooseCheeseVanilla.class);
                        intent.putExtra("step3b", R.drawable.dipvani);
                        startActivity(intent);
                    }
                });

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDChooseDip.this,FragmentButterIDChooseCreme.class);
                startActivity(intent);
            }
        });
        binding.imvNotification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChooseDip.this, NotificationList.class);
                startActivity(intent);
            }
        });
        binding.imvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChooseDip.this, FragmentSearchScreen.class);
                startActivity(intent);
            }
        });
        binding.imvWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChooseDip.this, FavoriteDishesListScreen.class);
                startActivity(intent);
            }
        });
        binding.imvProfile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChooseDip.this, ProfileScreenActivity.class);
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