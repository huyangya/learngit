package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class newsActivity extends AppCompatActivity
{

    private List<News> newsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initnews();
        ListView listView = (ListView) findViewById(R.id.listview);
        NewsAdapter adapter = new NewsAdapter(newsActivity.this, R.layout.newsui, newsList);
        listView.setAdapter(adapter);
    }

    public void initnews()
    {
        News news1 = new News("11111111",R.drawable.p1);
        newsList.add(news1);
        News news2 = new News("2222221",R.drawable.p2);
        newsList.add(news2);
    }
}
