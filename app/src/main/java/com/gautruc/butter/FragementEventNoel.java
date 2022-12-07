package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gautruc.butter.databinding.ActivityFragementEventMomoBinding;
import com.gautruc.butter.databinding.ActivityFragementEventNoelBinding;

public class FragementEventNoel extends AppCompatActivity {

    ActivityFragementEventNoelBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragement_event_noel);

        binding = ActivityFragementEventNoelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();
    }

    private void addEvent() {
        binding.imvBackNoel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}