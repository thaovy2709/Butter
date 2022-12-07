package com.gautruc.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.butter.FavoriteDishesListScreen;
import com.gautruc.butter.ProductDetailActivity;
import com.gautruc.butter.R;
import com.gautruc.model.FavoriteDish;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>  {

    private Context mContext;
    ArrayList<FavoriteDish> favor;

    public FavoriteAdapter(Context mContext, ArrayList<FavoriteDish> favor, FavoriteDishesListScreen favoriteDish) {
        this.mContext = mContext;
        this.favor = favor;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite_dishes, parent,false);
        return new FavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        FavoriteDish favoriteDish = favor.get(position);
        if (favoriteDish == null) {
            return;
        }
        holder.imvDish.setImageResource(favoriteDish.getDish());
        holder.txtPrice.setText(favoriteDish.getPrice());
        holder.txtQuality.setText(favoriteDish.getQuality());
        holder.txtPriceSale.setText(favoriteDish.getPriceSale());
        holder.txtRate.setText(favoriteDish.getRate());
        holder.txtNameDish.setText(favoriteDish.getNameDish());
        holder.ll_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductDetailActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (favor != null) {
            return favor.size();
        }
        return 0;
    }
    public class FavoriteViewHolder extends RecyclerView.ViewHolder{

        private ImageView imvDish;
        private TextView txtNameDish, txtRate, txtQuality, txtPriceSale, txtPrice;
        private LinearLayout ll_favorite;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            imvDish = itemView.findViewById(R.id.imvDish);
            txtNameDish = itemView.findViewById(R.id.txtNameDish);
            txtRate = itemView.findViewById(R.id.txtRate);
            txtQuality = itemView.findViewById(R.id.txtQuality);
            txtPriceSale = itemView.findViewById(R.id.txtPriceSale);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            ll_favorite = itemView.findViewById(R.id.ll_favorite);
        }
    }



}


