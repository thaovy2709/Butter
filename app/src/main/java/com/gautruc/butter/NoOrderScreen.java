package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoOrderScreen extends AppCompatActivity {

    Button btnOngoing, btnDelivered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_order_screen);

        linkView();
        addEvents();
    }

    private void addEvents() {
        btnOngoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDelivered.setBackgroundResource(R.drawable.graybutton);
                btnOngoing.setBackgroundResource(R.drawable.yellowbutton);
                btnDelivered.setTextColor(NoOrderScreen.this.getResources().getColor(R.color.neutral_4));
                btnOngoing.setTextColor(NoOrderScreen.this.getResources().getColor(R.color.primary_5));
            }
        });

        btnDelivered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDelivered.setBackgroundResource(R.drawable.yellowbutton);
                btnOngoing.setBackgroundResource(R.drawable.graybutton);
                btnDelivered.setTextColor(NoOrderScreen.this.getResources().getColor(R.color.primary_5));
                btnOngoing.setTextColor(NoOrderScreen.this.getResources().getColor(R.color.neutral_4));
            }
        });
    }

    private void linkView() {
        btnOngoing = findViewById(R.id.btn_ongoing);
        btnDelivered = findViewById(R.id.btn_delivered);
    }
}