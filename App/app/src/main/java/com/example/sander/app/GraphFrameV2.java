package com.example.sander.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Sander on 8-4-2017.
 */

public class GraphFrameV2 extends Fragment implements AdapterView.OnItemSelectedListener {
    Integer hoodSelector = 26;
    ArrayList<HoodData> hoodDataList = new ArrayList<>();
    ArrayList<String> hoodList = new ArrayList<>();
    ArrayList<HoodData> completeHoodList = new ArrayList<>();

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        for(int i = 1; i < hoodList.size(); i++) {
            if (item.equals(hoodList.get(i))) {
                setHoodId(i + 26);
                refreshFragment();
            }

        }
    }
    public Double calculateMax(Integer year){
        Double max = 0.0;
        if(year == 2006){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2006){
                    if(completeHoodList.get(z).getPercentage() > max){
                        max = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
        else if(year == 2007){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2007){
                    if(completeHoodList.get(z).getPercentage() > max){
                        max = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
        else if(year == 2008){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2008){
                    if(completeHoodList.get(z).getPercentage() > max){
                        max = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
        else if(year == 2009){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2009){
                    if(completeHoodList.get(z).getPercentage() > max){
                        max = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
        else{
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2011){
                    if(completeHoodList.get(z).getPercentage() > max){
                        max = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
        return max;
    }
    public Double calculateAvg(Integer year){
        Double avg = null;
        Double sum = 0.0;
        Integer counter = 0;
        if(year == 2006){
            for(Integer z = 0; z < completeHoodList.size(); z++){
                if(completeHoodList.get(z).getYear() == 2006){
                    sum = sum + completeHoodList.get(z).getPercentage();
                    counter = counter + 1;
                }
            }
        }
        else if(year == 2007){
            for(Integer z = 0; z < completeHoodList.size(); z++){
                if(completeHoodList.get(z).getYear() == 2007){
                    sum = sum + completeHoodList.get(z).getPercentage();
                    counter = counter + 1;
                }
            }
        }
        else if(year == 2008){
            for(Integer z = 0; z < completeHoodList.size(); z++){
                if(completeHoodList.get(z).getYear() == 2008){
                    sum = sum + completeHoodList.get(z).getPercentage();
                    counter = counter + 1;
                }
            }
        }
        else if(year == 2009){
            for(Integer z = 0; z < completeHoodList.size(); z++){
                if(completeHoodList.get(z).getYear() == 2009){
                    sum = sum + completeHoodList.get(z).getPercentage();
                    counter = counter + 1;
                }
            }
        }
        else{
            for(Integer z = 0; z < completeHoodList.size(); z++){
                if(completeHoodList.get(z).getYear() == 2011){
                    sum = sum + completeHoodList.get(z).getPercentage();
                    counter = counter + 1;
                }
            }
        }
        return Math.round((sum/counter) * Math.pow(10, 1)) / Math.pow(10, 1);

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void refreshFragment(){
        //refreshes the Fragment
        hoodDataList.clear();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.detach(this).attach(this).commit();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_graph,
                container, false);
        //API Request for all the hoods
        getAllData();
        getDataFromApi((GraphView) view.findViewById(R.id.graph));
        getDataForSpinner((Spinner) view.findViewById(R.id.spinner));
        return view;
    }

    public void setHoodId(Integer hood){
        hoodSelector = hood;
    }

    public void getAllData(){
        RequestQueue rq = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url= "http://test.dontstealmywag.ga/api/theft_outof_car_wijk.php";
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
                                completeHoodList.add(new HoodData(jsonObject.getDouble("percentage"), jsonObject.getInt("hood_id"), jsonObject.getInt("year"), jsonObject.getString("hood_name")));
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

    public void getDataFromApi(final GraphView graph) {
        RequestQueue rq = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url= "http://test.dontstealmywag.ga/api/theft_outof_car_wijk.php?hood_id=" + hoodSelector;
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
                        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
                        if(hoodSelector != 26) {

                            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                                    new DataPoint(1, (100 - ((100 / (calculateMax(2006) + (calculateAvg(2006) /2)) * hoodDataList.get(0).getPercentage()))) / 20),
                                    new DataPoint(2, (100 - ((100 / (calculateMax(2007) + (calculateAvg(2007) /2)) * hoodDataList.get(1).getPercentage()))) / 20),
                                    new DataPoint(3, (100 - ((100 / (calculateMax(2008) + (calculateAvg(2008) /2)) * hoodDataList.get(2).getPercentage()))) / 20),
                                    new DataPoint(4, (100 - ((100 / (calculateMax(2009) + (calculateAvg(2009) /2)) * hoodDataList.get(3).getPercentage()))) / 20),
                                    new DataPoint(5, (100 - ((100 / (calculateMax(2011) + (calculateAvg(2011) /2)) * hoodDataList.get(4).getPercentage()))) / 20)
                                    //new DataPoint(12, 0)
                            });
                            LineGraphSeries<DataPoint> average = new LineGraphSeries<>(new DataPoint[]{
                                    new DataPoint(1, 2.1),
                                    new DataPoint(2, 2.1),
                                    new DataPoint(3, 2.1),
                                    new DataPoint(4, 2.1),
                                    new DataPoint(5, 2.1)
                            });

                            // set manual x bounds
                            staticLabelsFormatter.setHorizontalLabels(new String[]{"2006", "2007", "2008", "2009", "2011"});

                            //creates custom x-axis
                            graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
                            graph.setTitle("Wijk " + hoodSelector + " - " + hoodDataList.get(0).getHood_name());
                            //set nice background color :)
                            series.setDrawBackground(true);
                            //shows points at datapoints
                            series.setDrawDataPoints(true);
                            average.setDrawDataPoints(true);
                            //size of the points
                            series.setDataPointsRadius(10.0f);
                            series.setOnDataPointTapListener(new OnDataPointTapListener() {
                                @Override
                                public void onTap(Series series, DataPointInterface dataPoint) {
                                    Toast.makeText(getActivity(), "Punt " + dataPoint, Toast.LENGTH_SHORT).show();
                                }
                            });
                            series.setTitle("Grade per year");
                            series.setAnimated(true);
                            average.setTitle("Final grade");
                            average.setAnimated(true);
                            average.setColor(Color.argb(255, 0, 51, 153));
                            average.setThickness(5);
                            series.setColor(Color.argb(255, 102, 204, 255));
                            graph.addSeries(average);
                            graph.getLegendRenderer().setVisible(true);
                            graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                            graph.addSeries(series);


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
    }
    public void getDataForSpinner(final Spinner spinner){
        RequestQueue rq = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url= "http://test.dontstealmywag.ga/api/theft_outof_car_wijk.php";
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
                                if (!hoodList.contains(jsonObject.getString("hood_name"))) {
                                    hoodList.add(jsonObject.getString("hood_name"));
                                }
                            }
                        }  catch (JSONException ex){}

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(spinner.getContext(), android.R.layout.simple_spinner_item, hoodList);
                        // Specify the layout to use when the list of choices appears
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        // Apply the adapter to the spinner
                        spinner.setPrompt("Title");
                        spinner.setAdapter(adapter);

                        spinner.setOnItemSelectedListener(GraphFrameV2.this);


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


}