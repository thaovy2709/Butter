package com.gautruc.butter;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.gautruc.adapter.ViewPagerAdapter;
import com.gautruc.butter.databinding.ActivityProductDetailBinding;
import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity {

    ActivityProductDetailBinding binding;

    TextView[] dots;
    ArrayList<Integer> products;

    int images[] = {R.drawable.cookiedailyy, R.drawable.dailycookieraspberry, R.drawable.dailycookiechoco, R.drawable.dailycookiematcha};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_product_detail);

        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();

        ViewPagerAdapter adapter = new ViewPagerAdapter(this, images);
        binding.viewPager.setAdapter(adapter);

    }


    private void addEvents() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetailActivity.this,MenuScreenWithCartActivity.class);
                startActivity(intent);
            }
        });

        binding.imvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sl = Integer.parseInt(binding.txtQuantity.getText().toString());
                if (sl>0 || sl == 0){
                    sl = sl + 1;
                    binding.txtQuantity.setText(String.valueOf(sl));
                }
            }
        });

        binding.imvRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sl = Integer.parseInt(binding.txtQuantity.getText().toString());
                if (sl > 0) {
                    sl = sl - 1;
                    binding.txtQuantity.setText(String.valueOf(sl));
                }
            }
        });

        binding.imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.imvLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.imvLove.setImageResource(R.drawable.love);
            }
        });



    }


}