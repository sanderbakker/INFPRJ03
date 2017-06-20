package com.example.sander.app;

import android.content.Context;
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

/**
 * Created by Sander on 19-4-2017.
 */

public class API {
    Context mContext;
    ArrayList<HoodData> completeHoodList = new ArrayList<>();
    public API(Context context){
        mContext = context;
    }
    public void getAllData(){
        RequestQueue rq = Volley.newRequestQueue(mContext.getApplicationContext());
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

    public Double calculateMax(Integer year){
        Double max = completeHoodList.get(0).getPercentage();
        if(year == 2006){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2006){
                    if(completeHoodList.get(z).getPercentage() > max){
                        max = completeHoodList.get(z).getPercentage();
                    }

                }
            }
            Toast.makeText(mContext.getApplicationContext(), String.valueOf(max),
                    Toast.LENGTH_LONG).show();
        }
        if(year == 2007){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2007){
                    if(completeHoodList.get(z).getPercentage() > max){
                        max = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
        if(year == 2008){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2008){
                    if(completeHoodList.get(z).getPercentage() > max){
                        max = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
        if(year == 2009){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2009){
                    if(completeHoodList.get(z).getPercentage() > max){
                        max = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
        if(year == 2011){
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
    public void calculateMin(Integer year){
        Double min = completeHoodList.get(0).getPercentage();
        if(year == 2006){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2006){
                    if(completeHoodList.get(z).getPercentage() < min){
                        min = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
        if(year == 2007){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2007){
                    if(completeHoodList.get(z).getPercentage() < min){
                        min = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
        if(year == 2008){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2008){
                    if(completeHoodList.get(z).getPercentage() < min){
                        min = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
        if(year == 2009){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2009){
                    if(completeHoodList.get(z).getPercentage() < min){
                        min = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
        if(year == 2011){
            for(Integer z = 0; z < completeHoodList.size(); z ++){
                if(completeHoodList.get(z).getYear() == 2011){
                    if(completeHoodList.get(z).getPercentage() < min){
                        min = completeHoodList.get(z).getPercentage();
                    }
                }
            }
        }
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
        return Math.round((sum/counter) * Math.pow(10, 1)) / Math.pow(10, 1);

    }

    public Double getMax2006(){
        return calculateMax(2006);
    }
}
