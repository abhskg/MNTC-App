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
        /*Enter your url for the test here*/
        webview.loadUrl("");
        webview.setHorizontalScrollBarEnabled(false);
        webview.setVerticalScrollBarEnabled(true);
    }
}
