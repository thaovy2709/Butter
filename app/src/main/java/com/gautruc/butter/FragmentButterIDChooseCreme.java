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

import com.gautruc.butter.databinding.ActivityFragmentButterIdchooseCremeBinding;
import com.google.android.material.navigation.NavigationBarView;

public class FragmentButterIDChooseCreme extends AppCompatActivity {

    LinearLayout llChocolate, llSprinkles, llVani, llMatcha, llStrawberry;
    Button btnBack, btnNext;
    ImageView imvCookie;

    ActivityFragmentButterIdchooseCremeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_butter_idchoose_creme);

        binding = ActivityFragmentButterIdchooseCremeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        linkViews();
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
        binding.imvNotification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChooseCreme.this, NotificationList.class);
                startActivity(intent);
            }
        });
        binding.imvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChooseCreme.this, FragmentSearchScreen.class);
                startActivity(intent);
            }
        });
        binding.imvWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChooseCreme.this, FavoriteDishesListScreen.class);
                startActivity(intent);
            }
        });
        binding.imvProfile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChooseCreme.this, ProfileScreenActivity.class);
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