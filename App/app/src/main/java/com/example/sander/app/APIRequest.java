package com.example.sander.app;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Sander on 11-4-2017.
 */

public class APIRequest {
    Context mContext;
    ArrayList<String> hoodList = new ArrayList<>();
    RequestQueue rq;
    public APIRequest (Context context){
        mContext = context;
    }
    public void request (String refUrl){
        RequestQueue rq = Volley.newRequestQueue(mContext);
        String url= refUrl;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with the response
                        try{
                            JSONObject o = new JSONObject(response);
                            JSONArray values=o.getJSONArray("");
                            for (int i = 0; i < values.length(); i++) {
                                JSONObject jsonObject = values.getJSONObject(i);
                                //if(!hoodList.contains(jsonObject.getString("hood_name"))){
                                    hoodList.add(jsonObject.getString("hood_name"));
                            //}
                            }

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
    }
    public ArrayList<String> getHoodList(){
        return hoodList;
    }
}