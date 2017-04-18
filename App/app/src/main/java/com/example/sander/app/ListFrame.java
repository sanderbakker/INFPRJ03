package com.example.sander.app;

import android.app.Fragment;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
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
import java.util.HashSet;

/**
 * Created by Sander on 14-4-2017.
 */

public class ListFrame extends Fragment {
    private ArrayList<Points> points = new ArrayList<>();
    private HashSet<String> all_ids=new HashSet<String>();
    ListAdapter adapter;
    public ListFrame(){
        //Empty constructor needed inside a fragment
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_list, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Integer id = item.getItemId();
        if (id == R.id.action_A_Z) {
            //Sorts the garages from A to Z

            Collections.sort(points, new Comparator<Points>() {
                @Override
                public int compare(Points name1, Points name2) {
                    return name1.getHoodName().compareTo(name2.getHoodName());
                }
            });
            //Smooth way of ordering
            adapter.notifyDataSetChanged();
            return true;

        }
        else if (id == R.id.action_Z_A) {
            //Sorts the garages from A to Z

            Collections.sort(points, new Comparator<Points>() {
                @Override
                public int compare(Points name1, Points name2) {
                    return name2.getHoodName().compareTo(name1.getHoodName());
                }
            });
            //Smooth way of ordering
            adapter.notifyDataSetChanged();
            return true;

        }
        else if(id == R.id.number){
            Collections.sort(points, new Comparator<Points>() {
                @Override
                public int compare(Points o1, Points o2) {
                    return o2.getPoints().compareTo(o1.getPoints());
                }
            });
            adapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_list,
                container, false);
        setHasOptionsMenu(true);
        RequestQueue rq = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url= "http://test.dontstealmywag.ga/api/hood_points.php";
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
                                if (!all_ids.contains(jsonObject.getString("hood_name")))  {
                                    points.add(new Points(jsonObject.getString("hood_name"), jsonObject.getDouble("points"), jsonObject.getInt("hood_id")));
                                    all_ids.add(jsonObject.getString("hood_name"));
                                }
                            }
                        }  catch (JSONException ex){}

                        ListView listView = (ListView) view.findViewById(R.id.list);
                        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.header_list, listView,
                                false);
                        listView.addHeaderView(header, null, false);
                        //Create new Adapter
                        adapter = new ListAdapter(getActivity(), points);
                        // Attach the adapter to a ListView

                        listView.setAdapter(adapter);

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
