package com.example.sander.app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sander on 15-4-2017.
 */

public class ListAdapter extends ArrayAdapter<Points> {
    private Context context;
    private boolean useList = true;
    public ListAdapter(Context context, ArrayList items){
        //sets layout of the list
        super(context, android.R.layout.simple_list_item_1, items);
        this.context = context;
    }
    public class ViewHolder{
        //creates holder
        TextView titleText;
        TextView numberText45;
        TextView numberText34;
        TextView numberText23;
        TextView numberText12;
        TextView numberText01;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        Points item = (Points)getItem(position);
        View viewToUse = null;
        //binds all the holders
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            if(useList){
                viewToUse = mInflater.inflate(R.layout.list_item, null);
            }
            holder = new ViewHolder();
            holder.titleText = (TextView)viewToUse.findViewById(R.id.hoods);
            holder.numberText45 = (TextView) viewToUse.findViewById(R.id.rating45);
            holder.numberText34 = (TextView) viewToUse.findViewById(R.id.rating34);
            holder.numberText23 = (TextView) viewToUse.findViewById(R.id.rating23);
            holder.numberText12 = (TextView) viewToUse.findViewById(R.id.rating12);
            holder.numberText01 = (TextView) viewToUse.findViewById(R.id.rating01);
            viewToUse.setTag(holder);
        } else {
            viewToUse = convertView;
            holder = (ViewHolder) viewToUse.getTag();
        }
        holder.titleText.setText(item.getHoodName() + " (Wijk " + item.getHoodId() + ")");
        // first clear all text-views
        holder.numberText45.setText("");
        holder.numberText34.setText("");
        holder.numberText23.setText("");
        holder.numberText12.setText("");
        holder.numberText01.setText("");

        // now set the value in the proper one
        if(item.getPoints() >= 4.0){
            holder.numberText45.setText(String.valueOf(item.getPoints()) + "/5.0");
        } else if(item.getPoints() < 4.0 && item.getPoints() >= 3.0){
            holder.numberText34.setText(String.valueOf(item.getPoints()) + "/5.0");
        } else if(item.getPoints() < 3.0 && item.getPoints() >= 2.0) {
            holder.numberText23.setText(String.valueOf(item.getPoints()) + "/5.0");
        } else if(item.getPoints() < 2.0 && item.getPoints() >= 1.0) {
            holder.numberText12.setText(String.valueOf(item.getPoints()) + "/5.0");
        } else if(item.getPoints() < 1.0 && item.getPoints() >= 0.0) {
            holder.numberText01.setText(String.valueOf(item.getPoints()) + "/5.0");
        }
        return viewToUse;
    }
}
