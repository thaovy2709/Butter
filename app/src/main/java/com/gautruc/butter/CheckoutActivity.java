package com.gautruc.butter;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.adapter.productCheckoutAdapter;
import com.gautruc.adapter.suggestedItemCheckoutAdapter;
import com.gautruc.butter.databinding.ActivityCheckoutBinding;
import com.gautruc.model.productCheckout;
import com.gautruc.model.suggestedItemCheckout;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_EDIT = 10;
    private static final int REQUEST_PAYMENT = 123;
    ActivityCheckoutBinding binding;
    productCheckoutAdapter adapter;
    suggestedItemCheckoutAdapter suggested;
    RecyclerView rcv_checkoutItem, rcv_suggestItem;
    ArrayList<suggestedItemCheckout> suggestedItemCheckouts;
    ArrayList<productCheckout> itemCheckout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_checkout);

        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        rcv_checkoutItem = findViewById(R.id.rcv_checkoutItem);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcv_checkoutItem.setLayoutManager(linearLayoutManager);

        rcv_suggestItem = findViewById(R.id.rcv_suggestItem);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcv_suggestItem.setLayoutManager(linearLayoutManager2);

        addData();
        addEvent();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //gửi dữ liệu address
        if(requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK && data != null){
            String str = data.getStringExtra("new address");
            binding.txtAddress.setText(str);
        }
        //gửi dữ liệu payment method
        if(requestCode == REQUEST_PAYMENT && resultCode == RESULT_FIRST_USER && data != null){
            String str = data.getStringExtra("payment");
            binding.txtPaymentMethod.setText(str);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void addEvent() {
        //thay đổi địa điểm
        binding.txtChangeMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, ChooseAddressCheckout.class);
                startActivityForResult(intent, REQUEST_CODE_EDIT);
            }
        });


        //chọn voucher
        binding.llVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, VoucherCheckoutFragment.class);
                startActivity(intent);
            }
        });



        binding.btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, MenuScreenWithCartActivity.class);
                startActivity(intent);
            }
        });

        //More payment
        binding.llPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, PaymentMethodFragment.class);
                startActivityForResult(intent, REQUEST_PAYMENT);
            }
        });

//Bấm đặt hàng
        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Diaglog
                Dialog dialog = new Dialog(CheckoutActivity.this);
                dialog.setContentView(R.layout.dialog_checkout_success);

                Button btn_trackOrder = dialog.findViewById(R.id.btn_trackOrder);
                btn_trackOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Intent tới trang Ongoing order
                        Intent intent = new Intent(CheckoutActivity.this, OnGoingOrderActivity.class);
                        startActivity(intent);
                    }
                });

                Button btn_continue = dialog.findViewById(R.id.btn_continue);
                btn_continue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Intent homepage
                        Intent intent = new Intent(CheckoutActivity.this, HomepageActivity.class);
                        startActivity(intent);
                    }
                });

                dialog.show();
            }
        });

        binding.imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void addData() {
        //sản phẩm đã chọn
        itemCheckout = new ArrayList<>();
        itemCheckout.add(new productCheckout(R.drawable.dailycookie, "Daily Cookie", 70000, 80000, 2));
        itemCheckout.add(new productCheckout(R.drawable.cookieoatmeal1, "Cookie Oatmeal", 40000, 50000, 1));

        adapter = new productCheckoutAdapter(this, itemCheckout, this);

        rcv_checkoutItem.setAdapter(adapter);

        //sản phẩm gợi ý
        suggestedItemCheckouts = new ArrayList<>();
        suggestedItemCheckouts.add(new suggestedItemCheckout(R.drawable.toastlava1, "Toast lava salted egg", 65000));
        suggestedItemCheckouts.add(new suggestedItemCheckout(R.drawable.hinh1, "Lime Cheese", 48000));
        suggestedItemCheckouts.add(new suggestedItemCheckout(R.drawable.breaddd, "Multi grain bread", 35000));

        suggested = new suggestedItemCheckoutAdapter(this, suggestedItemCheckouts, this);

        rcv_suggestItem.setAdapter(suggested);


    }


    }