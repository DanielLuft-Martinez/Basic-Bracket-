package com.example.daniel.basicbracketpicker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class HeadCommitFragment extends android.support.v4.app.Fragment {

    String[] Brack;
    String[] brackShort;
    int NUM_PAGES = 32;
    int Round;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_head_commit
                , container, false);




        String Name = "Team Fail Bot";
        String NameShort = "Team Fail Top";

        int pos = 0;




        Bundle bundle = this.getArguments();
        if (bundle != null) {
            pos = bundle.getInt("pos", 0);

            Brack = bundle.getStringArray("teams");
            brackShort =bundle.getStringArray("teamsShort");
            Round = bundle.getInt("round",1);
            NUM_PAGES = bundle.getInt("numP", 32);


            switch (bundle.getInt("round", 1)) {
                case 1:
                    Name =Brack[NUM_PAGES+pos];
                    NameShort = brackShort[NUM_PAGES+pos];
                    break;
                case 2:
                    Name =Brack[NUM_PAGES+pos];
                    NameShort = brackShort[NUM_PAGES+pos];
                    break;
                case 3:
                    Name =Brack[NUM_PAGES+pos];
                    NameShort = brackShort[NUM_PAGES+pos];
                    break;
                case 4:
                    Name =Brack[NUM_PAGES+pos];
                    NameShort = brackShort[NUM_PAGES+pos];
                    break;
                case 5:
                    Name =Brack[NUM_PAGES+pos];
                    NameShort = brackShort[NUM_PAGES+pos];
                    break;
                case 6:
                    Name =Brack[NUM_PAGES+pos];
                    NameShort = brackShort[NUM_PAGES+pos];
                    break;
                default:
                    Name =Brack[NUM_PAGES+pos];
                    NameShort = brackShort[NUM_PAGES+pos];
                    break;


            }

        }

        TextView textView =  rootView.findViewById(R.id.textViewChosen);
        textView.setText(Name);
        ImageView imageView = rootView.findViewById(R.id.imageViewChosen);
        String logoUrl ="https://sports.cbsimg.net/images/collegebasketball/logos/50x50/"+NameShort+".png";
        int px = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 128, getResources().getDisplayMetrics()));
        Glide.with(this)
                .load(logoUrl ).apply(new RequestOptions()
                .placeholder(R.drawable.school)
                .override(px*2,2*px))
                .into(imageView);



        return rootView;
    }




}