package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gautruc.adapter.OfferAdapter;
import com.gautruc.adapter.VoucherAdapter;
import com.gautruc.butter.databinding.ActivityFragmentRedeemOfferBinding;
import com.gautruc.butter.databinding.ActivityPromotionScreenBinding;
import com.gautruc.model.Offer;
import com.gautruc.model.Voucher;

import java.util.ArrayList;
import java.util.List;

public class FragmentRedeemOffer extends AppCompatActivity {

    ActivityFragmentRedeemOfferBinding binding;
    RecyclerView rcvOffer;
    OfferAdapter offerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_redeem_offer);
        binding = ActivityFragmentRedeemOfferBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Offer
        rcvOffer = findViewById(R.id.rcvOffer);
        offerAdapter = new OfferAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvOffer.setLayoutManager(linearLayoutManager);

        offerAdapter.setData(getListOffer());
        rcvOffer.setAdapter(offerAdapter);

        addEvents();
    }

    private void addEvents() {
        binding.imvBackFromDoiUuDaiToPromotionScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentRedeemOffer.this, PromotionScreenActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Offer> getListOffer() {
        List<Offer> listOffer = new ArrayList<>();
        listOffer.add(new Offer(R.drawable.brownsugarpop2, "Miễn phí 1 Brown Sugar Pop bất kỳ", 159));
        listOffer.add(new Offer(R.drawable.icedcofee2, "Miễn phí 1 Iced Coffee", 449));
        listOffer.add(new Offer(R.drawable.chocolatepretzelpastry1, "Miễn phí 1 Chocolate Pretzel Pastry", 699));
        listOffer.add(new Offer(R.drawable.brownsugarpop2, "Miễn phí 1 Raisin Bread", 499));
        listOffer.add(new Offer(R.drawable.icedcofee2, "Miễn phí 1 Oreo Cheese", 599));
        listOffer.add(new Offer(R.drawable.chocolatepretzelpastry1, "Miễn phí 1 Cold Brew Latte", 549));
        listOffer.add(new Offer(R.drawable.chocolatepretzelpastry1, "Miễn phí 100gr Daily Cookie", 499));

        return listOffer;
    }
}