package com.example.oem.mntc_app;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

public class SplashLoginActivity extends AppCompatActivity {

    RelativeLayout splash_rel_lay1, splash_rel_lay2;

    Handler handler = new Handler () ;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            splash_rel_lay1.setVisibility(View.VISIBLE);
            splash_rel_lay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_login);

        splash_rel_lay1 = (RelativeLayout) findViewById(R.id.splash_rel_lay1);
        splash_rel_lay2 = (RelativeLayout) findViewById(R.id.splash_rel_lay2);

        handler.postDelayed(runnable, delayMillis : 1500 );  // 1.5 second delay

    }

}
