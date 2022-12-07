package com.gautruc.butter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.gautruc.adapter.OrderAdapter;
import com.gautruc.butter.databinding.ActivityOngoingScreenBinding;
import com.gautruc.model.order;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class OngoingScreenActivity extends AppCompatActivity {

    Button btnOngoing,btnDelivered;
    ListView lvOrder;

    ArrayList<order> arrayList;
    OrderAdapter adapter;

    ActivityOngoingScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_ongoing_screen);

        binding = ActivityOngoingScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        linkView();
        manipulateMenu();
        ongoing();
        addEvents();

        lvOrder.setAdapter(adapter);
    }

    private void manipulateMenu() {
        binding.bottomNavigation.setSelectedItemId(R.id.nav_Order);
        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_Order:
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
                    case R.id.nav_Promotion:
                        startActivity(new Intent(getApplicationContext(), PromotionScreenActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                }

                return false;
            }
        });
    }

    private void ongoing() {
        arrayList = new ArrayList<>();
        arrayList.add(new order("2 Bánh Raisin bread, 1 Cookie Oatmeal", "Đang chuẩn bị",100000f));
        adapter = new OrderAdapter(this,0,arrayList);

        lvOrder.setAdapter(adapter);

        lvOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(OngoingScreenActivity.this,OnGoingOrderActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addEvents() {
        btnOngoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ongoing();
                    arrayList = new ArrayList<>();
                    arrayList.add(new order("2 Bánh Raisin bread, 1 Cookie Oatmeal", "Đang chuẩn bị",100000f));
                    adapter = new OrderAdapter(OngoingScreenActivity.this,0,arrayList);

                    lvOrder.setAdapter(adapter);


                btnDelivered.setBackgroundResource(R.drawable.graybutton);
                btnOngoing.setBackgroundResource(R.drawable.yellowbutton);
                btnDelivered.setTextColor(OngoingScreenActivity.this.getResources().getColor(R.color.neutral_4));
                btnOngoing.setTextColor(OngoingScreenActivity.this.getResources().getColor(R.color.primary_5));

                lvOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(OngoingScreenActivity.this,OnGoingOrderActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btnDelivered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                delivered();

                arrayList = new ArrayList<>();
                arrayList.add(new order("1 Cookie Oatmeal - 2 Daily cookie", "11:11 - 12/11/1022", 110000f));
                arrayList.add(new order("Croissant trứng muối", "16:49 - 25/10/1022", 40000f));
                arrayList.add(new order("Raisin Bread", "18:23 - 23/10/1022", 35000f));
                adapter = new OrderAdapter(OngoingScreenActivity.this,0, arrayList);
                lvOrder.setAdapter(adapter);

                btnDelivered.setBackgroundResource(R.drawable.yellowbutton);
                btnOngoing.setBackgroundResource(R.drawable.graybutton);
                btnDelivered.setTextColor(OngoingScreenActivity.this.getResources().getColor(R.color.primary_5));
                btnOngoing.setTextColor(OngoingScreenActivity.this.getResources().getColor(R.color.neutral_4));

                lvOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(OngoingScreenActivity.this,OrderInfoScreen.class);
                        startActivity(intent);
                    }
                });
            }
        });

//        lvOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(OngoingScreenActivity.this,OrderInfoScreen.class);
//                startActivity(intent);
//            }
//        });
    }


//    private void delivered() {
//        arrayList = new ArrayList<>();
//        arrayList.add(new order("1 Cookie Oatmeal - 2 Daily cookie", "11:11 - 12/11/1022", 110000f));
//        arrayList.add(new order("Croissant trứng muối", "16:49 - 25/10/1022", 40000f));
//        arrayList.add(new order("Raisin Bread", "18:23 - 23/10/1022", 35000f));
//        adapter = new OrderAdapter(this,0, arrayList);
//        lvOrder.setAdapter(adapter);
//    }



    private void linkView() {
        btnOngoing = (Button) findViewById(R.id.btn_ongoing);
        btnDelivered = (Button) findViewById(R.id.btn_delivered);
        lvOrder = (ListView) findViewById(R.id.lv_orderHistory);
    }
}