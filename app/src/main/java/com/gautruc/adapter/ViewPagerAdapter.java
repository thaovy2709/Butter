package com.gautruc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.gautruc.butter.R;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    int[] images;
    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = layoutInflater.inflate(R.layout.item_viewpager, container, false);
        ImageView img = (ImageView) v.findViewById(R.id.imv_slider);
        img.setImageResource(images[position]);

        container.addView(v);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Image" +(position + 1), Toast.LENGTH_LONG).show();

            }
        });

        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
