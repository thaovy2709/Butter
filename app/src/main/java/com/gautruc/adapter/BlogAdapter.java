package com.gautruc.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gautruc.butter.BlogDetailActivity;
import com.gautruc.butter.R;
import com.gautruc.model.Blog;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder>{

    private Context mContext;
    private List<Blog> mListBlog;

    public BlogAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Blog> list){
        this.mListBlog = list;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blog,parent, false);
        return new BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
        Blog blog = mListBlog.get(position);
        if (blog == null) {
            return;
        }
        holder.imvblog.setImageResource(blog.getResourceId());
        holder.txtnameBlog.setText(blog.getNameBlog());
        holder.txtdetailBlog.setText(blog.getDetailBlog());

        holder.layout_itemBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BlogDetailActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListBlog != null) {
            return mListBlog.size();
        }

        return 0;
    }

    public class BlogViewHolder extends RecyclerView.ViewHolder{

        private ImageView imvblog;
        private TextView txtnameBlog, txtdetailBlog;
        LinearLayout layout_itemBlog;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);

            imvblog = itemView.findViewById(R.id.imvblog);
            txtdetailBlog = itemView.findViewById(R.id.txtdetailBlog);
            txtnameBlog = itemView.findViewById(R.id.txtnameBlog);
            layout_itemBlog = itemView.findViewById(R.id.layout_itemBlog);
        }
    }
}
