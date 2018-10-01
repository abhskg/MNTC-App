package com.example.oem.mntc_app;

import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView email = (TextView) findViewById(R.id.profile_email);
        ImageView image = (ImageView) findViewById(R.id.profile_image);
        TextView mobile = (TextView) findViewById(R.id.profile_mobile);
        TextView name = (TextView) findViewById(R.id.profile_name);
        TextView score = (TextView) findViewById(R.id.profile_score);
        TextView participation = (TextView) findViewById(R.id.profile_participation);
        TextView attempted = (TextView) findViewById(R.id.profile_attempted);

        image.setImageResource();
        name.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        mobile.setText(FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber());
        email.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());


        score.setText();
        participation.setText();
        attempted.setText();
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
    }
}
