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
    Integer hoodSelector = 27;
    ArrayList<HoodData> hoodDataList = new ArrayList<>();
    ArrayList<String> hoodList = new ArrayList<>();
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        for(int i = 1; i < hoodList.size(); i++) {
            if (item.equals(hoodList.get(i))) {
                setHoodId(i + 27);
                refreshFragment();
            }

        }
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
        getDataFromApi((GraphView) view.findViewById(R.id.graph));
        getDataForSpinner((Spinner) view.findViewById(R.id.spinner));
        return view;
    }

    public void setHoodId(Integer hood){
        hoodSelector = hood;
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

                        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                                new DataPoint(1, hoodDataList.get(0).getPercentage()),
                                new DataPoint(2, hoodDataList.get(1).getPercentage()),
                                new DataPoint(3, hoodDataList.get(2).getPercentage()),
                                new DataPoint(4, hoodDataList.get(3).getPercentage()),
                                new DataPoint(5, hoodDataList.get(4).getPercentage())
                                //new DataPoint(12, 0)
                        });
                        LineGraphSeries<DataPoint> average = new LineGraphSeries<>(new DataPoint[]{
                                new DataPoint(1, 18.5),
                                new DataPoint(2, 16.5),
                                new DataPoint(3, 17.5),
                                new DataPoint(4, 18.0),
                                new DataPoint(5, 14.0)
                                /* new DataPoint(1, 3),
                                new DataPoint(2, 3),
                                new DataPoint(3, 3),
                                new DataPoint(4, 3),
                                new DataPoint(5, 3)*/
                        });

                        // set manual x bounds
                        staticLabelsFormatter.setHorizontalLabels(new String[] {"2006", "2007","2008","2009","2011"});
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
                                Toast.makeText(getActivity(), "Punt "+ dataPoint, Toast.LENGTH_SHORT).show();
                            }
                        });
                        series.setTitle("%");
                        series.setAnimated(true);
                        average.setAnimated(true);
                        average.setColor(Color.argb(255, 0, 51, 153));
                        average.setThickness(5);
                        series.setColor(Color.argb(255, 102, 204, 255));
                        graph.addSeries(average);
                        graph.getLegendRenderer().setVisible(true);
                        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
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