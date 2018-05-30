package com.example.daniel.basicbracketpicker;

import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements  AsyncResponse{


    JsoupBrackFill JBF = new JsoupBrackFill();

    public String[] Brack = new String[128];
    public String[] brackShort = new String[128];



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(((MyApp) getApplication()).firstLoad){
        //possibly add a null check to not keep getting data
        JBF.delegate = this;

        JBF.execute();

        Boolean ded[] = new Boolean[64];
        for(int i = 0; i<ded.length; i++){
            ded[i] = false;
        }
        ((MyApp) this.getApplication()).setDecided(ded);
            ((MyApp) getApplication()).firstLoad = false;
        }else{
            loadInfo(getApplicationContext());
        }
        getSupportActionBar().setTitle("Basic Bracket Picker");

    }


    public void onClickHead(View view) {
        Intent intent = new Intent(this, HeadPagerFragmentActivity.class);
      //  Bundle bundle = new Bundle();

    /*    for(String name : Brack){

            Log.d("Whats in the Box", ""+name);

        }*/
        intent.putExtra("teams", Brack);
        intent.putExtra("teamsShort",brackShort);
        startActivity(intent);
    }

    public void onClickBracket(View view) {

        Intent intent = new Intent(this, Bracket.class);
        Bundle bundle = new Bundle();



        startActivity(intent);

    }

    public void onClickSettings(View view) {

    }

    public void onClickGrid(View view) {

        Intent intent = new Intent(this, TeamGrid.class);
        startActivity(intent);

    }

    @Override
    public void processFinish(String[][] output) {
        for (int i = 64; i< output[0].length +64; i++) {
        Brack[i] = output[0][i-64];
        brackShort[i] = output[1][i-64];
        Log.d("Brack", "onCreate: "+ Brack[i]+ " " + (i));
        Log.d("Brack Short", "onCreate: "+ brackShort[i]+ " " + (i));
        }
        ((MyApp) this.getApplication()).setBrack(Brack);
        ((MyApp) this.getApplication()).setBrackShort(brackShort);


    }

    @Override
    public void onPause(){
        super.onPause();
        saveInfo(getApplicationContext());
    }

    @Override
    public void onResume(){
        super.onResume();
        if(((MyApp) getApplication()).firstLoad){
            //nothing
            ((MyApp) getApplication()).firstLoad = false;
        }else{
        loadInfo(getApplicationContext());

        }
    }

/*    @Override
    public void onDestroy(){
        saveInfo();
        super.onDestroy();
    }*/



    public void saveInfo(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.brack_pref), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        for(int i = 0; i <128; i++){
            editor.putString("Brack"+i,((MyApp)this.getApplication()).Brack[i]);
            editor.putString("brackShort"+i,((MyApp)this.getApplication()).brackShort[i]);
        }

        for(int i = 0; i<64; i++){
            editor.putBoolean("decided"+i, ((MyApp)this.getApplication()).decided[i]);
        }

        editor.putInt("round",((MyApp)this.getApplication()).round);

        editor.putBoolean("load",false);

       //editor.apply();
        editor.commit();
        Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show();


    }
//for tommorrow
    public void loadInfo(Context context){
        SharedPreferences sharedPreferences =  context.getSharedPreferences(context.getResources().getString(R.string.brack_pref), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        for(int i = 0; i <128; i++){
            ((MyApp)this.getApplication()).Brack[i]= sharedPreferences.getString("Brack"+i,"");
            ((MyApp)this.getApplication()).brackShort[i]= sharedPreferences.getString("brackShort"+i,"");
        }

        for(int i = 0; i<64; i++){
            ((MyApp)this.getApplication()).decided[i]= sharedPreferences.getBoolean("decided"+i,false);
        }

        ((MyApp)this.getApplication()).round= sharedPreferences.getInt("round",1);
        ((MyApp) getApplication()).firstLoad = sharedPreferences.getBoolean("load", false);

        this.Brack = ((MyApp) this.getApplication()).getBrack();
        this.brackShort =  ((MyApp) this.getApplication()).getBrackShort();


       //editor.apply();
        Toast.makeText(this,"loaded",Toast.LENGTH_SHORT).show();

    }

}


