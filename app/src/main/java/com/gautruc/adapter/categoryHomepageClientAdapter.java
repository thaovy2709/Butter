package com.gautruc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.butter.R;
import com.gautruc.model.categoryHomepage;
import com.gautruc.model.categoryHomepageClient;

import java.util.List;

public class categoryHomepageClientAdapter  extends RecyclerView.Adapter<categoryHomepageClientAdapter.categoryViewHolder> {

    public categoryHomepageClientAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    Context mcontext;
    List<categoryHomepageClient> categoryHomepageClientList;

    public void setData(List<categoryHomepageClient> list){
        this.categoryHomepageClientList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public categoryHomepageClientAdapter.categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homepagecategory,parent,false);

        return new categoryHomepageClientAdapter.categoryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull categoryHomepageClientAdapter.categoryViewHolder holder, int position) {
        categoryHomepageClient categoryhomepageclient = categoryHomepageClientList.get(position);
        if(categoryhomepageclient == null){
            return;
        }

        holder.txt_nameCategory.setText(categoryhomepageclient.getNameCategory());
        holder.imv_category.setImageResource(categoryhomepageclient.getPhoto());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mcontext, RecyclerView.HORIZONTAL, false);
        holder.rcv_product.setLayoutManager(linearLayoutManager);

        productHomepageClientAdapter producthomepageclientadapter = new productHomepageClientAdapter();
        producthomepageclientadapter.setData(categoryhomepageclient.getProductHomepageClientList());
        holder.rcv_product.setAdapter(producthomepageclientadapter);
    }

    @Override
    public int getItemCount() {
        if(categoryHomepageClientList != null){
            return categoryHomepageClientList.size();

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
