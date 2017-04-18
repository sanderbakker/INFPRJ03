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
        super(context, android.R.layout.simple_list_item_1, items);
        this.context = context;
    }
    public class ViewHolder{
        TextView titleText;
        TextView numberTextGood;
        TextView numberTextAverage;
        TextView numberTextBad;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        Points item = (Points)getItem(position);
        View viewToUse = null;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            if(useList){
                viewToUse = mInflater.inflate(R.layout.list_item, null);
            }
            holder = new ViewHolder();
            holder.titleText = (TextView)viewToUse.findViewById(R.id.hoods);
            holder.numberTextGood = (TextView) viewToUse.findViewById(R.id.number_good);
            holder.numberTextAverage = (TextView) viewToUse.findViewById(R.id.number_average);
            holder.numberTextBad = (TextView) viewToUse.findViewById(R.id.number_view);
            viewToUse.setTag(holder);
        } else {
            viewToUse = convertView;
            holder = (ViewHolder) viewToUse.getTag();
        }
        holder.titleText.setText(item.getHoodName() + " (Wijk " + item.getHoodId() + ")");
        // first clear all text-views
        holder.numberTextGood.setText("");
        holder.numberTextAverage.setText("");
        holder.numberTextBad.setText("");

        // now set the value in the proper one
        if(item.getPoints() >= 4.0){
            holder.numberTextGood.setText(String.valueOf(item.getPoints()) + "/5.0");
        } else if(item.getPoints() < 4.0 && item.getPoints() > 3.0){
            holder.numberTextAverage.setText(String.valueOf(item.getPoints()) + "/5.0");
        } else if(item.getPoints() < 3.0){
            holder.numberTextBad.setText(String.valueOf(item.getPoints()) + "/5.0");
        }
        return viewToUse;
    }
}
