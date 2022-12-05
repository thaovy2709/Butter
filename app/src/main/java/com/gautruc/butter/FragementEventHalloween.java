package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gautruc.butter.databinding.ActivityFragementEventHalloweenBinding;

public class FragementEventHalloween extends AppCompatActivity {

    ActivityFragementEventHalloweenBinding binding;
    ImageView imvbackHalloween;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragement_event_halloween);

        binding = ActivityFragementEventHalloweenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();

        binding.imvBackHalloween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addEvents() {
        binding.imvBackHalloween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragementEventHalloween.this, HomepageEvent.class);
                startActivity(intent);
            }
        });

    }
}