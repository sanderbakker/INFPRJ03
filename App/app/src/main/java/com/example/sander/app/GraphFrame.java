package com.example.sander.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
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
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import android.R.layout.*;
import android.widget.Toast;

/**
 * Created by Sander on 8-4-2017.
 */

public class GraphFrame extends Fragment implements AdapterView.OnItemSelectedListener {
    Integer hoodSelector = 27;
    ArrayList<HoodData> hoodDataList = new ArrayList<>();
    ArrayList<String> hoodList = new ArrayList<>();

    Context mContext;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        if (item.equals(hoodList.get(0))) {
            setHoodId(27);
            //refreshFragment();
        } else if (item.equals(hoodList.get(1))) {
            setHoodId(28);
            refreshFragment();
        } else if (item.equals(hoodList.get(2))) {
            setHoodId(29);
            refreshFragment();
        } else if (item.equals(hoodList.get(3))) {
            setHoodId(30);
            refreshFragment();
        } else if (item.equals(hoodList.get(4))) {
            setHoodId(31);
            refreshFragment();
        } else if (item.equals(hoodList.get(5))) {
            setHoodId(32);
            refreshFragment();
        } else if (item.equals(hoodList.get(6))) {
            setHoodId(33);
            refreshFragment();
        } else if (item.equals(hoodList.get(7))) {
            setHoodId(34);
            refreshFragment();
        } else if (item.equals(hoodList.get(8))) {
            setHoodId(35);
            refreshFragment();
        } else if (item.equals(hoodList.get(9))) {
            setHoodId(36);
            refreshFragment();
        } else if (item.equals(hoodList.get(10))) {
            setHoodId(37);
            refreshFragment();
        } else if (item.equals(hoodList.get(11))) {
            setHoodId(38);
            refreshFragment();
        } else if (item.equals(hoodList.get(12))) {
            setHoodId(39);
            refreshFragment();
        } else if (item.equals(hoodList.get(13))) {
            setHoodId(40);
            refreshFragment();
        } else if (item.equals(hoodList.get(14))) {
            setHoodId(41);
            refreshFragment();
        } else if (item.equals(hoodList.get(15))) {
            setHoodId(42);
            refreshFragment();
        } else if (item.equals(hoodList.get(16))) {
            setHoodId(43);
            refreshFragment();
        } else if (item.equals(hoodList.get(17))) {
            setHoodId(44);
            refreshFragment();
        } else if (item.equals(hoodList.get(18))) {
            setHoodId(45);
            refreshFragment();
        } else if (item.equals(hoodList.get(19))) {
            setHoodId(46);
            refreshFragment();
        } else if (item.equals(hoodList.get(20))) {
            setHoodId(47);
            refreshFragment();
        } else if (item.equals(hoodList.get(21))) {
            setHoodId(48);
            refreshFragment();
        } else if (item.equals(hoodList.get(22))) {
            setHoodId(49);
            refreshFragment();
        } else if (item.equals(hoodList.get(23))) {
            setHoodId(50);
            refreshFragment();
        } else if (item.equals(hoodList.get(24))) {
            setHoodId(51);
            refreshFragment();
        } else if (item.equals(hoodList.get(25))) {
            setHoodId(52);
            refreshFragment();
        } else if (item.equals(hoodList.get(26))) {
            setHoodId(53);
            refreshFragment();
        } else if (item.equals(hoodList.get(27))) {
            setHoodId(54);
            refreshFragment();
        } else if (item.equals(hoodList.get(28))) {
            setHoodId(55);
            refreshFragment();
        } else if (item.equals(hoodList.get(29))) {
            setHoodId(56);
            refreshFragment();
        } else if (item.equals(hoodList.get(30))) {
            setHoodId(57);
            refreshFragment();
        } else if (item.equals(hoodList.get(31))) {
            setHoodId(58);
            refreshFragment();
        } else if (item.equals(hoodList.get(32))) {
            setHoodId(59);
            refreshFragment();
        } else if (item.equals(hoodList.get(33))) {
            setHoodId(60);
            refreshFragment();
        } else if (item.equals(hoodList.get(34))) {
            setHoodId(61);
            refreshFragment();
        } else if (item.equals(hoodList.get(35))) {
            setHoodId(62);
            refreshFragment();
        } else if (item.equals(hoodList.get(36))) {
            setHoodId(63);
            refreshFragment();
        } else if (item.equals(hoodList.get(37))) {
            setHoodId(64);
            refreshFragment();
        } else if (item.equals(hoodList.get(38))) {
            setHoodId(65);
            refreshFragment();
        } else if (item.equals(hoodList.get(39))) {
            setHoodId(66);
            refreshFragment();
        } else if (item.equals(hoodList.get(40))) {
            setHoodId(67);
            refreshFragment();
        } else if (item.equals(hoodList.get(41))) {
            setHoodId(68);
            refreshFragment();
        } else if (item.equals(hoodList.get(42))) {
            setHoodId(69);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(43))) {
            setHoodId(70);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(44))) {
            setHoodId(71);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(45))) {
            setHoodId(72);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(46))) {
            setHoodId(73);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(47))) {
            setHoodId(74);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(48))) {
            setHoodId(75);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(49))) {
            setHoodId(76);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(50))) {
            setHoodId(77);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(51))) {
            setHoodId(78);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(52))) {
            setHoodId(79);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(53))) {
            setHoodId(80);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(54))) {
            setHoodId(81);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(55))) {
            setHoodId(82);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(56))) {
            setHoodId(83);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(57))) {
            setHoodId(84);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(58))) {
            setHoodId(85);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(59))) {
            setHoodId(86);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(60))) {
            setHoodId(87);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(61))) {
            setHoodId(88);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(62))) {
            setHoodId(89);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(63))) {
            setHoodId(90);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(64))) {
            setHoodId(91);
            refreshFragment();
        }
        else if (item.equals(hoodList.get(65))) {
            setHoodId(92);
            refreshFragment();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void refreshFragment(){
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
                        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);

                        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                                new DataPoint(1, hoodDataList.get(0).getPercentage()),
                                new DataPoint(2, hoodDataList.get(1).getPercentage()),
                                new DataPoint(3, hoodDataList.get(2).getPercentage()),
                                new DataPoint(4, hoodDataList.get(3).getPercentage()),
                                new DataPoint(5, hoodDataList.get(4).getPercentage())
                                //new DataPoint(12, 0)
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
        String url= "http://test.dontstealmywag.ga/api/damage_or_theft_car_wijk.php";
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

                        spinner.setOnItemSelectedListener(GraphFrame.this);


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
