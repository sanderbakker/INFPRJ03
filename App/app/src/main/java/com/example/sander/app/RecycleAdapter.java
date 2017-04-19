package com.example.sander.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Sander on 6-4-2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> implements Filterable{


    ArrayList<Data> ArrayData;
    ArrayList<Data> FilteredData;
    GPSTracker gps;
    Integer count_gps = 0;


    public Filter getFilter() {
        //creates a new filter
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence text) {
                FilterResults returnList = new FilterResults();
                ArrayList<Data> results = new ArrayList<Data>();
                if (FilteredData == null)
                    FilteredData = ArrayData;
                //check if there is a query to check on
                if (text != null) {
                    //check if list contains items
                    if (FilteredData != null & FilteredData.size() > 0) {
                        for (final Data checkData : FilteredData) {
                            if (checkData.getNames().toLowerCase().contains(text.toString().toLowerCase()))
                                results.add(checkData);
                        }
                    }
                    // returns the values of the results
                    returnList.values = results;
                }
                // returns result
                return returnList;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                ArrayData = (ArrayList<Data>) results.values;
                //tells the app the dataset (array) has changed
                notifyDataSetChanged();

            }
        };
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // creates holders
        public CardView mCardView;
        public TextView TextViewNames;
        public TextView TextViewCharging;
        public TextView TextViewCode;
        public TextView TextViewLatitude;
        public TextView TextViewDistance;

        public MyViewHolder(View v){

            super(v);
            Context context = v.getContext();
            v.setOnClickListener(this);
            gps = new GPSTracker(context);
            //binds all the view to an item in xml
            mCardView = (CardView) v.findViewById(R.id.card_view);
            TextViewNames = (TextView) v.findViewById(R.id.text_view_names);
            TextViewCharging = (TextView) v.findViewById(R.id.text_view_charging);
            TextViewCode = (TextView) v.findViewById(R.id.text_view_code);
            TextViewLatitude = (TextView) v.findViewById(R.id.text_view_latitude);
            TextViewDistance = (TextView) v.findViewById(R.id.text_view_distance);

        }
        @Override
        public void onClick(View v){
            Integer item = getAdapterPosition();
            Toast.makeText(v.getContext(), String.valueOf(item),
                    Toast.LENGTH_LONG).show();
        }


    }
    public RecycleAdapter(ArrayList<Data> data){
        //constructor
        ArrayData = data;
    }
    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //binds the view to a xml id
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_card_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        //binds all the view to a holder + displays the text
        holder.TextViewNames.setText("Naam: " + String.valueOf(ArrayData.get(position).getNames()));
        holder.TextViewCharging.setText("Oplaadpunten: " + String.valueOf(ArrayData.get(position).getcPoints()));
        //holder.TextViewCode.setText("Code: " + String.valueOf(ArrayData.get(position).getCode()));
        //holder.TextViewLatitude.setText("Positie: (" + String.valueOf(ArrayData.get(position).getLatitude()) + ", " + String.valueOf(ArrayData.get(position).getLongitude())+ ")");
        holder.TextViewCode.setText("Aantal plaatsen: " + String.valueOf(ArrayData.get(position).getSpots()));
        if(gps.canGetLocation()) {
            // checks if gps is available
            holder.TextViewDistance.setText("Afstand tot: " + String.valueOf(ArrayData.get(position).getDistance()) + " km");

        }
        else{
            holder.TextViewDistance.setText("Afstand tot: Niet beschikbaar");
            if (count_gps == 0) {
                gps.showSettingsAlert();
                count_gps += 1;
            }
        }
        //holder.mImageView.setImageResource(R.drawable.ic_local_parking_black_24dp);
    }
    @Override
    // counts the items inside an array
    public int getItemCount() { return ArrayData.size(); }
}
