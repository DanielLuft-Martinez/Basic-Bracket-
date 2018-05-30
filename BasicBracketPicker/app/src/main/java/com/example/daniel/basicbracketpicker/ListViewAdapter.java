package com.example.daniel.basicbracketpicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import org.jsoup.select.Elements;

class ListViewAdapter extends ArrayAdapter {


   // private  final LayoutInflater inflater;
    Context context;


    public ListViewAdapter(Context context, int resource,Elements logos) {

        super(context, resource,logos);





    }
}
