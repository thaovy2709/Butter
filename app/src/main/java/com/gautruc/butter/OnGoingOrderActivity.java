package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gautruc.butter.databinding.ActivityOnGoingOrderBinding;
import com.gautruc.butter.databinding.FragmentCancelOrderBinding;

public class OnGoingOrderActivity extends AppCompatActivity {

    ActivityOnGoingOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_on_going_order);

        binding = ActivityOnGoingOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();
    }

    private void addEvent() {
        binding.imvBackOngoingScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Back về màn hình đơn hàng đang đặt

            }
        });

        binding.btnCancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnGoingOrderActivity.this, CancelOrderFragment.class);
                startActivity(intent);
            }
        });
    }
}