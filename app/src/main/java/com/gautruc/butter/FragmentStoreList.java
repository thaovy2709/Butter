package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gautruc.adapter.StoreListAdapter;
import com.gautruc.butter.databinding.ActivityFragmentStoreListBinding;
import com.gautruc.model.StoreList;
import com.gautruc.model.Voucher;

import java.util.ArrayList;
import java.util.List;

public class FragmentStoreList extends AppCompatActivity {

    ActivityFragmentStoreListBinding binding;
    RecyclerView rcvStoreListNearest;
    RecyclerView rcvStoreListOthers;
    StoreListAdapter storeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_store_list);

        binding = ActivityFragmentStoreListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imvBackFromStoreListToProfileScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Store List Nearest
        rcvStoreListNearest = findViewById(R.id.rcv_storeListNearest);
        storeListAdapter = new StoreListAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvStoreListNearest.setLayoutManager(linearLayoutManager);

        storeListAdapter.setData(getListStoreListNearest());
        rcvStoreListNearest.setAdapter(storeListAdapter);

        //StoreListOthers
        rcvStoreListOthers = findViewById(R.id.rcv_storeListOthers);
        storeListAdapter = new StoreListAdapter(this);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvStoreListOthers.setLayoutManager(linearLayoutManager1);

        storeListAdapter.setData(getListStoreListOthers());
        rcvStoreListOthers.setAdapter(storeListAdapter);
    }

    private List<StoreList> getListStoreListOthers() {
        List<StoreList> listStoreList = new ArrayList<>();
        listStoreList.add(new StoreList(R.drawable.nguyentriphuong, "Butter Nguyễn Tri Phương", "143-145 Nguyễn Tri Phương, Phường 8, Quận 5, TP. HCM", "028 3855 2430", "06h30 – 22h00"));
        listStoreList.add(new StoreList(R.drawable.grandview, "Butter Grand View", "SD6-1 Grand View, Nguyễn Đức Cảnh, Phường Tân Phong, Quận 7, TP. HCM", "028 5414 1223", "09h00 – 22h00"));
        listStoreList.add(new StoreList(R.drawable.hunggia, "Butter Hưng Gia", "Lô R2-24, Hưng Gia 4, 95 Phan Khiêm Ích, Phường Tân Phong, Quận 7, TP. HCM", "028 5410 8152", "06h30 – 22h00"));
        listStoreList.add(new StoreList(R.drawable.nguyenthithap, "Butter Nguyễn Thị Thập", "593 Nguyễn Thị Thập, Phường Tân Phong, Quận 7, TP. HCM","028 3775 1728", "09h00 – 21h30"));
        listStoreList.add(new StoreList(R.drawable.vanhanhmall, "Butter Vạn Hạnh Mall", "F17-F18, Tầng B1, Vạn Hạnh Mall, số 11 Sư Vạn Hạnh, Phường 12, Quận 10, TP. HCM", "028 3636 6685", "08h00 – 22h00"));
        listStoreList.add(new StoreList(R.drawable.phanxichlong, "Butter Phan Xích Long", "212 Phan Xích Long, Phường 12, Quận Phú Nhuận, TP. HCM", "028 3517 8845", "08h00 – 22h00"));
        listStoreList.add(new StoreList(R.drawable.vincomquangtrung, "Butter Vincom Quang Trung", "L1-11, Tầng trệt, Vincom, 190 Quang Trung, Phường 10, Quận Gò Vấp, TP. HCM", "028 3894 6595", "08h00 – 22h00"));
        return listStoreList;
    }

    private List<StoreList> getListStoreListNearest() {
        List<StoreList> listStoreList = new ArrayList<>();
        listStoreList.add(new StoreList(R.drawable.saigoncentre, "Butter Saigon Centre", "B2-14, Tầng B2, Sài Gòn Centre, 65 Lê Lợi, Phường Bến Nghé, Quận 1, TP. HCM", "0028 3821 7219", "09h30 – 21h30"));
        listStoreList.add(new StoreList(R.drawable.vincom, "Butter Vincom", "B3-15A, Tầng B3, Vincom, 70-72 Lê Thánh Tôn, Phường Bến Nghé, Quận 1, TP. HCM", "028 3993 9025", "08h00 – 22h00"));
        listStoreList.add(new StoreList(R.drawable.cantavil, "Butter Cantavil", "Tầng trệt, Cantavil, 1 Song Hành, Phường An Phú, Quận 2, TP. HCM", "028 3993 9025", "08h00 – 22h00"));
        return listStoreList;
    }

}