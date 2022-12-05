package com.gautruc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.butter.R;
import com.gautruc.model.Offer;
import com.gautruc.model.Voucher;

import java.util.List;

public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>{

    private Context mContext;
    private List<Voucher> mListVoucher;

    public VoucherAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Voucher> list){
        this.mListVoucher = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VoucherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_voucher, parent, false);
        return new VoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherViewHolder holder, int position) {
        Voucher voucher = mListVoucher.get(position);
        if (voucher == null){
            return;
        }

        holder.voucherThumb.setImageResource(voucher.getVoucherThumb());
    }

    @Override
    public int getItemCount() {
        if(mListVoucher != null){
            return mListVoucher.size();
        }
        return 0;
    }

    public class VoucherViewHolder extends RecyclerView.ViewHolder{
        private ImageView voucherThumb;

        public VoucherViewHolder(@NonNull View itemView) {
            super(itemView);

            voucherThumb = itemView.findViewById(R.id.imv_VoucherThumb);
        }
    }
}
