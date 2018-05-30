package com.example.daniel.basicbracketpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import org.apache.commons.lang3.ObjectUtils;

public class TeamGrid extends AppCompatActivity {

    GridView gridView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_grid);

        gridView = findViewById(R.id.gridTeam);

        Object[] objs = new Object[2];
        objs[0] = gridView;
        objs[1] = this.getBaseContext();

        new JsoupGridView().execute(objs);


    }
}
