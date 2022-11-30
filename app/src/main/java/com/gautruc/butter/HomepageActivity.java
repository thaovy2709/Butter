package com.gautruc.butter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.gautruc.adapter.categoryHomepageAdapter;
import com.gautruc.adapter.productHomepageAdapter;
import com.gautruc.adapter.sliderAdapter;
import com.gautruc.butter.databinding.ActivityHomepageBinding;
import com.gautruc.model.categoryHomepage;
import com.gautruc.model.productHomepage;
import com.gautruc.model.sliderBanner;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomepageActivity extends AppCompatActivity {


    ActivityHomepageBinding binding;

    //Tạo recycle view cho danh sách sản phẩm
    RecyclerView rcvCategory, rcv_noel;
    categoryHomepageAdapter categoryHomepageAdapter;
    ArrayList<productHomepage> suggestProductList;
    ArrayList<productHomepage> noelProductList;

    //Tạo viewpager cho banner
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    sliderAdapter slideradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_homepage);

        //remember me
        //getSupportActionBar().hide();

        binding = ActivityHomepageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();
        loadProduct();
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
        noelProductList.add(new productHomepage(R.drawable.dailycookie,"Daily Cookie","4.7","Còn 50 sản phẩm", 35000, 40000));
        noelProductList.add(new productHomepage(R.drawable.brownsugar,"Ceridwen","4.7","Còn 50 sản phẩm", 380000, 395000));
        noelProductList.add(new productHomepage(R.drawable.croissant,"Croissant","4.7","Còn 50 sản phẩm", 20000, 35000));
        noelProductList.add(new productHomepage(R.drawable.coldbrewmocha,"Cold brew mocha","4.8","", 50000, 65000));
        noelProductList.add(new productHomepage(R.drawable.cookiecoffee,"Cookie coffee","4.9","Còn 80 sản phẩm", 35000, 50000));
        noelProductList.add(new productHomepage(R.drawable.cutewormchocolate,"Cuteworm Chocolate","4.7","Còn 50 sản phẩm", 40000, 55000));

        suggestProductList = new ArrayList<productHomepage>();
        suggestProductList.add(new productHomepage(R.drawable.dailycookie1,"Daily Cookie","4.7","Còn 50 sản phẩm", 35000, 40000));
        suggestProductList.add(new productHomepage(R.drawable.croissanttrungmuoi1,"Croissant trứng muối","4.7","Còn 50 sản phẩm", 350000,45000));
        suggestProductList.add(new productHomepage(R.drawable.oreocheese1,"Oreo cheese","4.7","Còn 14 sản phẩm", 35000, 48000));
        suggestProductList.add(new productHomepage(R.drawable.brioche1,"Brioche","5.0","Còn 20 sản phẩm", 25000, 35000));

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


