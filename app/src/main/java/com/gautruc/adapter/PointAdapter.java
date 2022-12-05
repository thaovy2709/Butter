package com.gautruc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gautruc.butter.R;
import com.gautruc.model.point;

import java.util.ArrayList;
import java.util.List;

public class PointAdapter extends BaseAdapter {

    Activity activity;
    int layout;
    List<point> pointList;

    @Override
    public int getCount() {
        return pointList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.layout, null);

            holder.txttime = view.findViewById(R.id.txttime);
            holder.txtorderID = view.findViewById(R.id.txtorderID);
            holder.txtnumberPoint = view.findViewById(R.id.txtnumberPoint);

            view.setTag(holder);

        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        point points = pointList.get(i);
        holder.txttime.setText(points.getTime());
        holder.txtorderID.setText(points.getOrderID());
        holder.txtnumberPoint.setText(String.valueOf(points.getNumberpoint()));


        return view;
    }

    public PointAdapter(Activity activity, int layout, List<point> pointList) {
        this.activity = activity;
        this.layout = layout;
        this.pointList = pointList;
    }

    public static class ViewHolder{
        TextView txttime, txtorderID, txtnumberPoint;
    }
}
