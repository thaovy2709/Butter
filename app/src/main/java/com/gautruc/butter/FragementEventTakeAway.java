package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gautruc.butter.databinding.ActivityFragementEventMomoBinding;
import com.gautruc.butter.databinding.ActivityFragementEventTakeAwayBinding;

public class FragementEventTakeAway extends AppCompatActivity {
    ActivityFragementEventTakeAwayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragement_event_take_away);

        binding = ActivityFragementEventTakeAwayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();
    }

    private void addEvent() {
        binding.imvbackTakeaway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragementEventTakeAway.this, HomepageEvent.class);
                startActivity(intent);
            }
        });
        binding.btnUseVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragementEventTakeAway.this, MenuScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}