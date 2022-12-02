package com.gautruc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gautruc.butter.R;
import com.gautruc.model.product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<product> productList;

    public ProductAdapter(Context context, int layout, List<product> productList) {
        this.context = context;
        this.layout = layout;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txt_productName, txt_productRate, txt_productPrice, txt_productOldPrice;
        ImageView imv_productImage;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txt_productName =view.findViewById(R.id.txt_productName);
            holder.txt_productRate = view.findViewById(R.id.txt_productRate);
            holder.txt_productPrice = view.findViewById(R.id.txt_productPrice);
            holder.txt_productOldPrice = view.findViewById(R.id.txt_productOldPrice);
            holder.imv_productImage = view.findViewById(R.id.imv_productImage);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        product product = productList.get(i);
        holder.txt_productName.setText(product.getName());
        holder.txt_productRate.setText(product.getRate());
        holder.txt_productPrice.setText(product.getPrice().toString());
        holder.txt_productOldPrice.setText(product.getOldprice().toString());
        String imgName = product.getImage();
        int resID = ((Activity)context).getResources().getIdentifier(imgName,"drawable",((Activity)context).getPackageName());
        holder.imv_productImage.setImageResource(resID);

        return view;
    }
}
