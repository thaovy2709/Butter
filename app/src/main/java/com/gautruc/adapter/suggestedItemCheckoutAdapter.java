package com.gautruc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.butter.CheckoutActivity;
import com.gautruc.butter.R;
import com.gautruc.model.suggestedItemCheckout;

import java.util.ArrayList;

public class suggestedItemCheckoutAdapter extends RecyclerView.Adapter<suggestedItemCheckoutAdapter.ViewHolder>{

    private Context mContext;
    ArrayList<suggestedItemCheckout> suggestedItemCheckouts;

    public suggestedItemCheckoutAdapter(Context mContext, ArrayList<suggestedItemCheckout> suggestedItemCheckouts, CheckoutActivity checkoutActivity) {
        this.mContext = mContext;
        this.suggestedItemCheckouts = suggestedItemCheckouts;
    }

    @NonNull
    @Override
    public suggestedItemCheckoutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_suggestitem_checkout, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull suggestedItemCheckoutAdapter.ViewHolder holder, int position) {
        suggestedItemCheckout suggesteditemcheckout = suggestedItemCheckouts.get(position);
        if(suggesteditemcheckout == null){
            return;
        }

        holder.imv_suggested.setImageResource(suggestedItemCheckouts.get(position).getPhoto());
        holder.txt_suggestedName.setText(suggestedItemCheckouts.get(position).getName());
        holder.txt_suggestedPrice.setText(String.valueOf(suggestedItemCheckouts.get(position).getPrice()));

        holder.btn_addSuggested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Bạn đã thêm sản phẩm thành công",Toast.LENGTH_SHORT).show();
            }
        });

     }

    @Override
    public int getItemCount() {
        if(suggestedItemCheckouts != null){
            return suggestedItemCheckouts.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button btn_addSuggested;
        ImageView imv_suggested;
        TextView txt_suggestedName, txt_suggestedPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btn_addSuggested = itemView.findViewById(R.id.btn_addSuggested);
            imv_suggested = itemView.findViewById(R.id.imv_suggested);
            txt_suggestedName = itemView.findViewById(R.id.txt_nameSuggested);
            txt_suggestedPrice = itemView.findViewById(R.id.txt_priceSuggested);
        }
    }
}
