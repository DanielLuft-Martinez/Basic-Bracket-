package com.example.daniel.basicbracketpicker;

import android.app.Application;

public class MyApp extends Application {



    public String[] Brack = new String[128];
    public String[] brackShort = new String[128];
    public Boolean[] decided = new Boolean[64];// sections held in reverse order  --- first deceison made at 32, second at 33 etc--- then first of second round is at 16, second at 17 etc--- based on num pages... kinda
    public int round = 1;

    public boolean firstLoad = true;


    public String[] getBrack(){
        return Brack;
    }
    public String[] getBrackShort(){
        return brackShort;
    }

    public Boolean[] getDecided() {
        return decided;
    }

    public int getRound() {
        return round;
    }

    public void setBrack(String[] brack){
        this.Brack = brack;
    }

    public void setBrackShort(String[] brackShort) {
        this.brackShort = brackShort;
    }

    public void setDecided(Boolean[] decided) {
        this.decided = decided;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
