package com.example.oem.mntc_app;


import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        Calendar calendar = Calendar.getInstance();
        today = mdformat.format(calendar.getTime());

        Log.i(TAG, "Debug: today: "+today);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        events_dates = getResources().getStringArray(R.array.event_individual_dates);
        events_times = getResources().getStringArray(R.array.event_individual_time);
        events_images = getResources().getStringArray(R.array.event_individual_images);
        events_descriptions = getResources().getStringArray(R.array.event_individual_description);
        events_venues = getResources().getStringArray(R.array.event_individual_venues);
        int size = events_dates.length;
        events all[] = new events[size];
        for(int i=0;i<size;i++)
        {
            all[i]= new events();
        }
        int sorted[] = new int[size];
        int differences[] = new int[size];
        for(int i=0;i<size;i++)
        {
            all[i].setEvents_date(events_dates[i]);
            all[i].setEvents_time(events_times[i]);
            all[i].setEvents_image(events_images[i]);
            all[i].setEvents_description(events_descriptions[i]);
            all[i].setEvents_venue(events_venues[i]);
            sorted[i]=0;
        }
        Log.i(TAG,"Today: "+today);
//        final ListView list = (ListView) findViewById(android.R.id.list);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this,Event_independent_activity.class);
//                intent.putExtra("VENUE",events_venue[Integer.valueOf(list.getItemAtPosition(position).toString())]);
//                intent.putExtra("DATE",events_dates[Integer.valueOf(list.getItemAtPosition(position).toString())]);
//                intent.putExtra("IMG",images[Integer.valueOf(list.getItemAtPosition(position).toString())]);
//                intent.putExtra("TIME",events_time[Integer.valueOf(list.getItemAtPosition(position).toString())]);
//                intent.putExtra("DESCRIPTION",events_description[Integer.valueOf(list.getItemAtPosition(position).toString())]);
//                startActivity(intent);
//            }
//        });
//
//        MyAdapter adapter = new MyAdapter(this,images);
//        list.setAdapter(adapter);
//
//    }
//
//    class MyAdapter extends ArrayAdapter<String>{
//        Context context;
//        public String[] imgs;
//        MyAdapter(Context c,String[] imgs){
//            super(c,R.layout.list_single,R.id.event_icon,events_images);
//            this.context=c;
//            this.imgs = imgs;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent){
//            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View row = layoutInflater.inflate(R.layout.list_single,parent,false);
//            ImageView image =row.findViewById(R.id.event_icon);
//            image.setImageResource(Integer.valueOf(imgs[position]));
//            return row;
//        }
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
