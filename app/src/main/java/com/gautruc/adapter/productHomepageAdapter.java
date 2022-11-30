package com.gautruc.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.butter.R;
import com.gautruc.model.productHomepage;

import java.util.List;

public class productHomepageAdapter extends RecyclerView.Adapter<productHomepageAdapter.ViewHolder>{


    private List<productHomepage> productHomepageList;

    public void setData(List<productHomepage> list){
        this.productHomepageList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        productHomepage producthomepage = productHomepageList.get(position);
        if(producthomepage == null){
            return;
        }


        holder.imv_Product.setImageResource(producthomepage.getPhoto());
        holder.txt_productName.setText(producthomepage.getName());
        holder.txt_Rating.setText(producthomepage.getRating());
        holder.txt_Stock.setText(producthomepage.getStock());
        holder.txt_Price.setText(String.valueOf(producthomepage.getPrice()));
        holder.txt_oldPrice.setText(String.valueOf(producthomepage.getOldPrice()));
    }



    @Override
    public int getItemCount() {
        if (productHomepageList != null){
            return productHomepageList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imv_Product;
        TextView txt_productName, txt_Rating, txt_Stock, txt_Price, txt_oldPrice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imv_Product = itemView.findViewById(R.id.imv_Product);
            txt_productName = itemView.findViewById(R.id.txt_productName);
            txt_Rating = itemView.findViewById(R.id.txt_Rating);
            txt_Stock = itemView.findViewById(R.id.txt_Stock);
            txt_Price = itemView.findViewById(R.id.txt_Price);
            txt_oldPrice = itemView.findViewById(R.id.txt_oldPrice);
        }
    }
}
