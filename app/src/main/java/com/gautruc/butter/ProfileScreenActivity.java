package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.gautruc.butter.databinding.ActivityProfileScreenBinding;

public class ProfileScreenActivity extends AppCompatActivity {

    ActivityProfileScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_profile_screen);
        binding = ActivityProfileScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.txtPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileScreenActivity.this, FragmentUserPolicy.class);
                startActivity(intent);
            }
        });

        //Bấm "Đánh giá Butter" -> Hiện ra app trên CH Play
        binding.txtRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //getPackageName -> tự random name, để khỏi trùng
                    Uri uriRate = Uri.parse("market://details?id=" + getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uriRate);
                    startActivity(goToMarket);
                    //TH máy không có CH Play, app sẽ tự điều hướng lên trang web CH Play
                }catch (ActivityNotFoundException e){
                    Uri uriRate = Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uriRate);
                    startActivity(goToMarket);
                }
            }
        });

        binding.lnCuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileScreenActivity.this, FragmentStoreList.class);
                startActivity(intent);
            }
        });

        binding.imvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileScreenActivity.this, FragmentPersonalInformation.class);
                startActivity(intent);
            }
        });
        binding.imvBackprofileHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.imvDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (ProfileScreenActivity.this, OngoingScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}