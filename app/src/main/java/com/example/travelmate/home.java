package com.example.travelmate;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void news (View view){
        Intent news = new Intent(home.this, news.class);
        startActivity(news);
    }
    public void travel (View view){
        Intent travel = new Intent(home.this, MapsActivity.class);
        startActivity(travel);
    }
    public void Learn (View view){
        Intent browserIntent1 = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://developers.google.com/training/android/"));
        startActivity(browserIntent1);
    }
}
