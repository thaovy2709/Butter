package com.gautruc.butter;

import static com.gautruc.butter.R.id.rcv_blog;
import static com.gautruc.butter.R.id.rcv_noti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.gautruc.adapter.NotiAdapter;
import com.gautruc.butter.databinding.ActivityNotificationListBinding;
import com.gautruc.model.Blog;
import com.gautruc.model.Noti;

import java.util.ArrayList;
import java.util.List;

public class NotificationList extends AppCompatActivity {

    ActivityNotificationListBinding binding;
    private RecyclerView rcvNoti;
    private NotiAdapter notiAdapter;
    ArrayList<Noti> notiList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_notification_list);

        binding = ActivityNotificationListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.rcvNoti.setLayoutManager(linearLayoutManager);

        addData();
        addEvents();
    }

    private void addEvents() {
        binding.imvNotibackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addData() {

        notiList = new ArrayList<>();

        notiList.add(new Noti(R.drawable.donhangxuli,"Đơn hàng xử lí", "Bạn đã đặt hàng thành công! Hiện, đơn hàng đang được chuẩn bị và sẽ giao đến bạn trước 5 giờ chiều" , "14/11/22" ));
        notiList.add(new Noti(R.drawable.stress,"Giải stress với bánh ngọt?", "Bài blog “Bánh ngọt có thể làm giảm stress?” đã được cập nhật trên app Butter. Cùng tìm hiểu tác dụng giảm stress của bánh ngọt nhé!", "12/11/22" ));
        notiList.add(new Noti(R.drawable.momo,"Ví MoMo tặng mã 50k", "Hiệu lực đến hết 30/11/2022, ví MoMo giảm đến 50k cho đơn từ 50k. Áp dụng cho đơn thanh toán qua ví điện tử MoMo.", "10/11/22" ));
        notiList.add(new Noti(R.drawable.notibrioche,"Thế giới bánh mì Brioche", "Bài blog “Giới thiệu về thế giới bánh mì Brioche” đã được cập nhật trên app Butter. Đọc để hiểu thêm về Brioche bạn nha.", "08/11/22" ));
        notiList.add(new Noti(R.drawable.notiflour,"Tất tần tật về cake flour", "Bài blog “Tất tần tật về cake flour” đã được cập nhật trên app Butter. Tất cả điều bí ẩn về cake flour đều được bật mí ở đây đó!", "04/11/22" ));
        notiList.add(new Noti(R.drawable.notihalloween,"Halloween giảm ngay 10%", "Hiệu lực đến hết 30/10/2022, Halloween cùng “bơ”, chẳng sợ bơ vơ. Giảm ngay 10% cho mọi hóa đơn.", "14/11/22" ));
        notiList.add(new Noti(R.drawable.notibutterhello,"Chào bạn mới", "Lần đầu đến với Butter, Butter mong bạn có thật nhiều niềm vui nhé! Hãy trải nghiệm Butter ngay hôm nay.", "11/11/22" ));

        notiAdapter = new NotiAdapter(this, notiList, this);

        binding.rcvNoti.setAdapter(notiAdapter);
    }

}