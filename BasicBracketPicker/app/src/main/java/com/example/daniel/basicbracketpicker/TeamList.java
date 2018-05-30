package com.example.daniel.basicbracketpicker;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TeamList extends AppCompatActivity {

    String url = "https://www.cbssports.com/college-basketball/news/2018-ncaa-tournament-field-ranking-64-teams-march-madness-bracket/";
    String classPNG = "team-logo-small";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
        //illeagal
        Document document = Jsoup.parse(url);
        Elements logos = document.select("img.team-logo-small");

    }
}
