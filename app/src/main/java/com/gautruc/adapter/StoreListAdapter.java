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
import com.gautruc.model.StoreList;

import java.util.List;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.StoreListViewHolder>{

    private Context mContext;
    private List<StoreList> mListStoreList;

    public StoreListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<StoreList> list){
        this.mListStoreList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StoreListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_storelist, parent, false);
        return new StoreListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreListViewHolder holder, int position) {
        StoreList storeList = mListStoreList.get(position);
        if (storeList == null) {
            return;
        }

        holder.storeListThumb.setImageResource(storeList.getStoreListThumb());
        holder.storeListName.setText(storeList.getStoreListName());
        holder.storeListAddress.setText(storeList.getStoreListAddress());
        holder.storeListPhone.setText(String.valueOf(storeList.getStoreListPhone()));
        holder.storeListOpenTime.setText(storeList.getStoreListOpenTime());
    }

    @Override
    public int getItemCount() {
        if (mListStoreList != null) {
            return mListStoreList.size();
        }

        return 0;
    }

    public class StoreListViewHolder extends RecyclerView.ViewHolder{
        private ImageView storeListThumb;
        private TextView storeListName;
        private TextView storeListAddress;
        private TextView storeListPhone;
        private TextView storeListOpenTime;


        public StoreListViewHolder(@NonNull View itemView) {
            super(itemView);

            storeListThumb = itemView.findViewById(R.id.imv_storeListThumb);
            storeListName = itemView.findViewById(R.id.txt_storeListName);
            storeListAddress = itemView.findViewById(R.id.txt_storeListAddress);
            storeListPhone = itemView.findViewById(R.id.txt_storeListPhone);
            storeListOpenTime = itemView.findViewById(R.id.txt_storeListOpenTime);
        }
    }



}
