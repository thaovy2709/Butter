package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentButterIDConfirmOrder extends AppCompatActivity {

    Button btnOrderSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_butter_idconfirm_order);
        getSupportActionBar().hide();

        linkViews();
        addEvents();
    }

    private void addEvents() {
//        btnOrderSuccess.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FragmentButterIDConfirmOrder.this,detailedorder.class);
//                startActivity(intent);
//            }
//        });
    }

    private void linkViews() {
        btnOrderSuccess = findViewById(R.id.btn_OrderSuccess);
    }
}