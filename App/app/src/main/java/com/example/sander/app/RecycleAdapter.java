package com.example.sander.app;

import android.app.Fragment;
import android.content.Context;
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


    ArrayList<Data> ArrayData;
    GPSTracker gps;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardView;
        public TextView TextViewNames;
        public TextView TextViewCharging;
        public TextView TextViewCode;
        public TextView TextViewLatitude;
        public TextView TextViewDistance;
        public MyViewHolder(View v){
            super(v);
            Context context = v.getContext();
            gps = new GPSTracker(context);
            mCardView = (CardView) v.findViewById(R.id.card_view);
            TextViewNames = (TextView) v.findViewById(R.id.text_view_names);
            TextViewCharging = (TextView) v.findViewById(R.id.text_view_charging);
            TextViewCode = (TextView) v.findViewById(R.id.text_view_code);
            TextViewLatitude = (TextView) v.findViewById(R.id.text_view_latitude);
            TextViewDistance = (TextView) v.findViewById(R.id.text_view_distance);
        }

    }
    public RecycleAdapter(ArrayList<Data> data){
        ArrayData = data;
    }
    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_card_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){

        holder.TextViewNames.setText("Naam: " + String.valueOf(ArrayData.get(position).getNames()));
        holder.TextViewCharging.setText("Oplaadpunten: " + String.valueOf(ArrayData.get(position).getcPoints()));
        holder.TextViewCode.setText("Code: " + String.valueOf(ArrayData.get(position).getCode()));
        holder.TextViewLatitude.setText("Positie: (" + String.valueOf(ArrayData.get(position).getLatitude()) + ", " + String.valueOf(ArrayData.get(position).getLongitude())+ ")");
        if(gps.canGetLocation()) {
            holder.TextViewDistance.setText(String.valueOf(ArrayData.get(position).getDistance()) + " km");

        }
        else{
            holder.TextViewDistance.setText("Not available");
            gps.showSettingsAlert();
        }
        //holder.mImageView.setImageResource(R.drawable.ic_local_parking_black_24dp);
    }
    @Override
    public int getItemCount() { return ArrayData.size(); }
}
