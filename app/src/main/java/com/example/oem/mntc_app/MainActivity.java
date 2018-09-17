package com.example.oem.mntc_app;


import android.app.ListActivity;
import android.content.Context;
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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import static android.support.v4.content.res.TypedArrayUtils.getResourceId;


public class MainActivity extends ListActivity {

    //Debugging code
    private static final String TAG = MainActivity.class.getSimpleName();
    SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd");
    String today = "";
    String[] events_dates;
    String[] events_time;
    String[] events_images;
    String[] events_description;
    String[] events_venue;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        today = mdformat.format(calendar.getTime());


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        events_dates = getResources().getStringArray(R.array.event_individual_dates);
        int size = events_dates.length;
        events_time = getResources().getStringArray(R.array.event_individual_time);
        events_images = getResources().getStringArray(R.array.event_individual_images);
        events_description = getResources().getStringArray(R.array.event_individual_description);
        events_venue = getResources().getStringArray(R.array.event_individual_venues);


        /*Variables required for sorting data for list view Android*/
        int changed[] = new int[size];
        int diff[] = new int[size];
        int diff_sorted[] = new int[size];
        int count[] = new int[2001];
        int count_d[] = new int[2001];


        for(int i=0;i<2001;i++)
        {
            count[i]=0;
            count_d[i]=0;
        }
        int done[] = new int[size];
        int duplicate[] = new int[size];
        String yeari = "";
        String yearj = "";
        String monthi = "";
        String monthj = "";
        String dayi = "";
        String dayj = "";


        yearj = today.substring(0,4);
        monthj = today.substring(7, 9);
        dayj = today.substring(12);
        for(int i=0;i<size;i++)
        {
            yeari = events_dates[i].substring(6);
            monthi = events_dates[i].substring(3, 5);
            dayi = events_dates[i].substring(0, 2);

            //Error with tracking number of days to even
            diff[i]=(((Integer.valueOf(yeari)-1)*12*30)+((Integer.valueOf(monthi)-1)*30)+(Integer.valueOf(dayi)-1)-((Integer.valueOf(yearj)-1)*12*30)-((Integer.valueOf(monthj)-1)*30)-((Integer.valueOf(dayj)-1)));
            diff_sorted[i]=diff[i];
            count[diff[i]+1000]++;
            duplicate[i]=diff[i];
            System.out.println(yeari);
        }
        Arrays.sort(diff_sorted);
        int count1=0;
        for(int i=0;i<size;i++)
        {
            if(diff_sorted[i]>=0)
            {
                diff[count1]=diff_sorted[i];
                count1++;
            }
        }
        for(int i=0;i<size;i++)
        {
            if(diff_sorted[i]<0)
            {
                diff[count1]=diff_sorted[i];
                count1++;
            }
        }
        int add=0;
        int flag=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                flag=0;
                add=0;
                if((count_d[duplicate[i]+1000])-(count[duplicate[i]+1000])>0)
                {
                    add=(count_d[duplicate[i]+1000])-(count[duplicate[i]+1000]);
                }
                if(duplicate[i]==diff[j])
                {
                    changed[i]=j+add;
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                break;
            }
        }

        String ans;
        for(int i=0;i<size/2;i++){
            ans=events_images[i];
            events_images[i] = events_images[changed[i]];
            events_images[changed[i]]=ans;

            ans=events_time[i];
            events_time[i] = events_time[changed[i]];
            events_time[changed[i]]=ans;

            ans=events_description[i];
            events_description[i] = events_description[changed[i]];
            events_description[changed[i]]=ans;

            ans=events_venue[i];
            events_venue[i] = events_venue[changed[i]];
            events_venue[changed[i]]=ans;
        }
        final String[] images = new String[size];
        for(int i=0;i<size;i++){
            images[i] = Integer.toString(getResources().getIdentifier(events_images[i],"drawable",getPackageName()));
            //The above images is a string
        }
        final ListView list = (ListView) findViewById(android.R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Event_independent_activity.class);
                intent.putExtra("VENUE",events_venue[Integer.valueOf(list.getItemAtPosition(position).toString())]);
                intent.putExtra("DATE",events_dates[Integer.valueOf(list.getItemAtPosition(position).toString())]);
                intent.putExtra("IMG",images[Integer.valueOf(list.getItemAtPosition(position).toString())]);
                intent.putExtra("TIME",events_time[Integer.valueOf(list.getItemAtPosition(position).toString())]);
                intent.putExtra("DESCRIPTION",events_description[Integer.valueOf(list.getItemAtPosition(position).toString())]);
                startActivity(intent);
            }
        });

        MyAdapter adapter = new MyAdapter(this,images);
        list.setAdapter(adapter);

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        public String[] imgs;
        MyAdapter(Context c,String[] imgs){
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
