package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.gautruc.adapter.blogHomepageAdapter;
import com.gautruc.adapter.categoryHomepageAdapter;
import com.gautruc.adapter.eventHomepageAdapter;
import com.gautruc.adapter.sliderAdapter;
import com.gautruc.butter.databinding.ActivityClientHomepageBinding;
import com.gautruc.model.blogHomepage;
import com.gautruc.model.categoryHomepage;
import com.gautruc.model.eventHomepage;
import com.gautruc.model.productHomepage;
import com.gautruc.model.sliderBanner;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class ClientHomepageActivity extends AppCompatActivity {

    ActivityClientHomepageBinding binding;

    //Tạo recycle view cho danh sách sản phẩm
    RecyclerView rcvCategory;
    com.gautruc.adapter.categoryHomepageAdapter categoryHomepageAdapter;
    blogHomepageAdapter blogHomepageAdapter;
    eventHomepageAdapter eventHomepageAdapter;
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
        //setContentView(R.layout.activity_client_homepage);

        binding = ActivityClientHomepageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        loadEvents();
        bannerEvent();
        addEvents();
    }

    private void loadEvents() {
        //load dữ liệu blog + events
        eventHomepageList = new ArrayList<>();
        eventHomepageList.add(new eventHomepage(R.drawable.momovuong, "Ví MoMo khao mỗi ngày 50k"));
        eventHomepageList.add(new eventHomepage(R.drawable.freeshipnoelbannerdoc, "Quà Noel từ Butter"));
        eventHomepageAdapter = new eventHomepageAdapter(ClientHomepageActivity.this, R.layout.item_event_homepage, eventHomepageList);

        binding.gvEventListHomepage.setAdapter(eventHomepageAdapter);

        blogHomepageList = new ArrayList<>();
        blogHomepageList.add(new blogHomepage(R.drawable.cookiecoffee,"09/11/2022", "Bánh ngọt có thể làm giảm stress?", "Cuộc sống ngày này của thế hệ Gen Z có rất nhiều đều cần phải lo lắng, bận tâm"));
        blogHomepageList.add(new blogHomepage(R.drawable.croissanttrungmuoi2,"09/11/2022", "Giới thiệu về thế giới bánh Brioche", "Brioche là một loại bánh mì phong phú và thơm ngon với vị ngọt ngào và thơm mùi bơ."));


        blogHomepageAdapter = new blogHomepageAdapter(ClientHomepageActivity.this, R.layout.item_blog_homepage, blogHomepageList);

        binding.gvBlogListHomepage.setAdapter(blogHomepageAdapter);
    }

    private void addEvents() {
        //BẤM VÀO XEM SẢN PHẨM -> intent product detail

        //BẤM VÀO XEM BLOG -> intent blog detail

        //BẤM VÀO XEM EVENT -> intent event

    }

    private void loadData() {
        rcvCategory = findViewById(R.id.rcv_product);
        categoryHomepageAdapter = new categoryHomepageAdapter(ClientHomepageActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryHomepageAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryHomepageAdapter);
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


    private List<categoryHomepage> getListCategory() {
        List<categoryHomepage> listCategory = new ArrayList<>();

        noelProductList = new ArrayList<productHomepage>();
        noelProductList.add(new productHomepage(R.drawable.dailycookie,"Daily Cookie","4.7","Còn 8 sản phẩm", 35000, 40000));
        noelProductList.add(new productHomepage(R.drawable.brownsugar,"Ceridwen","4.7","Còn 8 sản phẩm", 38000, 39500));
        noelProductList.add(new productHomepage(R.drawable.croissant,"Croissant","4.7","Còn 8 sản phẩm", 20000, 35000));
        noelProductList.add(new productHomepage(R.drawable.coldbrewmocha,"Cold mocha","4.8","Còn 8 sản phẩm", 50000, 65000));
        noelProductList.add(new productHomepage(R.drawable.cookiecoffee,"Cookie coffee","4.9","Còn 7 sản phẩm", 35000, 50000));
        noelProductList.add(new productHomepage(R.drawable.cutewormchocolate,"Chocolate","4.7","Còn 5 sản phẩm", 40000, 55000));

        listCategory.add(new categoryHomepage("Noel của bạn", R.drawable.homepagesanta, noelProductList));

        return listCategory;
    }

}