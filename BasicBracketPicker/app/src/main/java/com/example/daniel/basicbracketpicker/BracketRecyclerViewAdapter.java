package com.example.daniel.basicbracketpicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class BracketRecyclerViewAdapter extends RecyclerView.Adapter<BracketRecyclerViewAdapter.BracketViewHolder> {
    int round = 0;
    Context context;
    Bundle bundle;

    public BracketRecyclerViewAdapter(Context context, int round, Bundle bundle) {
        this.round = round;
        this.context = context;
        this.bundle = bundle;
    }

    @NonNull
    @Override
    public BracketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_bracket_vs, null);
        BracketViewHolder viewHolder = new BracketViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BracketViewHolder holder, int position) {






        String topName = "Team Fail Top";
        String botName = "Team Fail Bot";
        String topNameShort = "Team Fail Top";
        String botNameShort = "Team Fail Bot";

        int pos = position;




       // Bundle bundle = this.getArguments();



        if (bundle != null) {
            switch (round) {
                case 0:
                    topName = bundle.getStringArray("teams")[(64) + pos];
                    botName =bundle.getStringArray("teams")[(64) + 32 + pos];
                    topNameShort =bundle.getStringArray("teamsShort")[(64) + pos];
                    botNameShort =bundle.getStringArray("teamsShort")[(64) + 32 + pos];
                    break;
                case 1:
                    topName =bundle.getStringArray("teams")[(32) + pos];
                    botName =bundle.getStringArray("teams")[(32) + 16 + pos];
                    topNameShort =bundle.getStringArray("teamsShort")[(32) + pos];
                    botNameShort =bundle.getStringArray("teamsShort")[(32) + 16 + pos];
                    break;
                case 2:
                    topName =bundle.getStringArray("teams")[(16) + pos];
                    botName =bundle.getStringArray("teams")[(16) + 8 + pos];
                    topNameShort =bundle.getStringArray("teamsShort")[(16) + pos];
                    botNameShort =bundle.getStringArray("teamsShort")[(16) + 8 + pos];
                    break;
                case 3:
                    topName =bundle.getStringArray("teams")[(8) + pos];
                    botName =bundle.getStringArray("teams")[(8) + 4 + pos];
                    topNameShort =bundle.getStringArray("teamsShort")[(8) + pos];
                    botNameShort =bundle.getStringArray("teamsShort")[(8) + 4 + pos];
                    break;
                case 4:
                    topName =bundle.getStringArray("teams")[(4) + pos];
                    botName =bundle.getStringArray("teams")[(4) + 2 + pos];
                    topNameShort =bundle.getStringArray("teamsShort")[(4) + pos];
                    botNameShort =bundle.getStringArray("teamsShort")[(4) + 2 + pos];
                    break;
                case 5:
                    topName =bundle.getStringArray("teams")[(2)];
                    botName =bundle.getStringArray("teams")[(2) + 1];
                    topNameShort =bundle.getStringArray("teamsShort")[(2)];
                    botNameShort =bundle.getStringArray("teamsShort")[(2) + 1];
                    break;
                case 6:
                    topName =bundle.getStringArray("teams")[(1)];
                    botName =bundle.getStringArray("teams")[(1 )];
                    topNameShort =bundle.getStringArray("teamsShort")[(1)];
                    botNameShort =bundle.getStringArray("teamsShort")[(1) ];
                    break;
                default:
                    topName =bundle.getStringArray("teams")[(64) + pos];
                    botName =bundle.getStringArray("teams")[(64) + 32 + pos];
                    topNameShort =bundle.getStringArray("teamsShort")[(64) + pos];
                    botNameShort =bundle.getStringArray("teamsShort")[(64) + 32 + pos];
                    break;


            }

        }




        holder.textViewTop.setText(topName);
        holder.textViewBot.setText(botName);
        holder.textViewNum.setText(""+(pos+1));

        String logoUrlTop ="https://sports.cbsimg.net/images/collegebasketball/logos/50x50/"+topNameShort+".png";
        String logoUrlBot ="https://sports.cbsimg.net/images/collegebasketball/logos/50x50/"+botNameShort+".png";
       Resources r = context.getResources();
        int px = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 64, r.getDisplayMetrics()));
        Glide.with(context)
                .load(logoUrlTop ).apply(new RequestOptions()
                .placeholder(R.drawable.school)
                .override(px,px))
                .into(holder.imageButtonTop);

        Glide.with(context)
                .load(logoUrlBot ).apply(new RequestOptions()
                .placeholder(R.drawable.school)
                .override(px,px))
                .into(holder.imageButtonBot);

    }


    @Override
    public int getItemCount() {
        switch (round) {
            case 0:
                return 32;

            case 1:
               return 16;

            case 2:
                return  8;

            case 3:
                return  4;

            case 4:
                return  2;

            case 5:
                return  1;

            case 6:
                return  1;

            default:
                return  1;



        }
    }

    class BracketViewHolder extends RecyclerView.ViewHolder {

        FrameLayout frameVs;
        ConstraintLayout constraintBrack;


        ImageButton imageButtonTop;
        ImageButton imageButtonBot;

        TextView textViewTop;
        TextView textViewBot;

        TextView textViewNum;





        public BracketViewHolder(View view) {
            super(view);
           this.frameVs = view.findViewById(R.id.frameBracketVs);
           this.constraintBrack = view.findViewById(R.id.constraintBrack);
           this.imageButtonTop = view.findViewById(R.id.imageButtonTopBrack);
           this.imageButtonBot = view.findViewById(R.id.imageButtonBotBrack);
           this.textViewTop = view.findViewById(R.id.textViewTopBrack);
           this.textViewBot = view.findViewById(R.id.textViewBotBrack);
           this.textViewNum =view.findViewById(R.id.textViewNum);


        }
    }
}

