package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gautruc.adapter.VoucherAdapter;
import com.gautruc.butter.databinding.ActivityFragmentYourVoucherBinding;
import com.gautruc.butter.databinding.ActivityPromotionScreenBinding;
import com.gautruc.model.Voucher;

import java.util.ArrayList;
import java.util.List;

public class FragmentYourVoucher extends AppCompatActivity {

    ActivityFragmentYourVoucherBinding binding;
    RecyclerView rcvVoucher;
    VoucherAdapter voucherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_your_voucher);
        binding = ActivityFragmentYourVoucherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        rcvVoucher = findViewById(R.id.rcvVoucher);
        voucherAdapter = new VoucherAdapter(this);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvVoucher.setLayoutManager(linearLayoutManager1);

        voucherAdapter.setData(getListVoucher());
        rcvVoucher.setAdapter(voucherAdapter);

        addEvents();
    }

    private void addEvents() {
        binding.imvBackFromYourVoucherToPromotionScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentYourVoucher.this, PromotionScreenActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Voucher> getListVoucher() {
        List<Voucher> listVoucher = new ArrayList<>();
        listVoucher.add(new Voucher(R.drawable.promotion1));
        listVoucher.add(new Voucher(R.drawable.promotion2));
        listVoucher.add(new Voucher(R.drawable.promotion3));
        listVoucher.add(new Voucher(R.drawable.promotion4));
        listVoucher.add(new Voucher(R.drawable.promotion5));
        listVoucher.add(new Voucher(R.drawable.promotion6));
        listVoucher.add(new Voucher(R.drawable.promotion7));
        listVoucher.add(new Voucher(R.drawable.promotion8));
        listVoucher.add(new Voucher(R.drawable.promotion9));
        listVoucher.add(new Voucher(R.drawable.promotion10));


        return listVoucher;
    }
}