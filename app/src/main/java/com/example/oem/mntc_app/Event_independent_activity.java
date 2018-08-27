
package com.example.oem.mntc_app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Event_independent_activity extends AppCompatActivity {

    private static final String TAG = "Event_independent_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_independent_activity);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();

        TextView description = (TextView) findViewById(R.id.event_text);
        TextView date = (TextView) findViewById(R.id.event_date);
        ImageView img = (ImageView) findViewById(R.id.event_img);
        TextView time = (TextView) findViewById(R.id.event_time);
        TextView venue = (TextView) findViewById(R.id.event_venue);

        String getdate = (String) data.getString("DATE");
        String gettime = (String) data.getString("TIME");
        String getvenue = (String) data.getString("VENUE");
        String getdescription = (String) data.getString("DESCRIPTION");
        String getimg = (String) data.getString("IMG");

        venue.setText(getvenue);
        time.setText(gettime);

        Drawable image = getResources().getDrawable(Integer.valueOf(getimg));

        img.setImageDrawable(image);

        date.setText(getdate);
        description.setText(getdescription);

    }
}
