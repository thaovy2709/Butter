package com.gautruc.adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.butter.ProductDetailActivity;
import com.gautruc.butter.R;
import com.gautruc.model.search;

import java.util.ArrayList;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private ArrayList<search> searchList;

    public static class SearchViewHolder extends RecyclerView.ViewHolder {

        public ImageView imvProduct;
        public TextView txtName;
        public TextView txtIngredients;
        public TextView txtPrice;
        LinearLayout ll_search;

        public SearchViewHolder(View itemView) {
            super(itemView);
            imvProduct = itemView.findViewById(R.id.imv_Image);
            txtName = itemView.findViewById(R.id.txt_SearchName);
            txtIngredients = itemView.findViewById(R.id.txt_Ingredients);
            txtPrice = itemView.findViewById(R.id.txt_Price);
            ll_search = itemView.findViewById(R.id.ll_search);
        }
    }

    public SearchAdapter(ArrayList<search>list) {
       searchList = list;
    }


    public void setFilteredList(ArrayList<search> filteredList) {
        this.searchList= filteredList;
        notifyDataSetChanged();
    }


    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fragment_search_resullts, parent, false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(v);
        return searchViewHolder;
    }


    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        search search = searchList.get(position);
        holder.imvProduct.setImageResource(search.getImage());
        holder.txtName.setText(search.getProductName());
        holder.txtIngredients.setText(search.getProductIngredient());
        holder.txtPrice.setText(search.getProductPrice());
        holder.ll_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductDetailActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

}
