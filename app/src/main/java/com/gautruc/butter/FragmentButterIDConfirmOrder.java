package com.gautruc.butter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.gautruc.butter.databinding.ActivityFragmentButterIdconfirmOrderBinding;
import com.google.android.material.navigation.NavigationBarView;

public class FragmentButterIDConfirmOrder extends AppCompatActivity {

    Button btnOrderSuccess;

    ActivityFragmentButterIdconfirmOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_butter_idconfirm_order);

        binding = ActivityFragmentButterIdconfirmOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView imvPackage = (ImageView) findViewById(R.id.imv_Package);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            int step5 = bundle.getInt("step5");
            imvPackage.setImageResource(step5);
        }

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
        btnOrderSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDConfirmOrder.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });
        binding.imvNotification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDConfirmOrder.this, NotificationList.class);
                startActivity(intent);
            }
        });
        binding.imvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDConfirmOrder.this, FragmentSearchScreen.class);
                startActivity(intent);
            }
        });
        binding.imvWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDConfirmOrder.this, FavoriteDishesListScreen.class);
                startActivity(intent);
            }
        });
        binding.imvProfile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDConfirmOrder.this, ProfileScreenActivity.class);
                startActivity(intent);
            }
        });
    }

    private void linkViews() {
        btnOrderSuccess = findViewById(R.id.btn_OrderSuccess);
    }
}