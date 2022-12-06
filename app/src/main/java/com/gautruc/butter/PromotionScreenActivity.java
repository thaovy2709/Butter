package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gautruc.adapter.OfferAdapter;
import com.gautruc.adapter.VoucherAdapter;
import com.gautruc.butter.databinding.ActivityPromotionScreenBinding;
import com.gautruc.model.Offer;
import com.gautruc.model.Voucher;

import java.util.ArrayList;
import java.util.List;

public class PromotionScreenActivity extends AppCompatActivity {

    ActivityPromotionScreenBinding binding;
    RecyclerView rcvOffer;
    OfferAdapter offerAdapter;

    RecyclerView rcvVoucher;
    VoucherAdapter voucherAdapter;

    EditText edtNhapMaKhuyenMai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_promotion_screen);
        binding = ActivityPromotionScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();

        //Offer
        rcvOffer = findViewById(R.id.rcv_Offer);
        offerAdapter = new OfferAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvOffer.setLayoutManager(linearLayoutManager);

        offerAdapter.setData(getListOffer());
        rcvOffer.setAdapter(offerAdapter);

        //Voucher
        rcvVoucher = findViewById(R.id.rcv_Voucher);
        voucherAdapter = new VoucherAdapter(this);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvVoucher.setLayoutManager(linearLayoutManager1);

        voucherAdapter.setData(getListVoucher());
        rcvVoucher.setAdapter(voucherAdapter);

        //EditText
        edtNhapMaKhuyenMai = findViewById(R.id.edt_NhapMaKhuyenMai);
    }

    private List<Voucher> getListVoucher() {
        List<Voucher> listVoucher = new ArrayList<>();
        listVoucher.add(new Voucher(R.drawable.voucher8));
        listVoucher.add(new Voucher(R.drawable.voucher2));
        listVoucher.add(new Voucher(R.drawable.voucher3));

        return listVoucher;
    }

    private List<Offer> getListOffer() {
        List<Offer> listOffer = new ArrayList<>();
        listOffer.add(new Offer(R.drawable.brownsugarpop2, "Miễn phí 1 Brown Sugar Pop bất kỳ", 159));
        listOffer.add(new Offer(R.drawable.icedcofee2, "Miễn phí 1 Iced Coffee", 449));
        listOffer.add(new Offer(R.drawable.chocolatepretzelpastry1, "Miễn phí 1 Chocolate Pretzel Pastry", 699));
        return listOffer;
    }

    private void addEvents() {
        //To fragment redeem offer
        binding.lnRedeemOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionScreenActivity.this, FragmentRedeemOffer.class);
                startActivity(intent);
            }
        });

        binding.txtViewMoreOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionScreenActivity.this, FragmentRedeemOffer.class);
                startActivity(intent);
            }
        });

        //To fragment your voucher
        binding.lnYourVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionScreenActivity.this, FragmentYourVoucher.class);
                startActivity(intent);
            }
        });

        binding.txtViewMoreVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionScreenActivity.this, FragmentYourVoucher.class);
                startActivity(intent);
            }
        });

        binding.btnApDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNhapMaKhuyenMai.getText().toString().trim().isEmpty()){
                    Toast.makeText(PromotionScreenActivity.this, "Bạn chưa nhập mã khuyến mãi!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(PromotionScreenActivity.this, "Áp dụng mã thành công", Toast.LENGTH_SHORT).show();
                //Binding sang trang Order
            }
        });
    }

}