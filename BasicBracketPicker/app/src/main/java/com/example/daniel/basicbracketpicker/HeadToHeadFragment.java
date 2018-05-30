package com.example.daniel.basicbracketpicker;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class HeadToHeadFragment extends android.support.v4.app.Fragment {

    String[] Brack;
    String[] brackShort;
    int NUM_PAGES = 32;
    int Round;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_head_to_head
                , container, false);


        TextView tvTop = rootView.findViewById(R.id.textViewTop);
        TextView tvBot = rootView.findViewById(R.id.textViewBot);



        String topName = "Team Fail Top";
        String botName = "Team Fail Bot";
        String topNameShort = "Team Fail Top";
        String botNameShort = "Team Fail Bot";

        int pos = 0;




        Bundle bundle = this.getArguments();
        if (bundle != null) {
           pos = bundle.getInt("pos", 0);

           Brack = bundle.getStringArray("teams");
           brackShort =bundle.getStringArray("teamsShort");
           Round = bundle.getInt("round",1);
           NUM_PAGES = bundle.getInt("numP", 32);


            switch (Round) {
                case 1:
                    topName =Brack[(NUM_PAGES*2)+pos];
                    botName = Brack[(NUM_PAGES*2)+32+pos];
                    topNameShort = brackShort[(NUM_PAGES*2)+pos];
                    botNameShort = brackShort[(NUM_PAGES*2)+32+pos];
                    break;
                case 2:
                    topName =Brack[(NUM_PAGES*2)+pos];
                    botName = Brack[(NUM_PAGES*2)+16+pos];
                    topNameShort = brackShort[(NUM_PAGES*2)+pos];
                    botNameShort = brackShort[(NUM_PAGES*2)+16+pos];
                    break;
                case 3:
                    topName =Brack[(NUM_PAGES*2)+pos];
                    botName = Brack[(NUM_PAGES*2)+8+pos];
                    topNameShort = brackShort[(NUM_PAGES*2)+pos];
                    botNameShort = brackShort[(NUM_PAGES*2)+8+pos];
                    break;
                case 4:
                    topName =Brack[(NUM_PAGES*2)+pos];
                    botName = Brack[(NUM_PAGES*2)+4+pos];
                    topNameShort = brackShort[(NUM_PAGES*2)+pos];
                    botNameShort = brackShort[(NUM_PAGES*2)+4+pos];
                    break;
                case 5:
                    topName =Brack[(NUM_PAGES*2)+pos];
                    botName = Brack[(NUM_PAGES*2)+2+pos];
                    topNameShort = brackShort[(NUM_PAGES*2)+pos];
                    botNameShort = brackShort[(NUM_PAGES*2)+2+pos];
                    break;
                case 6:
                    topName =Brack[(NUM_PAGES*2)];
                    botName = Brack[(NUM_PAGES*2)+1];
                    topNameShort = brackShort[(NUM_PAGES*2)];
                    botNameShort = brackShort[(NUM_PAGES*2)+1];
                    break;
                default:
                    topName =Brack[(NUM_PAGES*2)+pos];
                    botName = Brack[(NUM_PAGES*2)+32+pos];
                    topNameShort = brackShort[(NUM_PAGES*2)+pos];
                    botNameShort = brackShort[(NUM_PAGES*2)+32+pos];
                    break;



            }



        }

        tvTop.setText(topName);
        tvBot.setText(botName);

        ImageButton imageButtonTop = rootView.findViewById(R.id.imageButtonTop);
        ImageButton imageButtonBot = rootView.findViewById(R.id.imageButtonBot);

        String logoUrlTop ="https://sports.cbsimg.net/images/collegebasketball/logos/50x50/"+topNameShort+".png";
        String logoUrlBot ="https://sports.cbsimg.net/images/collegebasketball/logos/50x50/"+botNameShort+".png";
        Resources r = getResources();
        int px = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 64, r.getDisplayMetrics()));
        Glide.with(this)
                .load(logoUrlTop ).apply(new RequestOptions()
                .placeholder(R.drawable.school)
                .override(px*2,2*px))
                .into(imageButtonTop);

        Glide.with(this)
                .load(logoUrlBot ).apply(new RequestOptions()
                .placeholder(R.drawable.school)
                .override(px*2,2*px))
                .into(imageButtonBot);


        return rootView;
    }



}