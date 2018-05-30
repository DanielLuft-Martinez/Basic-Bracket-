package com.example.daniel.basicbracketpicker;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class BracketPageFragment extends android.support.v4.app.Fragment {

    String[] Brack;
    String[] brackShort;
    int NUM_PAGES = 32;
    int Round;
    RecyclerView BRV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_bracket_column_contain
                , container, false);
           BRV = (RecyclerView) rootView.findViewById(R.id.recyclerBracket);

        Bundle bundle = this.getArguments();


       BRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
      // BRV.addItemDecoration();
        BRV.setAdapter( new BracketRecyclerViewAdapter(this.getContext(), bundle.getInt("pos", 1),bundle));


        return rootView;
    }

}