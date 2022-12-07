package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.gautruc.adapter.FavoriteAdapter;
import com.gautruc.adapter.NotiAdapter;
import com.gautruc.butter.databinding.ActivityFavoriteDishesListScreenBinding;
import com.gautruc.butter.databinding.ActivityNotificationListBinding;
import com.gautruc.model.FavoriteDish;
import com.gautruc.model.Noti;

import java.util.ArrayList;
import java.util.List;

public class FavoriteDishesListScreen extends AppCompatActivity {

    ActivityFavoriteDishesListScreenBinding binding;
    private RecyclerView rcvFavorite;
    private FavoriteAdapter favoriteAdapter;
    ArrayList<FavoriteDish> FavorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_favorite_dishes_list_screen);

        binding = ActivityFavoriteDishesListScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        binding.rcvFavorite.setLayoutManager(linearLayoutManager);

        addData();
        addEvent();
    }

    private void addEvent() {
        binding.imvFavback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addData() {
        FavorList = new ArrayList<>();

        FavorList.add(new FavoriteDish(R.drawable.dailycookie, "5.0", "35.000", "40.000", "Daily Cookie", "Còn 20 sản phẩm"));
        FavorList.add(new FavoriteDish(R.drawable.browniecookie, "5.0", "40.000", "50.000", "Brownie cookie ice cream ", "Còn 30 sản phẩm"));
        FavorList.add(new FavoriteDish(R.drawable.croissant, "5.0", "30.000", "40.000", "Croissant trứng muối", "Còn 30 sản phẩm"));
        FavorList.add(new FavoriteDish(R.drawable.raisinbread1, "5.0", "30.000", "35.000", "Raisin Bread ", "Còn 30 sản phẩm"));

        favoriteAdapter = new FavoriteAdapter(this, FavorList , this);
        binding.rcvFavorite.setAdapter(favoriteAdapter);

    }
}