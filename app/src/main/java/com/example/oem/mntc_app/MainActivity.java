package com.example.oem.mntc_app;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the id of the CardView and attach an onClickListener to it
        //findViewById(R.id.main_activity_event_scroller).setOnClickListener(this);

        // Drawer layout declaration
        mDrawerLayout = findViewById(R.id.drawer_layout);

        // Recycler View Declarartion
        mRecyclerView = (RecyclerView) findViewById(R.id.main_activity_event_scroller);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        String[] myDataset;
        //mAdapter = new MyAdapter(myDataset);
       // mRecyclerView.setAdapter(mAdapter);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));
        actionbar.setHomeAsUpIndicator(R.drawable.ic_launcher_foreground);



        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
    }



        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:
                    mDrawerLayout.openDrawer(GravityCompat.START);
                    return true;
            }
            return super.onOptionsItemSelected(item);
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
