package com.example.sander.app;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.List;

/**
 * Created by Sander on 6-4-2017.
 */

public class BlankFragment extends Fragment{
    public BlankFragment() {
        // Required empty public constructor
    }
    ArrayList<String> list = new ArrayList<>();
    List<String> latitude = new ArrayList<>();
    List<String> longitude = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_blank, container, false);
            final TextView txt=  (TextView)view.findViewById(R.id.onzin);
            RequestQueue rq = Volley.newRequestQueue(getActivity().getApplicationContext());
            String url= "http://test.dontstealmywag.ga/api/parkgarage.php";
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Do something with the response
                            try{
                                JSONObject o = new JSONObject(response);
                                JSONArray values=o.getJSONArray("parkgarage");
                                for ( int i=0; i< values.length(); i++) {
                                    JSONObject sonuc = values.getJSONObject(i);
                                    list.add("Flight: " + sonuc.getString("parkgarage_name") + "\n");
                                    //sb.append("name: " + sonuc.getString("longitude") + "\n\n");

                                }

                                txt.setText(list.get(0));


                            }  catch (JSONException ex){}

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Handle error
                        }
                    });
            rq.add(stringRequest);
            // Inflate the layout for this fragment
            return  view;
        }
    }

