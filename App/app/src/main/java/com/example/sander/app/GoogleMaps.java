package com.example.sander.app;

import android.app.Fragment;

/**
 * Created by Sander on 4-4-2017.
 */

import android.app.Fragment;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.Manifest;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


public class GoogleMaps extends Fragment implements OnMapReadyCallback {
    // creates arrays
    ArrayList<String> list = new ArrayList<>();
    ArrayList<Double> latitude = new ArrayList<>();
    ArrayList<Double> longitude = new ArrayList<>();

    public GoogleMaps(){

    }
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gmaps, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //creates MapView
        MapView mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        mapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapView.getMapAsync(this);

    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        RequestQueue rq = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url= "http://test.dontstealmywag.ga/api/parkgarage_all.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with the response
                        try{
                            JSONObject o = new JSONObject(response);
                            JSONArray values=o.getJSONArray("");
                            for ( int i=0; i< values.length(); i++) {
                                JSONObject jsonObject = values.getJSONObject(i);
                                list.add(jsonObject.getString("parkgarage_name"));
                                longitude.add(jsonObject.getDouble("langitude"));
                                latitude.add(jsonObject.getDouble("longitude"));

                            }
                        }  catch (JSONException ex){}
                        for(Integer i = 0; i < list.size(); i++){
                            googleMap.addMarker(new MarkerOptions().title(list.get(i)).position(new LatLng(longitude.get(i), latitude.get(i))));
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });
        rq.add(stringRequest);
        //new marker point
        LatLng marker = new LatLng(51.9244201, 4.4777325);
        //moves camera to the center of Rotterdam
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 12));
        // checks for premissions
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //shows location, compass
        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    }

