package com.example.sander.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static android.R.attr.delay;

/**
 * Created by Sander on 6-4-2017.
 */

public class RecycleFrame extends Fragment {
    GPSTracker gps;
    Context mContext;
    ArrayList<Double> dLatitude = new ArrayList<>();
    ArrayList<Double> dLongitude = new ArrayList<>();
    ArrayList<Float> distance = new ArrayList<>();
    ArrayList<Data> dataList = new ArrayList<>();
    RecycleAdapter adapter = new RecycleAdapter(dataList);
    Timer timer;
    public RecycleFrame() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_view, menu);
        MenuItem item = menu.findItem(R.id.search);

        // creates searchView
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setQueryHint("Zoeken");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //makes the search button functional
                if ( TextUtils.isEmpty ( newText ) ) {
                    newText.toLowerCase();
                    adapter.getFilter().filter("");
                } else {
                    newText.toLowerCase();
                    adapter.getFilter().filter(newText.toString());
                }
                return true;
            }
        });
        super.onCreateOptionsMenu(menu,inflater);
    }
    public void refreshFragment(){
        //refreshes fragment
        dataList.clear();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.detach(this).attach(this).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Integer id = item.getItemId();
        if(id == R.id.action_A_Z){
            //Sorts the garages from A to Z

            Collections.sort(dataList, new Comparator<Data>() {
                @Override
                public int compare(Data name1, Data name2) {
                    return name1.getNames().compareTo(name2.getNames());
                }
            });
            //Refreshes the fragment
            adapter.notifyDataSetChanged();
            return true;
        }
        else if(id == R.id.action_Z_A){
            //Sorts the garages from Z to A
            Collections.sort(dataList, new Comparator<Data>() {
                @Override
                public int compare(Data name1, Data name2) {
                    return name2.getNames().compareTo(name1.getNames());
                }
            });
            //Refreshes the fragment
            adapter.notifyDataSetChanged();
            return true;
        }
        else if (id == R.id.short_distance){
            Collections.sort(dataList, new Comparator<Data>() {
                @Override
                public int compare(Data distance1, Data distance2) {
                    return distance1.getDistance().compareTo(distance2.getDistance());
                }
            });
            adapter.notifyDataSetChanged();
            return true;
        }
        else if(id == R.id.places){
            //Sorts the garages based on the number of spots
            Collections.sort(dataList, new Comparator<Data>() {
                @Override
                public int compare(Data place1, Data place2) {
                    return place2.getSpots().compareTo(place1.getSpots());
                }
            });
            //Refreshes the fragment
            adapter.notifyDataSetChanged();
            return true;
        }
        else if(id == R.id.refresh){
            refreshFragment();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        gps = new GPSTracker(getActivity());
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycle, container, false);
        final RecyclerView VRecyclerView = (RecyclerView) view.findViewById(R.id.rv_recycler_view);
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
                            if(dataList.size() == 0) {
                                for (int i = 0; i < values.length(); i++) {
                                    JSONObject jsonObject = values.getJSONObject(i);

                                    // new location object
                                    Location myLocation = new Location("");
                                    //gets data from current location
                                    myLocation.setLatitude(gps.getLatitude());
                                    myLocation.setLongitude(gps.getLongitude());
                                    // creates list of lat long data
                                    dLatitude.add(jsonObject.getDouble("langitude"));
                                    dLongitude.add(jsonObject.getDouble("longitude"));
                                    // creates new location object
                                    Location parkingGarage = new Location("");
                                    //gets lat long from garage
                                    parkingGarage.setLatitude(dLatitude.get(i));
                                    parkingGarage.setLongitude(dLongitude.get(i));
                                    //converts distance to KM
                                    distance.add(myLocation.distanceTo(parkingGarage)/1000);
                                    //creates custom object with all required data
                                    dataList.add(new Data(jsonObject.getString("parkgarage_name"), jsonObject.getString("charging_capacity"), jsonObject.getDouble("langitude"),
                                            jsonObject.getDouble("longitude"), jsonObject.getString("parkgarage_code"), distance.get(i), jsonObject.getInt("car_capacity")));
                                }
                            }
                        }  catch (JSONException ex){}
                        VRecyclerView.setHasFixedSize(true);

                        VRecyclerView.setAdapter(adapter);
                        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
                        VRecyclerView.setLayoutManager(llm);
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });
        rq.add(stringRequest);
        return view;
    }
}