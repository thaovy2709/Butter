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
        listStoreList.add(new StoreList(R.drawable.nguyentriphuong, "Butter Nguy???n Tri Ph????ng", "143-145 Nguy???n Tri Ph????ng, Ph?????ng 8, Qu???n 5, TP. HCM", "028 3855 2430", "06h30 ??? 22h00"));
        listStoreList.add(new StoreList(R.drawable.grandview, "Butter Grand View", "SD6-1 Grand View, Nguy???n ?????c C???nh, Ph?????ng T??n Phong, Qu???n 7, TP. HCM", "028 5414 1223", "09h00 ??? 22h00"));
        listStoreList.add(new StoreList(R.drawable.hunggia, "Butter H??ng Gia", "L?? R2-24, H??ng Gia 4, 95 Phan Khi??m ??ch, Ph?????ng T??n Phong, Qu???n 7, TP. HCM", "028 5410 8152", "06h30 ??? 22h00"));
        listStoreList.add(new StoreList(R.drawable.nguyenthithap, "Butter Nguy???n Th??? Th???p", "593 Nguy???n Th??? Th???p, Ph?????ng T??n Phong, Qu???n 7, TP. HCM","028 3775 1728", "09h00 ??? 21h30"));
        listStoreList.add(new StoreList(R.drawable.vanhanhmall, "Butter V???n H???nh Mall", "F17-F18, T???ng B1, V???n H???nh Mall, s??? 11 S?? V???n H???nh, Ph?????ng 12, Qu???n 10, TP. HCM", "028 3636 6685", "08h00 ??? 22h00"));
        listStoreList.add(new StoreList(R.drawable.phanxichlong, "Butter Phan X??ch Long", "212 Phan X??ch Long, Ph?????ng 12, Qu???n Ph?? Nhu???n, TP. HCM", "028 3517 8845", "08h00 ??? 22h00"));
        listStoreList.add(new StoreList(R.drawable.vincomquangtrung, "Butter Vincom Quang Trung", "L1-11, T???ng tr???t, Vincom, 190 Quang Trung, Ph?????ng 10, Qu???n G?? V???p, TP. HCM", "028 3894 6595", "08h00 ??? 22h00"));
        return listStoreList;
    }

    private List<StoreList> getListStoreListNearest() {
        List<StoreList> listStoreList = new ArrayList<>();
        listStoreList.add(new StoreList(R.drawable.saigoncentre, "Butter Saigon Centre", "B2-14, T???ng B2, S??i G??n Centre, 65 L?? L???i, Ph?????ng B???n Ngh??, Qu???n 1, TP. HCM", "0028 3821 7219", "09h30 ??? 21h30"));
        listStoreList.add(new StoreList(R.drawable.vincom, "Butter Vincom", "B3-15A, T???ng B3, Vincom, 70-72 L?? Th??nh T??n, Ph?????ng B???n Ngh??, Qu???n 1, TP. HCM", "028 3993 9025", "08h00 ??? 22h00"));
        listStoreList.add(new StoreList(R.drawable.cantavil, "Butter Cantavil", "T???ng tr???t, Cantavil, 1 Song H??nh, Ph?????ng An Ph??, Qu???n 2, TP. HCM", "028 3993 9025", "08h00 ??? 22h00"));
        return listStoreList;
    }

}