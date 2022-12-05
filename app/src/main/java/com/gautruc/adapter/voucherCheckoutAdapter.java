package com.gautruc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.gautruc.butter.R;
import com.gautruc.butter.VoucherCheckoutFragment;
import com.gautruc.model.voucherCheckout;

import java.util.List;

public class voucherCheckoutAdapter extends BaseAdapter {

    Activity activity;
    int voucher_layout;
    List<voucherCheckout> voucherCheckoutList;

    public voucherCheckoutAdapter(Activity activity, int voucher_layout, List<voucherCheckout> voucherCheckoutList) {
        this.activity = activity;
        this.voucher_layout = voucher_layout;
        this.voucherCheckoutList = voucherCheckoutList;
    }

    @Override
    public int getCount() {
        return voucherCheckoutList.size();
    }

    @Override
    public Object getItem(int position) {
        return voucherCheckoutList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(this.voucher_layout, null);

            holder.imv_voucher = convertView.findViewById(R.id.imv_voucher);

            convertView.setTag(holder);
        }

        else {
            holder = (ViewHolder) convertView.getTag();
        }

        voucherCheckout vouchercheckout = voucherCheckoutList.get(position);
        holder.imv_voucher.setImageResource(vouchercheckout.getPhoto());


        return convertView;
    }

    public static  class ViewHolder{
        ImageView imv_voucher;
    }
}
