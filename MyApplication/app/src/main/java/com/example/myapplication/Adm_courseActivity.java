package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Adm_courseActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_course);
        initcrouse();
        ListView listView = (ListView)findViewById(R.id.bookList);
        BookAdapter bookAdapter = new BookAdapter(Adm_courseActivity.this,R.layout.course,courseList);
        listView.setAdapter(bookAdapter);
        Button button = (Button)findViewById(R.id.creat_course);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }

    private List<Course> courseList = new ArrayList<>();

    public void initcrouse()
    {
        Course course1 = new Course("马甲线养成",R.drawable.course1);
        courseList.add(course1);
        Course course2 = new Course("驼背改善",R.drawable.course2);
        courseList.add(course2);
        Course course3 = new Course("胸肌入门",R.drawable.course3);
        courseList.add(course3);
        Course course4 = new Course("手臂练习",R.drawable.course4);
        courseList.add(course4);
        Course course5 = new Course("跑步训练",R.drawable.course5);
        courseList.add(course5);
    }
}
