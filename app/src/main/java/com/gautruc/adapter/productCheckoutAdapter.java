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

import com.gautruc.butter.CheckoutActivity;
import com.gautruc.butter.R;
import com.gautruc.model.productCheckout;

import java.util.ArrayList;

public class productCheckoutAdapter extends RecyclerView.Adapter<productCheckoutAdapter.ViewHolder> {

    private Context mContext;
    //private List<productCheckout> productCheckoutList;
    ArrayList<productCheckout> productCheckoutList;

    public productCheckoutAdapter(Context mContext, ArrayList<productCheckout> productCheckoutList, CheckoutActivity checkoutActivity) {
        this.mContext = mContext;
        this.productCheckoutList = productCheckoutList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_checkout, parent,false);

        return new ViewHolder(itemView);
    }

    //deals with the setting of different data and methods related to click on items
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        productCheckout productcheckout = productCheckoutList.get(i);
        if(productcheckout == null){
            return;
        }

        //set text of each item
        holder.imv_item.setImageResource(productCheckoutList.get(i).getPhoto());
        holder.txt_name.setText(productCheckoutList.get(i).getName());
        holder.txt_price.setText(String.valueOf(productCheckoutList.get(i).getPrice()));
        holder.txt_oldPrice.setText(String.valueOf(productCheckoutList.get(i).getOldPrice()) );
        holder.txt_productQuantity.setText(String.valueOf(productCheckoutList.get(i).getProductQuantity()));


        //Nhảy số product quantity

        holder.imv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = Integer.parseInt((holder.txt_productQuantity).getText().toString());
                if(sl>1 || sl==1)
                {
                    sl = sl + 1;
                    holder.txt_productQuantity.setText(String.valueOf(sl));;
                }
            }
        });

        holder.imv_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = Integer.parseInt((holder.txt_productQuantity).getText().toString());
                if(sl>1)
                {
                    sl = sl -1;
                    holder.txt_productQuantity.setText(String.valueOf(sl));;
                }
            }
        });

        holder.imv_trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemRemoved(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(productCheckoutList != null){
            return productCheckoutList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imv_item, imv_remove, imv_add, imv_trash;
        TextView txt_name, txt_price, txt_oldPrice, txt_productQuantity;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imv_trash = itemView.findViewById(R.id.imv_trash);
            imv_remove = itemView.findViewById(R.id.imv_remove);
            imv_add = itemView.findViewById(R.id.imv_add);
            //initialize components with id
            imv_item = itemView.findViewById(R.id.imv_item);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_price = itemView.findViewById(R.id.txt_price);
            txt_oldPrice = itemView.findViewById(R.id.txt_oldPrice);
            txt_productQuantity = itemView.findViewById(R.id.txt_productQuantity);
        }
    }
}
