package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gautruc.butter.databinding.FragmentCancelSuccessBinding;

public class CancelSuccessFragment extends AppCompatActivity {

    FragmentCancelSuccessBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_cancel_success);

        binding = FragmentCancelSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();
    }

    private void addEvent() {
        binding.btnCompleteCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CancelSuccessFragment.this, HomepageActivity.class);
                startActivity(intent);
            }
        });
    }
}