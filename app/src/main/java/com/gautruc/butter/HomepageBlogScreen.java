package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gautruc.adapter.BlogAdapter;
import com.gautruc.butter.databinding.ActivityHomepageBlogScreenBinding;
import com.gautruc.model.Blog;

import java.util.ArrayList;
import java.util.List;

public class HomepageBlogScreen extends AppCompatActivity {

    private RecyclerView rcvBlog;
    private BlogAdapter blogAdapter;


    ActivityHomepageBlogScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_homepage_blog_screen);

        binding = ActivityHomepageBlogScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        rcvBlog = findViewById(R.id.rcv_blog);
        blogAdapter = new BlogAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvBlog.setLayoutManager(linearLayoutManager);

        blogAdapter.setData(getListBlog());
        rcvBlog.setAdapter(blogAdapter);

        addEvent();
    }

    private void addEvent() {
        binding.imvBlogback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageBlogScreen.this, HomepageActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Blog> getListBlog() {
        List<Blog> list = new ArrayList<>();
        list.add(new Blog(R.drawable.breadblog1, "Bánh ngọt làm giảm stress", "Cuộc sống ngày này của thế hệ Gen Z có rất nhiều đều cần phải lo lắng, bận tâm...\n"));
        list.add(new Blog(R.drawable.breadblog2, "Tất tần tật về cake flour", "Bột bánh bông lan (cake flour) là loại bột có kết cấu mềm thường được sử dụng trong làm bánh, đặc biệt là các loại bánh ngọt..."));
        list.add(new Blog(R.drawable.breadblog3, "Câu chuyện về chiếc bánh mì Baguette", "Tản bộ ở Paris vào buổi sáng, bạn sẽ thấy nhiều người bước ra từ các cửa hàng địa phương, trên tay là những chiếc bánh mì..."));
        list.add(new Blog(R.drawable.breadblog4, "Các loại bánh Mousse phổ biến", "Mousse là một loại bánh có lớp kem mát lạnh mềm mịn, tan trong miệng. Với ý nghĩa là \"bọt\" trong tiếng Pháp...\n"));
        list.add(new Blog(R.drawable.breadblog5, "3 loại bánh ngọt phổ biến nhất", "Bánh ngọt được ưa chuộng vì nhiều lý do, trong đó quan trọng nhất là sự đa dạng của nó...\n"));
        list.add(new Blog(R.drawable.breadblog6, "Sự khác nhau Cakes và Pastry", "Brioche là một loại bánh mì phong phú và thơm ngon với vị ngọt ngào và thơm mùi bơ...\n"));
        list.add(new Blog(R.drawable.breadblog1, "Giới thiệu về thế giới bánh Brioche", "Brioche là một loại bánh mì phong phú và thơm ngon với vị ngọt ngào và thơm mùi bơ...\n"));

        return list;
    }
}