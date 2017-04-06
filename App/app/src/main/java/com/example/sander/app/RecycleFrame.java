package com.example.sander.app;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Sander on 6-4-2017.
 */

public class RecycleFrame extends Fragment {
    public RecycleFrame() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recycle, container, false);

        RecyclerView VRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        VRecyclerView.setHasFixedSize(true);
        RecycleAdapter adapter = new RecycleAdapter(new String[]{"Example One", "Example Two", "Example Three", "Example Four", "Example Five" , "Example Six" , "Example Seven", "Example Eight"});
        VRecyclerView.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        VRecyclerView.setLayoutManager(llm);

        return rootView;
    }
}
