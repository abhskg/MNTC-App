package com.example.oem.mntc_app;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the id of the CardView and attach an onClickListener to it
//        findViewById(R.id.one).setOnClickListener(this);
    }




    @Override
    public void onClick(View view) {
        if(view.getId()!=0)
        {
            //Do something Like starting an activity
            Intent intent = new Intent(MainActivity.this, Event_independent_activity.class);
            intent.putExtra("VENUE","R.string."+view.getId()+"_venue");
            intent.putExtra("DATE","R.string."+view.getId()+"_date");
            intent.putExtra("IMG","R.string."+view.getId()+"_img");
            intent.putExtra("TIME","R.string."+view.getId()+"_time");
            intent.putExtra("DESCRIPTION","R.string."+view.getId()+"_description");
            startActivity(intent);
        }
    }
}
