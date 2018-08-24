package com.example.oem.mntc_app;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    private ActionBar toolbar;


    //Debugging code
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = getSupportActionBar();

        //Loading the main activity fragment by default
        toolbar.setTitle("MNTC");

        // get the id of the CardView and attach an onClickListener to it
        findViewById(R.id.one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,String.valueOf(R.string.one_time));
                Intent intent = new Intent(MainActivity.this, Event_independent_activity.class);
                intent.putExtra("VENUE", getString(R.string.one_venue));
                intent.putExtra("DATE", getString(R.string.one_date));
                intent.putExtra("IMG", getString(R.string.one_img));
                intent.putExtra("TIME", getString(R.string.one_time));
                intent.putExtra("DESCRIPTION", getString(R.string.one_description));
                startActivity(intent);
            }
        });
//        findViewById(R.id.two).setOnClickListener(this);
//        findViewById(R.id.three).setOnClickListener(this);
//        findViewById(R.id.four).setOnClickListener(this);
//        findViewById(R.id.five).setOnClickListener(this);

    }

    /*Functions for activating intents on click on bottom navigation bar*/
    //Write the on click listener in xml code of menu and remove comments for this
//    public void online_events()
//    {
//        Intent online = new Intent(this,Online_event.class);
//        startActivity(online);
//    }
//
//    public void about_us()
//    {
//        Intent about = new Intent(this,About_us.class);
//        startActivity(about);
//    }
//
//    public void aavishkaar(MenuItem item)
//    {
//        Intent aavishkar = new Intent(this,Aavishkaar.class);
//        startActivity(aavishkar);
//    }

}
