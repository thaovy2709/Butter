package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.gautruc.butter.databinding.ActivityFragmentButterIdconfirmOrderBinding;

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
        addEvents();
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