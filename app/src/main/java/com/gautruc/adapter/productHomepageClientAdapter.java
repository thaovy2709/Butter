package com.gautruc.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.butter.LoginActivity;
import com.gautruc.butter.MenuScreenWithCartActivity;
import com.gautruc.butter.ProductDetailActivity;
import com.gautruc.butter.R;
import com.gautruc.model.productHomepage;
import com.gautruc.model.productHomepageClient;

import java.util.List;

public class productHomepageClientAdapter extends RecyclerView.Adapter<productHomepageClientAdapter.ViewHolder> {


    private List<productHomepageClient> productHomepageClientList;

    public void setData( List<productHomepageClient> list){
        this.productHomepageClientList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public productHomepageClientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new productHomepageClientAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull productHomepageClientAdapter.ViewHolder holder, int position) {
        productHomepageClient producthomepageclient = productHomepageClientList.get(position);
        if(producthomepageclient == null){
            return;
        }


        holder.imv_Product.setImageResource(producthomepageclient.getPhoto());
        holder.txt_productName.setText(producthomepageclient.getName());
        holder.txt_Rating.setText(producthomepageclient.getRating());
        holder.txt_Stock.setText(producthomepageclient.getStock());
        holder.txt_Price.setText(String.valueOf(producthomepageclient.getPrice()));
        holder.txt_oldPrice.setText(String.valueOf(producthomepageclient.getOldPrice()));


        holder.layout_productHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), LoginActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        holder.btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), LoginActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (productHomepageClientList != null){
            return productHomepageClientList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imv_Product;
        TextView txt_productName, txt_Rating, txt_Stock, txt_Price, txt_oldPrice;
        Button btn_Add;
        androidx.cardview.widget.CardView layout_productHomepage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imv_Product = itemView.findViewById(R.id.imv_Product);
            txt_productName = itemView.findViewById(R.id.txt_productName);
            txt_Rating = itemView.findViewById(R.id.txt_Rating);
            txt_Stock = itemView.findViewById(R.id.txt_Stock);
            txt_Price = itemView.findViewById(R.id.txt_Price);
            txt_oldPrice = itemView.findViewById(R.id.txt_oldPrice);
            btn_Add = itemView.findViewById(R.id.btn_Add);
            layout_productHomepage = itemView.findViewById(R.id.layout_productHomepage);
        }
    }
}
