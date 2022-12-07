package com.gautruc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gautruc.butter.BlogDetailActivity;
import com.gautruc.butter.LoginActivity;
import com.gautruc.butter.R;
import com.gautruc.model.blogHomepage;

import java.util.List;

public class blogHomepageAdapter extends BaseAdapter {

    Activity activity;
    int blog_layout;
    List<blogHomepage> blogHomepageList;

    public blogHomepageAdapter(Activity activity, int blog_layout, List<blogHomepage> blogHomepageList) {
        this.activity = activity;
        this.blog_layout = blog_layout;
        this.blogHomepageList = blogHomepageList;
    }

    @Override
    public int getCount() {
        return blogHomepageList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(this.blog_layout, null);

            holder.imv_blog = convertView.findViewById(R.id.imv_blog);
            holder.txt_blogTime = convertView.findViewById(R.id.txt_blogTime);
            holder.txt_blogName = convertView.findViewById(R.id.txt_blogName);
            holder.txt_blogDes = convertView.findViewById(R.id.txt_blogDes);
            holder.layout_homepage_blog = convertView.findViewById(R.id.layout_homepage_blog);

            convertView.setTag(holder);

        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        blogHomepage bloghomepage = blogHomepageList.get(position);
        holder.imv_blog.setImageResource(bloghomepage.getPhoto());
        holder.txt_blogTime.setText(bloghomepage.getDate());
        holder.txt_blogName.setText(bloghomepage.getTitle());
        holder.txt_blogDes.setText(bloghomepage.getDescription());

        holder.layout_homepage_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BlogDetailActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    public static  class ViewHolder{
        ImageView imv_blog;
        TextView txt_blogTime, txt_blogName, txt_blogDes;
        LinearLayout layout_homepage_blog;
    }
}
