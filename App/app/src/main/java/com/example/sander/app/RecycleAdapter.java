package com.example.sander.app;

import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Sander on 6-4-2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    ArrayList<String> ArrayNames;
    ArrayList<String> ArrayCharging;
    ArrayList<String> ArrayCode;
    ArrayList<String> ArrayLatitude;
    ArrayList<String> ArrayLongitude;
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardView;
        public TextView TextViewNames;
        public TextView TextViewCharging;
        public TextView TextViewCode;
        public TextView TextViewLatitude;
        public ImageView mImageView;
        public MyViewHolder(View v){
            super(v);
            mCardView = (CardView) v.findViewById(R.id.card_view);
            TextViewNames = (TextView) v.findViewById(R.id.text_view_names);
            TextViewCharging = (TextView) v.findViewById(R.id.text_view_charging);
            TextViewCode = (TextView) v.findViewById(R.id.text_view_code);
            TextViewLatitude = (TextView) v.findViewById(R.id.text_view_latitude);

        }

    }
    public RecycleAdapter(ArrayList<String> names, ArrayList<String> cPoints, ArrayList<String> code, ArrayList<String> latitude, ArrayList<String> longitude){
        ArrayNames = names;
        ArrayCharging= cPoints;
        ArrayCode = code;
        ArrayLatitude = latitude;
        ArrayLongitude = longitude;
    }
    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_card_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.TextViewNames.setText("Naam: " + ArrayNames.get(position));
        holder.TextViewCharging.setText("Oplaadpunten: " + ArrayCharging.get(position));
        holder.TextViewCode.setText("Code: " + ArrayCode.get(position));
        holder.TextViewLatitude.setText("Positie: (" + ArrayLatitude.get(position) + ", " + ArrayLongitude.get(position)+ ")");
        //holder.mImageView.setImageResource(R.drawable.ic_local_parking_black_24dp);
    }
    @Override
    public int getItemCount() { return ArrayNames.size(); }
}
