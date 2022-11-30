package com.gautruc.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.gautruc.butter.R;
import com.gautruc.model.sliderBanner;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

import kotlin.jvm.internal.Lambda;

public class sliderAdapter extends PagerAdapter{

    private Context context;
    private List<sliderBanner> sliderBannerList;

    public sliderAdapter(Context context, List<sliderBanner> sliderBannerList) {
        this.context = context;
        this.sliderBannerList = sliderBannerList;
    }

    @Override
    public int getCount() {
        if(sliderBannerList != null){
            return sliderBannerList.size();
        }
        return 0;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_sliderbanner, container, false);
        ImageView imv_banner = view.findViewById(R.id.imv_banner);

        sliderBanner banner = sliderBannerList.get(position);
        if(banner != null){
            Glide.with(context).load(banner.getResourceId()).into(imv_banner);
        }

        //Add view to viewgroup
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //remove view
        container.removeView((android.view.View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
