package com.example.travelmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class news extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    }
    public void Entertainment (View view){
        Intent news = new Intent(news.this, Entertainmentnews.class);
        startActivity(news);
    }
    public void health (View view){
        Intent news2 = new Intent(news.this, health.class);
        startActivity(news2);
    }
    public void business (View view){
        Intent news3 = new Intent(news.this, business.class);
        startActivity(news3);
    }
    public void sports (View view){
        Intent news4 = new Intent(news.this, sports.class);
        startActivity(news4);
    }
}
