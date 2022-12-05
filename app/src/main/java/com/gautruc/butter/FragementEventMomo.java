package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gautruc.butter.databinding.ActivityFragementEventMomoBinding;

public class FragementEventMomo extends AppCompatActivity {
    ActivityFragementEventMomoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragement_event_momo);

        binding = ActivityFragementEventMomoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();

    }

    private void addEvent() {
        binding.imvBackMomo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragementEventMomo.this, HomepageEvent.class);
                startActivity(intent);
            }
        });
    }
}