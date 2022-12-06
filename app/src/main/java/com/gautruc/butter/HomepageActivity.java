package com.gautruc.butter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.gautruc.adapter.blogHomepageAdapter;
import com.gautruc.adapter.categoryHomepageAdapter;
import com.gautruc.adapter.eventHomepageAdapter;
import com.gautruc.adapter.sliderAdapter;
import com.gautruc.butter.databinding.ActivityHomepageBinding;
import com.gautruc.model.blogHomepage;
import com.gautruc.model.categoryHomepage;
import com.gautruc.model.eventHomepage;
import com.gautruc.model.productHomepage;
import com.gautruc.model.sliderBanner;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomepageActivity extends AppCompatActivity {


    ActivityHomepageBinding binding;

    //Tạo recycle view cho danh sách sản phẩm
    RecyclerView rcvCategory;
    categoryHomepageAdapter categoryHomepageAdapter;
    eventHomepageAdapter eventHomepageAdapter;
    blogHomepageAdapter blogHomepageAdapter;
    ArrayList<productHomepage> suggestProductList;
    ArrayList<productHomepage> noelProductList;
    ArrayList<eventHomepage> eventHomepageList;
    ArrayList<blogHomepage> blogHomepageList;
    //Tạo viewpager cho banner
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    sliderAdapter slideradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_homepage);


        binding = ActivityHomepageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        manipulateMenu();
        loadEvent();
        loadProduct();
        addEvent();

    }

    private void manipulateMenu() {
        binding.bottomNavigation.setSelectedItemId(R.id.bottom_navigation);

        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_Homepage:
                        return true;
                    case R.id.nav_Menu:
                        startActivity(new Intent(getApplicationContext(), MenuScreenActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_ButterId:
                        startActivity(new Intent(getApplicationContext(), ActivityButterID.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_Promotion:
                        startActivity(new Intent(getApplicationContext(), PromotionScreenActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_Order:
                        startActivity(new Intent(getApplicationContext(), OngoingScreenActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
    }

    private void loadEvent() {
        eventHomepageList = new ArrayList<>();
        eventHomepageList.add(new eventHomepage(R.drawable.momovuong, "Ví MoMo khao mỗi ngày 50k"));
        eventHomepageList.add(new eventHomepage(R.drawable.freeshipnoelbannerdoc, "Quà Noel từ Butter"));
        eventHomepageAdapter = new eventHomepageAdapter(HomepageActivity.this, R.layout.item_event_homepage, eventHomepageList);

        binding.gvEventListHomepage.setAdapter(eventHomepageAdapter);

        blogHomepageList = new ArrayList<>();
        blogHomepageList.add(new blogHomepage(R.drawable.cookiecoffee,"09/11/2022", "Bánh ngọt có thể làm giảm stress?", "Cuộc sống ngày này của thế hệ Gen Z có rất nhiều đều cần phải lo lắng, bận tâm"));
        blogHomepageList.add(new blogHomepage(R.drawable.croissanttrungmuoi2,"09/11/2022", "Giới thiệu về thế giới bánh Brioche", "Brioche là một loại bánh mì phong phú và thơm ngon với vị ngọt ngào và thơm mùi bơ."));


        blogHomepageAdapter = new blogHomepageAdapter(HomepageActivity.this, R.layout.item_blog_homepage, blogHomepageList);

        binding.gvBlogListHomepage.setAdapter(blogHomepageAdapter);
    }


    private void loadProduct() {
        rcvCategory = findViewById(R.id.rcv_product);
        categoryHomepageAdapter = new categoryHomepageAdapter(HomepageActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryHomepageAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryHomepageAdapter);




    }

    //init data
    private List<categoryHomepage> getListCategory(){

        List<categoryHomepage> listCategory = new ArrayList<>();

        noelProductList = new ArrayList<productHomepage>();
        noelProductList.add(new productHomepage(R.drawable.dailycookie,"Daily Cookie","4.7","Còn 8 sản phẩm", 35000, 40000));
        noelProductList.add(new productHomepage(R.drawable.brownsugar,"Ceridwen","4.7","Còn 8 sản phẩm", 38000, 39500));
        noelProductList.add(new productHomepage(R.drawable.croissant,"Croissant","4.7","Còn 8 sản phẩm", 20000, 35000));
        noelProductList.add(new productHomepage(R.drawable.coldbrewmocha,"Cold mocha","4.8","Còn 8 sản phẩm", 50000, 65000));
        noelProductList.add(new productHomepage(R.drawable.cookiecoffee,"Cookie coffee","4.9","Còn 7 sản phẩm", 35000, 50000));
        noelProductList.add(new productHomepage(R.drawable.cutewormchocolate,"Chocolate","4.7","Còn 5 sản phẩm", 40000, 55000));

        suggestProductList = new ArrayList<productHomepage>();
        suggestProductList.add(new productHomepage(R.drawable.dailycookie,"Daily Cookie","4.7","Còn 5 sản phẩm", 35000, 40000));
        suggestProductList.add(new productHomepage(R.drawable.croissanttrungmuoi1,"Croissant","4.7","Còn 5 sản phẩm", 350000,45000));
        suggestProductList.add(new productHomepage(R.drawable.oreocheese1,"Oreo cheese","4.7","Còn 4 sản phẩm", 35000, 48000));
        suggestProductList.add(new productHomepage(R.drawable.brioche1,"Brioche","5.0","Còn 2 sản phẩm", 25000, 35000));

        listCategory.add(new categoryHomepage("Noel của bạn", R.drawable.homepagesanta, noelProductList));
        listCategory.add(new categoryHomepage("Butter bạn sẽ thích", R.drawable.shipping, suggestProductList));
        return listCategory;
    }

    private void addEvent() {
        viewPager = findViewById(R.id.viewpager);
        circleIndicator = findViewById(R.id.circle_indicator);

        slideradapter = new sliderAdapter(this, getListBanner());
        viewPager.setAdapter(slideradapter);

        circleIndicator.setViewPager(viewPager);
        slideradapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        binding.imvNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, NotificationList.class);
                startActivity(intent);
            }
        });

        binding.imvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, ProfileScreenActivity.class);
                startActivity(intent);
            }
        });

        binding.imvButteridBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, ActivityButterID.class);
                startActivity(intent);
            }
        });

        binding.rcvProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, ProductDetailActivity.class);
                startActivity(intent);
            }
        });
        binding.txtReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, HomepageBlogScreen.class);
                startActivity(intent);
            }
        });
        binding.txtReadMorePromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, HomepageEvent.class);
                startActivity(intent);
            }
        });
        binding.searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, FragmentSearchScreen.class);
                startActivity(intent);
            }
        });
    }

    //Init banner data
    private List<sliderBanner> getListBanner() {
        List<sliderBanner> list = new ArrayList<>();
        list.add(new sliderBanner(R.drawable.bannerngangnoel));
        list.add(new sliderBanner(R.drawable.vimomokhaomoingaybannerngang));
        list.add(new sliderBanner(R.drawable.ghemangdi));
        list.add(new sliderBanner(R.drawable.halloweenngang));

        return list;
    }







}


