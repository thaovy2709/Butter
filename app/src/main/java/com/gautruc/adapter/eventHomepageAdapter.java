package com.gautruc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gautruc.butter.R;
import com.gautruc.model.eventHomepage;

import java.util.List;

public class eventHomepageAdapter extends BaseAdapter {

    Activity activity;
    int event_layout;
    List<eventHomepage> eventHomepageList;

    public eventHomepageAdapter(Activity activity, int event_layout, List<eventHomepage> eventHomepageList) {
        this.activity = activity;
        this.event_layout = event_layout;
        this.eventHomepageList = eventHomepageList;
    }

    @Override
    public int getCount() {
        return eventHomepageList.size();
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
        eventHomepageAdapter.ViewHolder holder;

        if(convertView == null){
            holder = new eventHomepageAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(this.event_layout, null);

            holder.imv_promotion = convertView.findViewById(R.id.imv_promotion);
            holder.txt_promotion = convertView.findViewById(R.id.txt_promotion);

            convertView.setTag(holder);
        }

        else {
            holder = (eventHomepageAdapter.ViewHolder) convertView.getTag();
        }

        eventHomepage eventhomepage = eventHomepageList.get(position);
        holder.imv_promotion.setImageResource(eventhomepage.getPhoto());
        holder.txt_promotion.setText(eventhomepage.getDescription());


        return convertView;

    }

    public static  class ViewHolder{
        ImageView imv_promotion;
        TextView txt_promotion;
    }
}
