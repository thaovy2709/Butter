package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.gautruc.adapter.SearchAdapter;
import com.gautruc.model.search;

import java.util.ArrayList;
import java.util.List;


public class FragmentSearchScreen extends AppCompatActivity {

    private ArrayList<search> searchList;
    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private SearchView searchView;
    private ImageView imvBack;
    private Button btnCroissant, btnOreoCheese, btnMatchaLatte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_search_screen);
        addEvents();

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        recyclerView = findViewById(R.id.rcv_search);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchList = new ArrayList<>();


        //Add data to item list

        searchList.add(new search(R.drawable.cookieoatmealhorizontal, "Cookie Oatmeal", "Yến mạch, bột mì", "50.000/100gr"));
        searchList.add(new search(R.drawable.browniecookiehorizontal, "Brownie Cookie", "Cacao, bột mì", "50.000/100gr"));
        searchList.add(new search(R.drawable.dailycookiehorizontal, "Daily Cookie", "Hạnh nhân, bột mì", "50.000/100gr"));
        searchList.add(new search(R.drawable.briochehorizontal, "Brioche", "Bơ sữa, bột mì", "35.000/cái"));
        searchList.add(new search(R.drawable.cookiecoffeeehorizontal, "Cookie Coffee", "Cà phê, bột mì", "50.000/100gr"));
        searchList.add(new search(R.drawable.cookiepeanutoatmealhorizontal, "Cookie Peanut", "Bơ đậu phộng, bột mì", "55.000/100gr"));
        searchList.add(new search(R.drawable.toaststrawberryhorizontal, "Toast strawberry", "Dâu tây, kem tươi", "65.000/cái"));



        searchAdapter = new SearchAdapter(searchList);
        recyclerView.setAdapter(searchAdapter);


    }

    private void addEvents() {
        imvBack = findViewById(R.id.imv_back);
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCroissant = findViewById(R.id.btn_Croissant);
        btnCroissant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (FragmentSearchScreen.this, ProductDetailActivity.class);
                startActivity(intent);
            }
        });

        btnOreoCheese = findViewById(R.id.btn_OreoCheese);
        btnOreoCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (FragmentSearchScreen.this, ProductDetailActivity.class);
                startActivity(intent);
            }
        });

        btnMatchaLatte = findViewById(R.id.btn_MatchaLatte);
        btnMatchaLatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (FragmentSearchScreen.this, ProductDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void filterList(String text) {
        List<search> filteredList = new ArrayList<>();
        for (search search : searchList) {
            if (search.getProductName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(search);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this,"Không có dữ liệu", Toast.LENGTH_SHORT).show();

        } else {
            searchAdapter.setFilteredList((ArrayList<search>) filteredList);

        }

    }

}