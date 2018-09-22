package com.example.oem.mntc_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Test_view extends AppCompatActivity {
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view);
        webview = (WebView) findViewById(R.id.test_webview);
        webview.getSettings().setJavaScriptEnabled(true);
        //Only https enabled sites can be used in webview
        webview.loadUrl("https://knockknock.in.net");
        webview.setHorizontalScrollBarEnabled(false);
        webview.setVerticalScrollBarEnabled(true);
    }
}
