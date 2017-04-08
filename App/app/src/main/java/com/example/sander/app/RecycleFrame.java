package com.example.sander.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

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
import java.util.List;

/**
 * Created by Sander on 6-4-2017.
 */

public class RecycleFrame extends Fragment {
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> cPoints = new ArrayList<>();
    ArrayList<String> code = new ArrayList<>();
    ArrayList<String> latitude = new ArrayList<>();
    ArrayList<String> longitude = new ArrayList<>();
    boolean check = false;
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
        super.onCreateOptionsMenu(menu,inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Integer id = item.getItemId();
        if(id == R.id.action_A_Z){
            //Sorts the garages from A to Z
            Collections.sort(names);
            //Refreshes the fragment
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.detach(this).attach(this).commit();
            return true;
        }
        else if(id == R.id.action_Z_A){
            //Sorts the garages from Z to A
            Collections.reverse(names);
            //Refreshes the fragment
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.detach(this).attach(this).commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
                            if(names.size() == 0) {
                                for (int i = 0; i < values.length(); i++) {

                                    JSONObject jsonObject = values.getJSONObject(i);
                                    names.add(jsonObject.getString("parkgarage_name"));
                                    cPoints.add(jsonObject.getString("charging_capacity"));
                                    code.add(jsonObject.getString("parkgarage_code"));
                                    latitude.add(jsonObject.getString("langitude"));
                                    longitude.add(jsonObject.getString("longitude"));

                                }
                            }
                        }  catch (JSONException ex){}
                        VRecyclerView.setHasFixedSize(true);
                        RecycleAdapter adapter = new RecycleAdapter(names, cPoints, code, latitude, longitude);
                        VRecyclerView.setAdapter(adapter);
                        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
                        VRecyclerView.setLayoutManager(llm);
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
