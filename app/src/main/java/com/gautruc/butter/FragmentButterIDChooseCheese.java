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

import com.gautruc.butter.databinding.ActivityFragmentButterIdchooseCheeseBinding;
import com.google.android.material.navigation.NavigationBarView;

public class FragmentButterIDChooseCheese extends AppCompatActivity {

    ImageView imv_Cookie;
    LinearLayout linearAddCheese, linearNoCheese;
    Button btnBack, btnNext;

    ActivityFragmentButterIdchooseCheeseBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_butter_idchoose_cheese);

        binding = ActivityFragmentButterIdchooseCheeseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView imvMainDip = (ImageView) findViewById(R.id.imv_Cookie);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            int step3 = bundle.getInt("step3");
            imvMainDip.setImageResource(step3);

        }

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
        linearAddCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearAddCheese.setBackgroundResource(R.drawable.choosenframe);
                linearNoCheese.setBackground(null);
                imv_Cookie.setImageResource(R.drawable.chococheese);

                btnNext.setBackgroundColor(FragmentButterIDChooseCheese.this.getResources().getColor(R.color.secondary_4));

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChooseCheese.this, FragmentButterIDChoosePackage.class);
                        intent.putExtra("step4", R.drawable.chococheese);
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
                imv_Cookie.setImageResource(R.drawable.dipchoco);

                btnNext.setBackgroundColor(FragmentButterIDChooseCheese.this.getResources().getColor(R.color.secondary_4));

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChooseCheese.this, FragmentButterIDChoosePackage.class);
                        intent.putExtra("step4", R.drawable.dipchoco);
                        startActivity(intent);
                    }
                });
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDChooseCheese.this,FragmentButterIDChooseDip.class);
                startActivity(intent);
            }
        });
        binding.imvNotification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChooseCheese.this, NotificationList.class);
                startActivity(intent);
            }
        });
        binding.imvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChooseCheese.this, FragmentSearchScreen.class);
                startActivity(intent);
            }
        });
        binding.imvWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChooseCheese.this, FavoriteDishesListScreen.class);
                startActivity(intent);
            }
        });
        binding.imvProfile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChooseCheese.this, ProfileScreenActivity.class);
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