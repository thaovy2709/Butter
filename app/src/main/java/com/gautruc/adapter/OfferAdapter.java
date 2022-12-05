package com.gautruc.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.butter.R;
import com.gautruc.model.Offer;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder>{

    private Context mContext;
    private List <Offer> mListOffer;

    public OfferAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Offer> list){
        this.mListOffer = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_redeemoffer, parent, false);
        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {
        Offer offer = mListOffer.get(position);
        if (offer == null){
            return;
        }

        holder.offerThumb.setImageResource(offer.getOfferThumb());
        holder.offerInfo.setText(offer.getOfferInfo());
        holder.offerPoint.setText(String.valueOf(offer.getOfferPoint()));
        holder.offerRedeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRedeemOfferConfirmationDialog();
            }

            private void openRedeemOfferConfirmationDialog() {
                final Dialog dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.fragment_redeemofferconfirmationdialog);
                dialog.setCanceledOnTouchOutside(false);
                Button HuyXacNhanOffer = dialog.findViewById(R.id.btn_HuyXacNhanOffer);
                HuyXacNhanOffer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                Button XacNhanOffer = dialog.findViewById(R.id.btn_XacNhanOffer);
                XacNhanOffer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.setContentView(R.layout.fragment_redeemofferdone);
                        Button XacNhanDone = dialog.findViewById(R.id.btn_XacNhanDone);
                        XacNhanDone.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    }
                });
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if(mListOffer != null){
            return mListOffer.size();
        }
        return 0;
    }

    public class OfferViewHolder extends RecyclerView.ViewHolder{
        private ImageView offerThumb;
        private TextView offerInfo, offerPoint;
        private Button offerRedeem;

        public OfferViewHolder(@NonNull View itemView) {
            super(itemView);

            offerThumb = itemView.findViewById(R.id.imv_OfferThumb);
            offerInfo = itemView.findViewById(R.id.txt_OfferInfo);
            offerPoint = itemView.findViewById(R.id.txt_OfferPoint);
            offerRedeem = itemView.findViewById(R.id.btn_DoiNgay);
        }
    }
}
