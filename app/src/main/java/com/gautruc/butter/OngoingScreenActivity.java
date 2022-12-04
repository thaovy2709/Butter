package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.gautruc.adapter.OrderAdapter;
import com.gautruc.model.order;

import java.util.ArrayList;

public class OngoingScreenActivity extends AppCompatActivity {

    Button btnOngoing,btnDelivered;
    ListView lvOrder;

    ArrayList<order> arrayList;
    OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing_screen);

        linkView();
        ongoing();
        delivered();
        addEvents();
    }

    private void addEvents() {
        btnOngoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ongoing();
                btnDelivered.setBackgroundResource(R.drawable.graybutton);
                btnOngoing.setBackgroundResource(R.drawable.yellowbutton);
                btnDelivered.setTextColor(OngoingScreenActivity.this.getResources().getColor(R.color.neutral_4));
                btnOngoing.setTextColor(OngoingScreenActivity.this.getResources().getColor(R.color.primary_5));
            }
        });
        btnDelivered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delivered();
                btnDelivered.setBackgroundResource(R.drawable.yellowbutton);
                btnOngoing.setBackgroundResource(R.drawable.graybutton);
                btnDelivered.setTextColor(OngoingScreenActivity.this.getResources().getColor(R.color.primary_5));
                btnOngoing.setTextColor(OngoingScreenActivity.this.getResources().getColor(R.color.neutral_4));
            }
        });
    }


    private void delivered() {
        arrayList = new ArrayList<>();
        arrayList.add(new order("1 Cookie Oatmeal - 2 Daily cookie", "11:11 - 12/11/1022", 110000f));
        arrayList.add(new order("Croissant trứng muối", "16:49 - 25/10/1022", 40000f));
        arrayList.add(new order("Raisin Bread", "18:23 - 23/10/1022", 35000f));
        adapter = new OrderAdapter(this,0, arrayList);
        lvOrder.setAdapter(adapter);
    }

    private void ongoing() {
        arrayList = new ArrayList<>();
        arrayList.add(new order("2 Bánh Raisin bread, 1 Cookie Oatmeal", "Đang chuẩn bị",100000f));
        adapter = new OrderAdapter(this,0,arrayList);

        lvOrder.setAdapter(adapter);
    }

    private void linkView() {
        btnOngoing = (Button) findViewById(R.id.btn_ongoing);
        btnDelivered = (Button) findViewById(R.id.btn_delivered);
        lvOrder = (ListView) findViewById(R.id.lv_orderHistory);
    }
}