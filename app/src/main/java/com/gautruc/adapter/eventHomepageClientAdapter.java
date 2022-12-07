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

import com.gautruc.butter.FragementEventNoel;
import com.gautruc.butter.LoginActivity;
import com.gautruc.butter.R;
import com.gautruc.model.eventHomepage;
import com.gautruc.model.eventHomepageClient;

import java.util.List;

public class eventHomepageClientAdapter extends BaseAdapter {
    Activity activity;
    int event_layout;
    List<eventHomepageClient> eventHomepageClientList;

    public eventHomepageClientAdapter(Activity activity, int event_layout, List<eventHomepageClient> eventHomepageClientList) {
        this.activity = activity;
        this.event_layout = event_layout;
        this.eventHomepageClientList = eventHomepageClientList;
    }

    @Override
    public int getCount() {
        return eventHomepageClientList.size();
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
        eventHomepageClientAdapter.ViewHolder holder;

        if(convertView == null){
            holder = new eventHomepageClientAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(this.event_layout, null);

            holder.imv_promotion = convertView.findViewById(R.id.imv_promotion);
            holder.txt_promotion = convertView.findViewById(R.id.txt_promotion);
            holder.layout_homepage_event = convertView.findViewById(R.id.layout_homepage_event);

            convertView.setTag(holder);
        }

        else {
            holder = (eventHomepageClientAdapter.ViewHolder) convertView.getTag();
        }

        eventHomepageClient eventhomepageclient = eventHomepageClientList.get(position);
        holder.imv_promotion.setImageResource(eventhomepageclient.getPhoto());
        holder.txt_promotion.setText(eventhomepageclient.getDescription());

        holder.layout_homepage_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    public static  class ViewHolder{
        ImageView imv_promotion;
        TextView txt_promotion;
        LinearLayout layout_homepage_event;
    }
}
