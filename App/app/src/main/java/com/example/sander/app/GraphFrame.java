package com.example.sander.app;

import android.app.Fragment;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Sander on 8-4-2017.
 */

public class GraphFrame extends Fragment {
    Integer hoodSelector = 27;
    ArrayList<HoodData> hoodDataList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graph,
                container, false);
        setHoodId(34);
        final GraphView graph = (GraphView) view.findViewById(R.id.graph);


        //graph.getViewport().setScrollableY(true);
        RequestQueue rq = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url= "http://test.dontstealmywag.ga/api/damage_or_theft_car.php?hood_id=" + hoodSelector;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with the response
                        try{
                            JSONObject o = new JSONObject(response);
                            JSONArray values=o.getJSONArray("damage_or_theft_car");
                                for (int i = 0; i < values.length(); i++) {
                                    JSONObject jsonObject = values.getJSONObject(i);
                                    hoodDataList.add(new HoodData(jsonObject.getDouble("percentage"), jsonObject.getInt("hood_id"), jsonObject.getInt("year")));
                                }

                        }  catch (JSONException ex){}
                        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                                new DataPoint(1, hoodDataList.get(0).getPercentage()),
                                new DataPoint(2, hoodDataList.get(1).getPercentage()),
                                new DataPoint(3, hoodDataList.get(2).getPercentage()),
                                new DataPoint(4, hoodDataList.get(3).getPercentage()),
                                new DataPoint(5, hoodDataList.get(4).getPercentage())
                                //new DataPoint(12, 0)
                        });
                        graph.setTitle("Wijk " + hoodSelector);
                        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);

                        // set manual x bounds
                        staticLabelsFormatter.setHorizontalLabels(new String[] {"2006", "2007","2008","2009","2011"});
                        //creates custom x-axis
                        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
                        //set nice background color :)
                        series.setDrawBackground(true);
                        //shows points at datapoints
                        series.setDrawDataPoints(true);
                        //size of the points
                        series.setDataPointsRadius(15.0f);
                        graph.addSeries(series);



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

    public void setHoodId(Integer hood){
        hoodSelector = hood;
    }
}
