package com.example.sander.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Sander on 19-4-2017.
 */

public class ParkInfoFrame extends Fragment {
    GPSTracker gps;
    Integer count_gps = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        String name = getArguments().getString("1");
        String code = getArguments().getString("2");
        String cPoints = getArguments().getString("3");
        String distance = getArguments().getString("4");
        String spots = getArguments().getString("5");
        String location = getArguments().getString("6");
        String address = getArguments().getString("7");
        String zipcode = getArguments().getString("8");

        View view = inflater.inflate(R.layout.fragment_park,
                container, false);
        gps = new GPSTracker(view.getContext());
        TextView textViewName = (TextView) view.findViewById(R.id.name_info);
        TextView textViewCode = (TextView) view.findViewById(R.id.code_info);
        TextView textViewPoints = (TextView) view.findViewById(R.id.cPoints_info);
        TextView textViewDistance = (TextView) view.findViewById(R.id.distance_info);
        TextView textViewSpots = (TextView) view.findViewById(R.id.spots_info);
        TextView textViewLocation = (TextView) view.findViewById(R.id.location_info);
        TextView textViewAddress = (TextView) view.findViewById(R.id.address_info);
        TextView textViewZipcode = (TextView) view.findViewById(R.id.zipcode_info);

        textViewName.setText("Naam: " + name);
        textViewCode.setText("Code: " + code);
        textViewPoints.setText("Oplaadpunten: " + cPoints);

        if (gps.canGetLocation) {
            textViewDistance.setText("Afstand tot: " + distance + " km");
        } else {
            textViewDistance.setText("Afstand tot: Niet beschikbaar");
            if (count_gps == 0) {
                gps.showSettingsAlert();
                count_gps += 1;
            }
        }
        textViewSpots.setText("Aantal plaatsen: " + spots);
        textViewLocation.setText("Locatie: " + location);
        textViewAddress.setText(address);
        textViewZipcode.setText(zipcode);

        return view;
    }

    public void refreshFragment() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.detach(this).attach(this).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Integer id = item.getItemId();
        if (id == R.id.refresh_info) {
            refreshFragment();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_park, menu);
    }
}
