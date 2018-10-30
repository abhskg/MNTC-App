//package com.example.oem.mntc_app;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.drawable.Icon;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.google.firebase.auth.FirebaseAuth;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//
//public class ProfileActivity extends AppCompatActivity {
//
//    SQLiteDatabase db;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);
//
//        TextView email = (TextView) findViewById(R.id.profile_email);
//        ImageView imageview1 = (ImageView) findViewById(R.id.profile_image);
//        TextView mobile = (TextView) findViewById(R.id.profile_mobile);
//        TextView name = (TextView) findViewById(R.id.profile_name);
//        TextView score = (TextView) findViewById(R.id.profile_score);
//        TextView participation = (TextView) findViewById(R.id.profile_participation);
//        TextView attempted = (TextView) findViewById(R.id.profile_attempted);
//
//        db = this.openOrCreateDatabase("image.db", Context.MODE_PRIVATE, null);
//        db.execSQL("create table if not exists tb (a blob)");
//
//        name.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
//        mobile.setText(FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber());
//        email.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
//
//        getImage(imageview1);
//        score.setText();
//        participation.setText();
//        attempted.setText();
//    }
//
//    public void logout(View view) {
//        FirebaseAuth.getInstance().signOut();
//    }
//
//    public void getImage(View view)
//    {
//        Bitmap bm = BitmapFactory.decodeFile("");
////        view
//    }
//
//    public void saveImage(View view)
//    {
//        try {
////            FileInputStream fis = new FileInputStream("/storage/MNTC/profile.jpg");
////            byte[] image = new byte[fis.available()];
////            fis.read(image);
////
////            ContentValues values = new ContentValues();
////            values.put("a", image);
////            db.insert("tb", null, values);
//            FileOutputStream fos = new FileOutputStream("MNTC_profile.jpg", Context.MODE_PRIVATE);
//            fos.write();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//}