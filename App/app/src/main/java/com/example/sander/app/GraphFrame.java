package com.example.sander.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import android.R.layout.*;
/**
 * Created by Sander on 8-4-2017.
 */

public class GraphFrame extends Fragment implements AdapterView.OnItemSelectedListener {
    Integer hoodSelector = 27;
    ArrayList<HoodData> hoodDataList = new ArrayList<>();
    ArrayList<String> testList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graph,
                container, false);
        setHoodId(34);

        //API Request for all the hoods
        APIRequest apiRequest = new APIRequest(this.getActivity());
        apiRequest.request("http://test.dontstealmywag.ga/api/damage_or_theft_car_wijk.php");

        getDataFromApi((GraphView) view.findViewById(R.id.graph));

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, apiRequest.getTestList());

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //graph.getViewport().setScrollableY(true);
        return view;
    }

    public void setHoodId(Integer hood){
        hoodSelector = hood;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void getDataFromApi(final GraphView graph){
        RequestQueue rq = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url= "http://test.dontstealmywag.ga/api/damage_or_theft_car_wijk.php?hood_id=" + hoodSelector;
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
                                hoodDataList.add(new HoodData(jsonObject.getDouble("percentage"), jsonObject.getInt("hood_id"), jsonObject.getInt("year"), jsonObject.getString("hood_name")));
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
                        graph.setTitle("Wijk " + hoodSelector + " - " + hoodDataList.get(0).getHood_name());
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
                        series.setDataPointsRadius(10.0f);
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
    }
    public void createSpinner(Spinner spinner){

    }
}
