package com.gautruc.butter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gautruc.butter.databinding.ActivityFragmentButterIdchoosePackageVanillaBinding;
import com.google.android.material.navigation.NavigationBarView;

public class FragmentButterIDChoosePackageVanilla extends AppCompatActivity {

    LinearLayout llBag, llBox1c, llBoxgiay6c, llBoxkieng6c;
    ImageView imvBag, imvBox1c, imvBoxgiay6c, imvBoxkieng6c, imvCookie;
    Button btnConfirmOrder, btnBack;

    ActivityFragmentButterIdchoosePackageVanillaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_butter_idchoose_package_vanilla);

        binding = ActivityFragmentButterIdchoosePackageVanillaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView imvMainCookie = (ImageView) findViewById(R.id.imv_Main);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            int step4 = bundle.getInt("step4");
            imvMainCookie.setImageResource(step4);
        }

        linkView();
        manipulateMenu();
        addEvents();
    }

    private void manipulateMenu() {
        binding.bottomNavigation.setSelectedItemId(R.id.nav_ButterId);
        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_ButterId:
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
                    case R.id.nav_Promotion:
                        startActivity(new Intent(getApplicationContext(), PromotionScreenActivity.class));
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

    private void addEvents() {
        llBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llBag.setBackgroundResource(R.drawable.choosenframe);
                llBox1c.setBackground(null);
                llBoxgiay6c.setBackground(null);
                llBoxkieng6c.setBackground(null);
                imvCookie.setImageResource(R.drawable.bag1);

                btnConfirmOrder.setBackgroundResource(R.drawable.item_checkouttag);

                btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChoosePackageVanilla.this,FragmentButterIDConfirmOrder.class);
                        intent.putExtra("step5", R.drawable.bag1);
                        startActivity(intent);
                    }
                });
            }
        });

        llBox1c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llBox1c.setBackgroundResource(R.drawable.choosenframe);
                llBag.setBackground(null);
                llBoxgiay6c.setBackground(null);
                llBoxkieng6c.setBackground(null);
                imvCookie.setImageResource(R.drawable.box1);

                btnConfirmOrder.setBackgroundResource(R.drawable.item_checkouttag);

                btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChoosePackageVanilla.this,FragmentButterIDConfirmOrder.class);
                        intent.putExtra("step5", R.drawable.box1);
                        startActivity(intent);
                    }
                });
            }
        });

        llBoxgiay6c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llBoxgiay6c.setBackgroundResource(R.drawable.choosenframe);
                llBag.setBackground(null);
                llBox1c.setBackground(null);
                llBoxkieng6c.setBackground(null);
                imvCookie.setImageResource(R.drawable.boxgiay6);

                btnConfirmOrder.setBackgroundResource(R.drawable.item_checkouttag);

                btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChoosePackageVanilla.this,FragmentButterIDConfirmOrder.class);
                        intent.putExtra("step5", R.drawable.boxgiay6);
                        startActivity(intent);
                    }
                });
            }
        });

        llBoxkieng6c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llBoxkieng6c.setBackgroundResource(R.drawable.choosenframe);
                llBag.setBackground(null);
                llBox1c.setBackground(null);
                llBoxgiay6c.setBackground(null);
                imvCookie.setImageResource(R.drawable.boxkinh6);

                btnConfirmOrder.setBackgroundResource(R.drawable.item_checkouttag);

                btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FragmentButterIDChoosePackageVanilla.this,FragmentButterIDConfirmOrder.class);
                        intent.putExtra("step5", R.drawable.boxkinh6);
                        startActivity(intent);
                    }
                });
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentButterIDChoosePackageVanilla.this,FragmentButterIDChooseCheeseVanilla.class);
                startActivity(intent);
            }
        });
        binding.imvNotification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChoosePackageVanilla.this, NotificationList.class);
                startActivity(intent);
            }
        });
        binding.imvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChoosePackageVanilla.this, FragmentSearchScreen.class);
                startActivity(intent);
            }
        });
        binding.imvWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChoosePackageVanilla.this, FavoriteDishesListScreen.class);
                startActivity(intent);
            }
        });
        binding.imvProfile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentButterIDChoosePackageVanilla.this, ProfileScreenActivity.class);
                startActivity(intent);
            }
        });

    }

    private void linkView() {
        llBag = findViewById(R.id.ll_bag1c);
        llBox1c = findViewById(R.id.ll_box1c);
        llBoxgiay6c = findViewById(R.id.ll_boxgiay6c);
        llBoxkieng6c = findViewById(R.id.ll_boxkieng6c);
        imvBag = findViewById(R.id.imv_Bag);
        imvBox1c = findViewById(R.id.imv_Box1);
        imvBoxgiay6c = findViewById(R.id.imv_PaperBox6C);
        imvBoxkieng6c = findViewById(R.id.imv_Box6c);
        imvCookie = findViewById(R.id.imv_Main);
        btnBack = findViewById(R.id.btn_back);
        btnConfirmOrder = findViewById(R.id.btn_ConfirmOrder);
    }
}