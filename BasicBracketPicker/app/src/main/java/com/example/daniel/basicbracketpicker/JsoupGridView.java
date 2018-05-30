package com.example.daniel.basicbracketpicker;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.daniel.basicbracketpicker.MainActivity;
import com.example.daniel.basicbracketpicker.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static java.security.AccessController.getContext;

public class JsoupGridView extends AsyncTask<Object, Integer, Void> {
    GridView gridView;

    Elements logos;

    Context context;
    View view;





    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        //progress bar in future


    }

    @Override
    protected Void doInBackground(Object... obj) {
        // Create an array
        //  ArrayList arraylist = new ArrayList<Element>();
        this.context = (Context) obj[1];
        this.view = (View) obj[0];

        try {
            // Connect to the Website URL
            Document doc = Jsoup.connect("https://www.cbssports.com/college-basketball/news/2018-ncaa-tournament-field-ranking-64-teams-march-madness-bracket/").get();
             logos = doc.select("img.team-logo-small");



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // Locate the listview in listview_main.xml

        gridView =  view.findViewById(R.id.gridTeam);
        GridViewAdapter adapter = new GridViewAdapter(context, R.layout.activity_team_grid, logos);
        gridView.setAdapter(adapter);


    }
}
