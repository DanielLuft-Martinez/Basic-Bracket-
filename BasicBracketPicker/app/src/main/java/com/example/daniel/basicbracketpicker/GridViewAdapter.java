package com.example.daniel.basicbracketpicker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import org.jsoup.select.Elements;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter {

    private final LayoutInflater inflater;
    Context context;
    Elements logos;


    public GridViewAdapter(Context context, int resource, Elements logos) {

        super(context, resource,logos);
        this.context = context;
        this.logos = logos;
        inflater = LayoutInflater.from(context);

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView == null)
            convertView = inflater.inflate(R.layout.logo_target, parent, false);

        TextView textView =  convertView.findViewById( R.id.textViewTarget);



        final View finalConvertView = convertView;

        String url = logos.eachAttr("src").get(position);
        String shrtName = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));

        Log.d("Src", url);
        textView.setText(shrtName);

        Glide.with(context)
                .load( url )
                .into((new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        finalConvertView.setBackground( resource);
                    }
                }));

        return convertView;
    }







}

