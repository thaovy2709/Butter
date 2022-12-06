package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gautruc.butter.databinding.ActivityHomepageEventBinding;

public class HomepageEvent extends AppCompatActivity {

    ActivityHomepageEventBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_homepage_event);

        binding = ActivityHomepageEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.lnMomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (HomepageEvent.this, FragementEventMomo.class);
                startActivity(intent);
            }
        });

        binding.lnNoel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (HomepageEvent.this, FragementEventNoel.class);
                startActivity(intent);
            }
        });

        binding.lnTakeaway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (HomepageEvent.this, FragementEventTakeAway.class);
                startActivity(intent);
            }
        });

        binding.lnHalloween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageEvent.this, FragementEventHalloween.class);
                startActivity(intent);
            }
        });
        binding.imvEventbackHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageEvent.this, HomepageActivity.class);
                startActivity(intent);
            }
        });
    }
}