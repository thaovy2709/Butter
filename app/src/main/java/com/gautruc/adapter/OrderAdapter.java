package com.gautruc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gautruc.butter.R;
import com.gautruc.model.order;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<order> orderArrayList;

    public OrderAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        this.context = context;
        this.orderArrayList = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_ongoing_order, null);

        }
        if (orderArrayList.size() > 0) {
            order order = orderArrayList.get(position);
            TextView txtOrder = convertView.findViewById(R.id.txt_orderInfo);
            txtOrder.setText(order.getOrder());

            TextView txtStatus = convertView.findViewById(R.id.txt_status);
            txtStatus.setText(order.getStatus());

            TextView txtPrice = convertView.findViewById(R.id.txt_price);
            txtPrice.setText(order.getPrice()+"");
        }
        return convertView;
    }

}
