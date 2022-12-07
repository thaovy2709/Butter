package com.gautruc.butter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import androidx.appcompat.widget.SearchView;

public class FragmentSearchResults extends FragmentSearchScreen{
    GridView gvProduct;
    SearchView svSearchInResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_search_resullts);
        gvProduct.findViewById(R.id.rcv_search);
        addEvent();
    }

    private void addEvent() {

        svSearchInResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentSearchResults.this, FragmentSearchScreen.class);
                startActivity(intent);
            }
        });

        gvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(FragmentSearchResults.this, ProductDetailActivity.class);
                startActivity(intent);
            }
        });

    }

}
