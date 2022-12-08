package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.gautruc.adapter.voucherCheckoutAdapter;
import com.gautruc.butter.databinding.FragmentVoucherCheckoutBinding;
import com.gautruc.model.voucherCheckout;

import java.util.ArrayList;

public class VoucherCheckoutFragment extends AppCompatActivity {

    FragmentVoucherCheckoutBinding binding;
    ImageView imv_voucherbackcheckout;
    ListView lv_voucher;
    voucherCheckoutAdapter adapter;
    ArrayList<voucherCheckout> voucherCheckouts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_voucher_checkout);

        binding = FragmentVoucherCheckoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
        chooseVoucher();

    }

    private void addEvents() {
        binding.imvVoucherbackcheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btnApDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.edtVoucherCode.getText().toString().trim().isEmpty()){
                    Toast.makeText(VoucherCheckoutFragment.this, "Bạn chưa nhập mã khuyến mãi!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(VoucherCheckoutFragment.this, "Áp dụng mã thành công", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void loadData() {
        voucherCheckouts = new ArrayList<>();

        voucherCheckouts.add(new voucherCheckout(R.drawable.promotion1));
        voucherCheckouts.add(new voucherCheckout(R.drawable.promotion2));
        voucherCheckouts.add(new voucherCheckout(R.drawable.promotion3));
        voucherCheckouts.add(new voucherCheckout(R.drawable.promotion4));

        adapter = new voucherCheckoutAdapter(VoucherCheckoutFragment.this, R.layout.item_voucher_checkout, voucherCheckouts);


        binding.lvVoucher.setAdapter(adapter);
    }


    private void chooseVoucher() {
        binding.lvVoucher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                voucherCheckout voucher = (voucherCheckout) adapter.getItem(position);
                Toast.makeText(VoucherCheckoutFragment.this, "Bạn đã áp dụng voucher thành công!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }




}