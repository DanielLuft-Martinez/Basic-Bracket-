package com.example.daniel.basicbracketpicker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HeadPagerFragmentActivity extends android.support.v7.app.AppCompatActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    int NUM_PAGES = 32;
    String Brack[];
    String brackShort[];
    Menu menu;
    int pickSpeedToggle = 1;
    //int round = 1;
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
        setContentView(R.layout.activity_head_to_head);

        // setHasOptionsMenu(true);


        //Intent intent = getIntent();
        this.Brack = ((MyApp) this.getApplication()).Brack;
        this.brackShort = ((MyApp) this.getApplication()).brackShort;
        this.Round = ((MyApp) this.getApplication()).getRound();
        roundSelect();

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pagerHead);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_head, menu);
        this.menu = menu;
        getSupportActionBar().setTitle("Round: "+((MyApp)this.getApplication()).getRound());
        currentRoundPicked(null);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int pos = mPager.getCurrentItem();

        Intent i;
        switch (item.getItemId()) {
            case R.id.action_home:
                //save
                //go to main menu
                finish();
                return true;

            case R.id.action_return_last:
                Log.d("Round", ""+Round);
                clearCurrentPicks();
                setRoundBack();
                if(Round>3){
                    clearCurrentPicks();
                }
                mPager.setAdapter(mPagerAdapter);
                mPager.setCurrentItem(0);
                this.invalidateOptionsMenu();
                return true;

            case R.id.action_clear:
                clearCurrentPicks();
                mPager.setAdapter(mPagerAdapter);
                mPager.setCurrentItem(0);
                return true;

            case R.id.action_copy:
                //clipboard feature cut

                return true;
            case R.id.action_toggle_pick_speed:
                if(pickSpeedToggle == 1){
                    pickSpeedToggle = 0;
                    item.setIcon(R.drawable.ic_fast_forward_white_24dp);
                }else{
                    pickSpeedToggle = 1;
                    item.setIcon(R.drawable.ic_swap_horiz_white_24dp);
                }

                return true;

            case R.id.action_commit:

                Log.d("Round", ""+Round);

                if(currentRoundPicked(item)){

                    if(Round == 6){
                        //do nothing
                    }else{
                        Round = Round+1;

                        ((MyApp)this.getApplication()).setRound(Round);
                        roundSelect();

                        mPager.setAdapter(mPagerAdapter);
                        mPager.setCurrentItem(0);


                        item.setIcon(R.drawable.ic_check_black_24dp);
                        this.invalidateOptionsMenu();
                    }


                }
                //getActionBar().setTitle("Round: "+((MyApp)this.getApplication()).getRound());


                return true;


        }
        return onOptionsItemSelected(item);
    }

    private void setRoundBack() {

        if (Round == 1) {
            //nothing
        } else {
            currentRoundPicked(null);
            Round = Round - 1;
            ((MyApp) this.getApplication()).setRound(Round);
            roundSelect();
        }
        currentRoundPicked(null);
    }

    private void clearCurrentPicks() {
        Boolean[] ded = ((MyApp) this.getApplication()).getDecided();
        switch (Round) {
            case 1:
                for (int i = (NUM_PAGES); i < (NUM_PAGES*2); i++) {
                    Brack[i] = null;
                    brackShort[i] = null;
                }
                for (int i = NUM_PAGES; i < (NUM_PAGES*2); i++) {
                    ded[i] = false;
                }
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 2:
                for (int i = (NUM_PAGES); i < (NUM_PAGES*2); i++) {
                    Brack[i] = null;
                    brackShort[i] = null;
                }
                for (int i = NUM_PAGES; i < (NUM_PAGES*2); i++) {
                    ded[i] = false;
                }
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 3:
                for (int i = (NUM_PAGES); i < (NUM_PAGES*2); i++) {
                    Brack[i] = null;
                    brackShort[i] = null;
                }
                for (int i = NUM_PAGES; i < (NUM_PAGES*2); i++) {
                    ded[i] = false;
                }
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 4:
                for (int i = (NUM_PAGES); i < (NUM_PAGES*2); i++) {
                    Brack[i] = null;
                    brackShort[i] = null;
                }
                for (int i = NUM_PAGES; i < (NUM_PAGES*2); i++) {
                    ded[i] = false;
                }
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 5:
                for (int i = (NUM_PAGES); i < (NUM_PAGES*2); i++) {
                    Brack[i] = null;
                    brackShort[i] = null;
                }
                for (int i = NUM_PAGES; i < (NUM_PAGES*2); i++) {
                    ded[i] = false;
                }
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 6:
                for (int i = (NUM_PAGES); i < (NUM_PAGES*2); i++) {
                    Brack[i] = null;
                    brackShort[i] = null;
                }
                for (int i = NUM_PAGES; i < (NUM_PAGES*2); i++) {
                    ded[i] = false;
                }
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            default:
                for (int i = 64; i < 96; i++) {
                    Brack[i] = null;
                    brackShort[i] = null;
                }
                for (int i = 32; i < 64; i++) {
                    ded[i] = false;
                }
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;


        }

        currentRoundPicked(null);
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(0);
    }


    private void roundSelect() {


        // rethink round select

        switch (((MyApp) this.getApplication()).getRound()) {
            case 1:
                Round = 1;
                NUM_PAGES = 32;
                break;
            case 2:
                Round = 2;
                NUM_PAGES = 16;
                break;
            case 3:
                Round = 3;
                NUM_PAGES = 8;
                break;
            case 4:
                Round = 4;
                NUM_PAGES = 4;
                break;
            case 5:
                Round = 5;
                NUM_PAGES = 2;
                break;
            case 6:
                Round = 6;
                NUM_PAGES = 1;
                break;
            default:
                Round = 1;
                NUM_PAGES = 32;
                break;


        }


    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {


            if (((MyApp) getApplication()).getDecided()[NUM_PAGES + position] != null && ((MyApp) getApplication()).getDecided()[NUM_PAGES + position]) {
                Bundle bundle = new Bundle();
                bundle.putInt("pos", position);
                bundle.putInt("round", Round);
                bundle.putInt("numP", NUM_PAGES);
                bundle.putStringArray("teams", Brack);
                bundle.putStringArray("teamsShort", brackShort);

                HeadCommitFragment fragment = new HeadCommitFragment();

                fragment.setArguments(bundle);

                return fragment;
            } else {
                Bundle bundle = new Bundle();
                bundle.putInt("pos", position);
                bundle.putInt("round", Round);
                bundle.putInt("numP", NUM_PAGES);
                bundle.putStringArray("teams", Brack);
                bundle.putStringArray("teamsShort", brackShort);

                HeadToHeadFragment fragment = new HeadToHeadFragment();

                fragment.setArguments(bundle);

                return fragment;
            }
            //  return fragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }


    }


    void onClickTop(View view) {

        //write winner to propper location
        // call winner pop, let it take care of itself
        int pos = mPager.getCurrentItem();
        Log.d("Current Pos clicked", "" + pos);
        // TextView textView = getResources
        switch (Round) {
            case 1:

                Brack[NUM_PAGES + pos] = Brack[64+pos];
                brackShort[NUM_PAGES + pos] = brackShort[64+pos];
                Boolean[] ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
             //   Log.d("Picked", ":\nPos: "+pos+"\nLocal Brack: "+Brack[64+pos]+"\tGlobal Brack: "+((MyApp) this.getApplication()).getBrack()[64+pos]+"\nLocal ded: "+ded[NUM_PAGES+pos]+"\tGlobal Decided: "+((MyApp) this.getApplication()).getDecided()[NUM_PAGES+pos]);
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 2:
                Brack[NUM_PAGES + pos] = Brack[32 + pos];
                brackShort[NUM_PAGES + pos] = brackShort[32 + pos];
                ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 3:
                Brack[NUM_PAGES + pos] = Brack[16 + pos];
                brackShort[NUM_PAGES + pos] = brackShort[16 + pos];
                ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 4:
                Brack[NUM_PAGES + pos] = Brack[8 + pos];
                brackShort[NUM_PAGES + pos] = brackShort[8 + pos];
                ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 5:
                Brack[NUM_PAGES + pos] = Brack[4 + pos];
                brackShort[NUM_PAGES + pos] = brackShort[4 + pos];
                ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 6:
                Brack[NUM_PAGES] = Brack[2 + pos];
                brackShort[NUM_PAGES] = brackShort[2 + pos];
                ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            default:
                Brack[NUM_PAGES + pos] = Brack[pos];
                brackShort[NUM_PAGES + pos] = brackShort[pos];
                ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;


        }


        currentRoundPicked(null);
        mPager.setAdapter(mPagerAdapter);

        if (pos==NUM_PAGES-1){
            mPager.setCurrentItem(pos);
        }else{
            mPager.setCurrentItem(pos+pickSpeedToggle);
        }


    }

    void onClickBot(View view) {

        //write winner to propper location
        // call winner pop, let it take care of itself
        int pos = mPager.getCurrentItem();
        Log.d("Current Pos clicked", "" + pos);
        // TextView textView = getResources
        switch (Round) {
            case 1:
                Brack[NUM_PAGES + pos] = Brack[96+ pos];
                brackShort[NUM_PAGES + pos] = brackShort[96 + pos];
                Boolean[] ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 2:
                Brack[NUM_PAGES + pos] = Brack[48 + pos];
                brackShort[NUM_PAGES + pos] = brackShort[48 + pos];
                ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 3:
                Brack[NUM_PAGES + pos] = Brack[24 + pos];
                brackShort[NUM_PAGES + pos] = brackShort[24 + pos];
                ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 4:
                Brack[NUM_PAGES + pos] = Brack[12 + pos];
                brackShort[NUM_PAGES + pos] = brackShort[12 + pos];
                ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 5:
                Brack[NUM_PAGES + pos] = Brack[6 + pos];
                brackShort[NUM_PAGES + pos] = brackShort[6 + pos];
                ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            case 6:
                Brack[NUM_PAGES] = Brack[3 + pos];
                brackShort[NUM_PAGES] = brackShort[3 + pos];
                ded = ((MyApp) this.getApplication()).getDecided();
                ded[NUM_PAGES + pos] = true;
                ((MyApp) this.getApplication()).setDecided(ded);
                ((MyApp) this.getApplication()).setBrack(Brack);
                ((MyApp) this.getApplication()).setBrackShort(brackShort);
                break;
            default:
                Round = 1;
                NUM_PAGES = 32;
                break;


        }
        currentRoundPicked(null);
        mPager.setAdapter(mPagerAdapter);
        if (pos==NUM_PAGES-1){
            mPager.setCurrentItem(pos);
        }else{
            mPager.setCurrentItem(pos+pickSpeedToggle);
        }

    }

    public void onClickRepick(View view) {
        int pos = mPager.getCurrentItem();
        Boolean[] ded = ((MyApp) this.getApplication()).getDecided();
        ded[NUM_PAGES + pos] = false;
        Brack[NUM_PAGES + pos] = " ";
        brackShort[NUM_PAGES + pos] = " ";
        ((MyApp) this.getApplication()).setBrack(Brack);
        ((MyApp) this.getApplication()).setBrackShort(brackShort);
        ((MyApp) this.getApplication()).setDecided(ded);
        currentRoundPicked(null);
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(pos);
    }

    public Boolean currentRoundPicked(MenuItem item) {

        Boolean[] ded = ((MyApp) this.getApplication()).getDecided();
        Boolean isIt = true;
        switch (Round) {

            case 1:

                for (int i = 32; i < 64; i++) {
                    if (ded[i]!=null&&!ded[i]) {
                        isIt = false;
                    }
                }
                break;
            case 2:

                for (int i = 16; i < 32; i++) {
                    if (ded[i]!=null&&!ded[i]) {
                        isIt = false;
                    }
                }

                break;
            case 3:
                for (int i = 8; i < 16; i++) {
                    if (ded[i]!=null&&!ded[i]) {
                        isIt = false;
                    }
                }
                break;
            case 4:

                for (int i = 4; i < 8; i++) {
                    if (ded[i]!=null&&!ded[i]) {
                        isIt = false;
                    }
                }
                break;
            case 5:

                for (int i = 2; i < 4; i++) {
                    if (ded[i]!=null&&!ded[i]) {
                        isIt = false;
                    }
                }
                break;
            case 6:

                for (int i = 1; i < 2; i++) {
                    if (ded[i]!=null&&!ded[i]) {
                        isIt = false;
                    }
                }
            default:

                for (int i = 32; i < 64; i++) {
                    if (ded[i]!=null&&!ded[i]) {
                        isIt = false;
                    }
                }
                break;


        }

         if(item!=null){
        if(isIt){
           // item.setEnabled(true);
            item.setIcon(R.drawable.ic_check_green_24dp);
        }else{
          //  item.setEnabled(false);
            item.setIcon(R.drawable.ic_check_black_24dp);
        }
        }else{

            //ActionMenuItemView Item = findViewById(R.id.action_commit);
             if(isIt){
                 // item.setEnabled(true);
                 Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_check_green_24dp);
                 menu.getItem(4).setIcon(drawable);
                 //Item.setIcon(R.drawable.ic_check_green_24dp);
             }else{
                 //  item.setEnabled(false);
                 Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_check_black_24dp);
                 menu.getItem(4).setIcon(drawable);
                // Item.setIcon(R.drawable.ic_check_blue_24dp);
             }

         }

        return isIt;
    }

    @Override
    public void onPause(){
        super.onPause();
        saveInfo(getApplicationContext());

    }

    @Override
    public void onResume(){
        super.onResume();
      //  currentRoundPicked(null);
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
        Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show();


    }

}