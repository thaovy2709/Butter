package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.gautruc.adapter.PointAdapter;
import com.gautruc.butter.databinding.ActivityPointExchangeBinding;
import com.gautruc.fragment.FragementPromotionExchangePoint;
import com.gautruc.model.point;

import java.util.ArrayList;

public class PointExchangeActivity extends AppCompatActivity {

    PointAdapter pointAdapter;
    ArrayList<point> points;

    ActivityPointExchangeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_point_exchange);

        binding = ActivityPointExchangeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addViews();

    }


    private void addViews() {
        points = new ArrayList<>();
        points.add(new point("16:50 - 25/10/2022", "Đơn hàng #I17201026722021", 30));
        points.add(new point("16:50 - 25/10/2022", "Đơn hàng #I17201026722021", 30));
        points.add(new point("16:50 - 25/10/2022", "Đơn hàng #I17201026722021", 30));

        pointAdapter = new PointAdapter(PointExchangeActivity.this,R.layout.item_point_exchange, points);

        binding.lvpoint.setAdapter(pointAdapter);

    }
    
}