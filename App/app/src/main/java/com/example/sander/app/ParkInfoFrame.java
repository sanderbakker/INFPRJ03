package com.example.sander.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sander on 19-4-2017.
 */

public class ParkInfoFrame extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String name = getArguments().getString("1");
        String code = getArguments().getString("2");
        String cPoints = getArguments().getString("3");
        String distance = getArguments().getString("4");
        String spots = getArguments().getString("5");
        String location = getArguments().getString("6");

        View view = inflater.inflate(R.layout.fragment_park,
                container, false);

        TextView textViewName= (TextView) view.findViewById(R.id.name_info);
        TextView textViewCode= (TextView) view.findViewById(R.id.code_info);
        TextView textViewPoints= (TextView) view.findViewById(R.id.cPoints_info);
        TextView textViewDistance= (TextView) view.findViewById(R.id.distance_info);
        TextView textViewSpots= (TextView) view.findViewById(R.id.spots_info);
        TextView textViewLocation= (TextView) view.findViewById(R.id.location_info);

        textViewName.setText("Naam: "+ name);
        textViewCode.setText("Code: "+ code);
        textViewPoints.setText("Oplaadpunten: " + cPoints);
        textViewDistance.setText("Afstand tot: " + distance + " km");
        textViewSpots.setText("Aantal plaatsen: "+ spots);
        textViewLocation.setText("Locatie: "+ location);

        return view;
    }
}
