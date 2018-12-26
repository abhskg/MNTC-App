package com.example.oem.mntc_app;


import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MainActivity extends ListActivity {


    //Debugging code

    private static final String TAG = MainActivity.class.getSimpleName();
    SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd");
    String today = "";
    String[] events_dates;
    String[] events_times;
    String[] events_images;
    String[] events_descriptions;
    String[] events_venues;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        events_dates = getResources().getStringArray(R.array.event_individual_dates);
        events_times = getResources().getStringArray(R.array.event_individual_time);
        events_images = getResources().getStringArray(R.array.event_individual_images);
        events_descriptions = getResources().getStringArray(R.array.event_individual_description);
        events_venues = getResources().getStringArray(R.array.event_individual_venues);
        final String[] events_dates_duplicate = getResources().getStringArray(R.array.event_individual_dates);
        final String[] events_times_duplicate = getResources().getStringArray(R.array.event_individual_time);
        final String[] events_images_duplicate = getResources().getStringArray(R.array.event_individual_images);
        final String[] events_descriptions_duplicate = getResources().getStringArray(R.array.event_individual_description);
        final String[] events_venues_duplicate = getResources().getStringArray(R.array.event_individual_venues);
        int size = events_dates.length;
        events all[] = new events[size];
        for (int i = 0; i < size; i++) {
            all[i] = new events();
        }
        long duplicate[] = new long[size];
        long sorted[] = new long[size];
        long differences[] = new long[size];
        for (int i = 0; i < size; i++) {
            all[i].setEvents_date(events_dates[i]);
            all[i].setEvents_time(events_times[i]);
            all[i].setEvents_image(events_images[i]);
            all[i].setEvents_description(events_descriptions[i]);
            all[i].setEvents_venue(events_venues[i]);
            sorted[i] = 0;
        }

        Date today = new Date();
        Date now = new Date();

        /*Debugging the correct sequence of dates and time taken for sorting*/
//        Log.i(TAG, "Date Check: " + all[0].getEvents_date().substring(0, 2));
//        Log.i(TAG, "Date Check: " + all[0].getEvents_date().substring(3, 5));
//        Log.i(TAG, "Date Check: " + all[0].getEvents_date().substring(6,10));
//        Log.i(TAG, "Date Check: " + all[0].getEvents_time().substring(0, 2));
//        Log.i(TAG, "Date Check: " + all[0].getEvents_time().substring(3, 5));
//        Log.i(TAG, "Date Check: " + all[0].getEvents_time().substring(6, 8));
//        Log.i(TAG, "Date Check NOW: " + today);

        for(int i=0;i<size;i++)
        {
            @Deprecated
            Date date = new Date(Integer.valueOf(all[i].getEvents_date().substring(0,2)),Integer.valueOf(all[i].getEvents_date().substring(3,5)),Integer.valueOf(all[i].getEvents_date().substring(6,10)),Integer.valueOf(all[i].getEvents_time().substring(0,2)),Integer.valueOf(all[i].getEvents_time().substring(3,5)),Integer.valueOf(all[i].getEvents_time().substring(6,8)));
            long diff = today.getTime()-date.getTime();
            differences[i]=diff;
            duplicate[i]=diff;
        }
        Arrays.sort(differences);
        int limit_custom=0;
        for(int i=0;i<size;i++)
        {
            if (differences[i]>0)
            {
                limit_custom=i;
                break;
            }
        }
        int count=0;
        for(int i=limit_custom;i>0;i--)
        {
            //Differences in order of greatest to least if <0 for upcoming events
            sorted[count]=differences[i];
            count++;
        }
        for (int i=limit_custom;i<size;i++)
        {
            sorted[count]=differences[i];
            count++;
        }
        //Now changing the differences array into how each object shall be accesed
        //Events do not overlap now as they will be conducted during different time in a day
        //Events image data should contain the id of the resource
        for (int i=0;i<size;i++)
        {
            for(int j=i;j<size;j++)
            {
                if (sorted[i]==differences[j])
                {
                    events_dates_duplicate[i] = events_dates[j];
                    events_descriptions_duplicate[i] = events_descriptions[j];
                    events_images_duplicate[i] = events_images[j];
                    events_images_duplicate[i]= String.valueOf(this.getResources().getIdentifier(events_images_duplicate[i],"drawable",this.getPackageName()));
                    events_venues_duplicate[i] = events_venues[j];
                    events_times_duplicate[i] = events_times[j];
                }
            }
        }
        Log.i(TAG,"Image Data: "+events_images_duplicate[0]);

        final ListView list = (ListView) findViewById(android.R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Event_independent_activity.class);
                intent.putExtra("VENUE",events_venues_duplicate[Integer.valueOf(list.getItemAtPosition(position).toString())]);
                intent.putExtra("DATE",events_dates_duplicate[Integer.valueOf(list.getItemAtPosition(position).toString())]);
                intent.putExtra("IMG",events_images_duplicate[Integer.valueOf(list.getItemAtPosition(position).toString())]);
                intent.putExtra("TIME",events_times_duplicate[Integer.valueOf(list.getItemAtPosition(position).toString())]);
                intent.putExtra("DESCRIPTION",events_descriptions_duplicate[Integer.valueOf(list.getItemAtPosition(position).toString())]);
                startActivity(intent);
            }
        });

        MyAdapter adapter = new MyAdapter(this,events_images_duplicate);
        list.setAdapter(adapter);

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        public String[] imgs;
        MyAdapter(Context c, String[] imgs){
            super(c,R.layout.list_single,R.id.event_icon,events_images);
            this.context=c;
            this.imgs = imgs;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.list_single,parent,false);
            ImageView image =row.findViewById(R.id.event_icon);
            image.setImageResource(Integer.valueOf(imgs[position]));
            return row;
        }
    }

    /*Functions for activating intents on click on bottom navigation bar*/
    /*
Write the on click listener in xml code of menu and remove comments for this*/
public void online_events()
{
Intent online = new Intent(this,Test_view.class);
startActivity(online);
}
//
//public void about_us()
//{
//Intent about = new Intent(this,About_us.class);
//startActivity(about);
//}
//
//public void aavishkaar(MenuItem item)
//{
//Intent aavishkar = new Intent(this,Aavishkaar.class);
//startActivity(aavishkar);
//}
}