package com.gautruc.butter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.gautruc.adapter.blogHomepageAdapter;
import com.gautruc.adapter.blogHomepageClientAdapter;
import com.gautruc.adapter.categoryHomepageAdapter;
import com.gautruc.adapter.categoryHomepageClientAdapter;
import com.gautruc.adapter.eventHomepageAdapter;
import com.gautruc.adapter.eventHomepageClientAdapter;
import com.gautruc.adapter.sliderAdapter;
import com.gautruc.butter.databinding.ActivityClientHomepageBinding;
import com.gautruc.model.blogHomepage;
import com.gautruc.model.blogHomepageClient;
import com.gautruc.model.categoryHomepage;
import com.gautruc.model.categoryHomepageClient;
import com.gautruc.model.eventHomepage;
import com.gautruc.model.eventHomepageClient;
import com.gautruc.model.productHomepage;
import com.gautruc.model.productHomepageClient;
import com.gautruc.model.sliderBanner;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class ClientHomepageActivity extends AppCompatActivity {

    ActivityClientHomepageBinding binding;

    //Tạo recycle view cho danh sách sản phẩm
    RecyclerView rcvCategory;
    categoryHomepageClientAdapter categoryHomepageClientAdapter;
    blogHomepageClientAdapter blogHomepageClientAdapter;
    eventHomepageClientAdapter eventHomepageClientAdapter;
    ArrayList<productHomepageClient> productHomepageClients;
    ArrayList<eventHomepageClient> eventHomepageClients;
    ArrayList<blogHomepageClient> blogHomepageClients;
    //Tạo viewpager cho banner
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    sliderAdapter slideradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_client_homepage);

        binding = ActivityClientHomepageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        manipulateMenu();

        loadData();
        loadEvents();
        bannerEvent();
        addEvents();
    }

    private void manipulateMenu() {
        binding.bottomNavigation.setSelectedItemId(R.id.nav_Homepage);
        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_Homepage:
                        return true;
                    case R.id.nav_Order:
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_Menu:
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_ButterId:
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_Promotion:
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                }

                return false;
            }
        });
    }

    private void loadEvents() {
        //load dữ liệu blog + events
        eventHomepageClients = new ArrayList<>();
        eventHomepageClients.add(new eventHomepageClient(R.drawable.momovuong, "Ví MoMo khao mỗi ngày 50k"));
        eventHomepageClients.add(new eventHomepageClient(R.drawable.freeshipnoelbannerdoc, "Quà Noel từ Butter"));
        eventHomepageClientAdapter = new eventHomepageClientAdapter(ClientHomepageActivity.this, R.layout.item_event_homepage, eventHomepageClients);

        binding.gvEventListHomepage.setAdapter(eventHomepageClientAdapter);

        blogHomepageClients = new ArrayList<>();
        blogHomepageClients.add(new blogHomepageClient(R.drawable.cookiecoffee,"09/11/2022", "Bánh ngọt có thể làm giảm stress?", "Cuộc sống ngày này của thế hệ Gen Z có rất nhiều đều cần phải lo lắng, bận tâm"));
        blogHomepageClients.add(new blogHomepageClient(R.drawable.croissanttrungmuoi2,"09/11/2022", "Giới thiệu về thế giới bánh Brioche", "Brioche là một loại bánh mì phong phú và thơm ngon với vị ngọt ngào và thơm mùi bơ."));


        blogHomepageClientAdapter = new blogHomepageClientAdapter(ClientHomepageActivity.this, R.layout.item_blog_homepage, blogHomepageClients);

        binding.gvBlogListHomepage.setAdapter(blogHomepageClientAdapter);
    }

    private void addEvents() {
        //Bấm button đăng nhập
        binding.btnLoginClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientHomepageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        //BẤM VÀO XEM SẢN PHẨM -> intent product detail
        binding.rcvProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientHomepageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        //BẤM VÀO XEM BLOG -> intent blog detail
        binding.gvBlogListHomepage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ClientHomepageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        binding.txtReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientHomepageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        //BẤM VÀO XEM EVENT -> intent event
        binding.gvEventListHomepage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ClientHomepageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        binding.txtReadMorePromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientHomepageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        binding.imvNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientHomepageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        binding.imvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientHomepageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        rcvCategory = findViewById(R.id.rcv_product);
        categoryHomepageClientAdapter = new categoryHomepageClientAdapter(ClientHomepageActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryHomepageClientAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryHomepageClientAdapter);
    }

    private void bannerEvent() {
        viewPager = findViewById(R.id.viewpager);
        circleIndicator = findViewById(R.id.circle_indicator);

        slideradapter = new sliderAdapter(this, getListBanner());
        viewPager.setAdapter(slideradapter);

        circleIndicator.setViewPager(viewPager);
        slideradapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
    }

    private List<sliderBanner> getListBanner() {
            List<sliderBanner> list = new ArrayList<>();
            list.add(new sliderBanner(R.drawable.bannerngangnoel));
            list.add(new sliderBanner(R.drawable.vimomokhaomoingaybannerngang));
            list.add(new sliderBanner(R.drawable.ghemangdi));
            list.add(new sliderBanner(R.drawable.halloweenngang));

            return list;
    }


    private List<categoryHomepageClient> getListCategory() {
        List<categoryHomepageClient> listCategory = new ArrayList<>();

        ArrayList<productHomepageClient> noelProductList = new ArrayList<productHomepageClient>();
        noelProductList.add(new productHomepageClient(R.drawable.dailycookie,"Daily Cookie","4.7","Còn 8 sản phẩm", 35000, 40000));
        noelProductList.add(new productHomepageClient(R.drawable.brownsugar,"Ceridwen","4.7","Còn 8 sản phẩm", 38000, 39500));
        noelProductList.add(new productHomepageClient(R.drawable.croissant,"Croissant","4.7","Còn 8 sản phẩm", 20000, 35000));
        noelProductList.add(new productHomepageClient(R.drawable.coldbrewmocha,"Cold mocha","4.8","Còn 8 sản phẩm", 50000, 65000));
        noelProductList.add(new productHomepageClient(R.drawable.cookiecoffee,"Cookie coffee","4.9","Còn 7 sản phẩm", 35000, 50000));
        noelProductList.add(new productHomepageClient(R.drawable.cutewormchocolate,"Chocolate","4.7","Còn 5 sản phẩm", 40000, 55000));

        listCategory.add(new categoryHomepageClient("Noel của bạn", R.drawable.homepagesanta, noelProductList));

        return listCategory;
    }

}