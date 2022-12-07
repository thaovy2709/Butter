package com.gautruc.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.butter.HomepageActivity;
import com.gautruc.butter.R;
import com.gautruc.model.categoryHomepage;
import com.gautruc.model.productHomepage;

import java.util.List;

public class categoryHomepageAdapter extends RecyclerView.Adapter<categoryHomepageAdapter.categoryViewHolder> {

    Context mcontext;
    List<categoryHomepage> categoryHomepageList;

    public categoryHomepageAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    public void setData(List<categoryHomepage> list){
        this.categoryHomepageList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homepagecategory,parent,false);

        return new  categoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryViewHolder holder, int position) {
        categoryHomepage categoryHomepage = categoryHomepageList.get(position);
        if(categoryHomepage == null){
            return;
        }

        holder.txt_nameCategory.setText(categoryHomepage.getNameCategory());
        holder.imv_category.setImageResource(categoryHomepage.getPhoto());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mcontext, RecyclerView.HORIZONTAL, false);
        holder.rcv_product.setLayoutManager(linearLayoutManager);

        productHomepageAdapter producthomepageadapter = new productHomepageAdapter();
        producthomepageadapter.setData(categoryHomepage.getProductHomepageList());
        holder.rcv_product.setAdapter(producthomepageadapter);
    }

    @Override
    public int getItemCount() {
        if(categoryHomepageList != null){
            return categoryHomepageList.size();

        }
        return 0;
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder{

        TextView txt_nameCategory;
        ImageView imv_category;
        RecyclerView rcv_product;

        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);

            imv_category = itemView.findViewById(R.id.imv_category);
            txt_nameCategory = itemView.findViewById(R.id.txt_nameCategory);
            rcv_product = itemView.findViewById(R.id.rcv_product);
        }
    }
}
