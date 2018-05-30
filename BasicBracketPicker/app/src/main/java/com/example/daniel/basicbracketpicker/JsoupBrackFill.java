package com.example.daniel.basicbracketpicker;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupBrackFill extends AsyncTask<Void, Integer, String[][]> {


    String[] names;
    String[] shrtNames;
    public AsyncResponse delegate = null;



@Override
protected void onPreExecute() {
        super.onPreExecute();

        //progress bar in future


        }

@Override
protected String[][] doInBackground(Void... empty) {
        // Create an array
        //  ArrayList arraylist = new ArrayList<Element>();


        try {
        // Connect to the Website URL
        Document doc = Jsoup.connect("https://www.cbssports.com/college-basketball/news/2018-ncaa-tournament-field-ranking-64-teams-march-madness-bracket/").get();
        names = doc.select("div.team-name").eachText().toArray(new String[0]);


        shrtNames = doc.select("img.team-logo-small").eachAttr("src").toArray(new String[0]);
        for(int i = 0; i< shrtNames.length;i++){
            shrtNames[i] = shrtNames[i].substring(shrtNames[i].lastIndexOf("/"),shrtNames[i].lastIndexOf("."));
        }





        } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
       // empty[0] = names;
        String[][] both = new String[2][64];
        both[0] = names;
        both[1] = shrtNames;
        return both;

        }

@Override
protected void onPostExecute(String[][] result) {
        // Locate the listview in listview_main.xml

    Log.d("Check", "12");


    delegate.processFinish(result);



        }
}
