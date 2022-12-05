package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OrderInfoScreen extends AppCompatActivity {

    ImageView imvBacktoOngoing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info_screen);

        linkView();
        addEvents();
    }

    private void addEvents() {
        imvBacktoOngoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderInfoScreen.this,OngoingScreenActivity.class);
                startActivity(intent);
            }
        });
    }

    private void linkView() {
        imvBacktoOngoing = findViewById(R.id.imvBacktoOngoing);
    }
}