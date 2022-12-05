package com.gautruc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.butter.NotificationList;
import com.gautruc.butter.R;
import com.gautruc.model.Noti;

import java.util.ArrayList;

public class NotiAdapter extends RecyclerView.Adapter<NotiAdapter.NotiViewHolder> {

    private Context mContext;
    ArrayList<Noti> notis;

    public NotiAdapter(Context mContext, ArrayList<Noti> notis, NotificationList notificationList) {
        this.mContext = mContext;
        this.notis = notis;
    }

    @NonNull
    @Override
    public NotiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noti, parent, false);
        return new NotiViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotiViewHolder holder, int position) {
        Noti noti = notis.get(position);
        if (noti == null) {
            return;
        }

        holder.imvnoti.setImageResource(notis.get(position).getResourceID());
        holder.txttimeNoti.setText(notis.get(position).getTxttimeNoti());
        holder.txtnameNoti.setText(notis.get(position).getTxtnameNoti());
        holder.txtdetailNoti.setText(notis.get(position).getTxtdetailNoti());

    }

    @Override
    public int getItemCount() {
        if (notis != null) {
            return notis.size();
        }
        return 0;
    }

    public class NotiViewHolder extends RecyclerView.ViewHolder {
        private ImageView imvnoti;
        private TextView txtnameNoti, txtdetailNoti, txttimeNoti;


        public NotiViewHolder(@NonNull View itemView) {
            super(itemView);

            imvnoti = itemView.findViewById(R.id.imvnoti);
            txtnameNoti = itemView.findViewById(R.id.txtnameNoti);
            txtdetailNoti = itemView.findViewById(R.id.txtdetailNoti);
            txttimeNoti = itemView.findViewById(R.id.txttimeNoti);
        }
    }


}
