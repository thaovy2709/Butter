package com.gautruc.butter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.adapter.OfferAdapter;
import com.gautruc.adapter.VoucherAdapter;
import com.gautruc.butter.databinding.ActivityPromotionScreenBinding;
import com.gautruc.model.Offer;
import com.gautruc.model.Voucher;
import com.google.android.material.navigation.NavigationBarView;

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

        manipulateMenu();

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

    private void manipulateMenu() {
        binding.bottomNavigation.setSelectedItemId(R.id.nav_Promotion);
        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_Promotion:
                        return true;
                    case R.id.nav_Homepage:
                        startActivity(new Intent(getApplicationContext(), HomepageActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_Menu:
                        startActivity(new Intent(getApplicationContext(), MenuScreenActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_ButterId:
                        startActivity(new Intent(getApplicationContext(), ActivityButterID.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_Order:
                        startActivity(new Intent(getApplicationContext(), OngoingScreenActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                }

                return false;
            }
        });
    }

    private List<Voucher> getListVoucher() {
        List<Voucher> listVoucher = new ArrayList<>();
        listVoucher.add(new Voucher(R.drawable.promotion3));
        listVoucher.add(new Voucher(R.drawable.promotion6));
        listVoucher.add(new Voucher(R.drawable.promotion1));

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

                Intent intent = new Intent(PromotionScreenActivity.this, MenuScreenActivity.class);
                startActivity(intent);
            }
        });

        binding.imvNotification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionScreenActivity.this, NotificationList.class);
                startActivity(intent);
            }
        });
        binding.imvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionScreenActivity.this, FragmentSearchScreen.class);
                startActivity(intent);
            }
        });
        binding.imvProfile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionScreenActivity.this, ProfileScreenActivity.class);
                startActivity(intent);
            }
        });
        binding.imvWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionScreenActivity.this, FavoriteDishesListScreen.class);
                startActivity(intent);
            }
        });
        binding.llExchangePoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionScreenActivity.this, PointExchangeActivity.class);
                startActivity(intent);
            }
        });
        binding.llBenefitPromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionScreenActivity.this, FragementBenefitPromotion.class);
                startActivity(intent);
            }
        });
    }

}