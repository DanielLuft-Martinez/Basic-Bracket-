package com.example.daniel.basicbracketpicker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Bracket extends AppCompatActivity {


    int NUM_PAGES = 32;
    String Brack[];
    String brackShort[];
    Menu menu;

    //int round = 1;
    int NUM_TABS = 7;
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    private int Round = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracket);


        this.Brack = ((MyApp) this.getApplication()).Brack;
        this.brackShort = ((MyApp) this.getApplication()).brackShort;
//        this.Round = ((MyApp) this.getApplication()).getRound();
//        roundSelect();
//
//        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pagerBrack);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);


    }

    // 4 regions

    // meh
    // each region is 16 teams
    // each team plays seed 17 minus its seed


    // probably not the implementation I wanna go with, just how I'm thinking about it for now
            // should be:
            // LOGO
            // Name

    // Sizing will be an issue


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_brack, menu);
        this.menu = menu;
        getSupportActionBar().setTitle("My Bracket");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int pos = mPager.getCurrentItem();


        switch (item.getItemId()) {
            case R.id.action_home:
                //save
                //go to main menu
                finish();
                return true;


           // return onOptionsItemSelected(item);
        }
        return true;
    }


    @Override
    public void onBackPressed() {
//        if (mPager.getCurrentItem() == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//            super.onBackPressed();
//        } else {
//            // Otherwise, select the previous step.
//            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
//        }
        super.onBackPressed();
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {



                Bundle bundle = new Bundle();
                bundle.putInt("pos", position);
                bundle.putInt("round", position);
              //  bundle.putInt("numP", NUM_PAGES);
                bundle.putStringArray("teams", Brack);
                bundle.putStringArray("teamsShort", brackShort);

               BracketPageFragment fragment = new BracketPageFragment();

                fragment.setArguments(bundle);

                return fragment;

            //  return fragment;
        }

        @Override
        public int getCount() {
            return NUM_TABS;
        }


    }

   /* @Override
    public void onDestroy(){
        saveInfo();
        super.onDestroy();
    }*/
    @Override
    public void onPause(){
        super.onPause();
        saveInfo(getApplicationContext());

    }


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

      //  editor.apply();
        editor.commit();
        // Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show();
        // where am i?

    }
}
