package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initcrouse();
        ListView listView = (ListView)findViewById(R.id.bookList);
        BookAdapter bookAdapter = new BookAdapter(BookActivity.this,R.layout.course,courseList);
        listView.setAdapter(bookAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Course course = courseList.get(position);
                createDia(course.getCourseName());
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

    //预定课程对话框
    public void createDia(String name) {
        String title = "选择" + name + "课程";
        final String[] teacher = {"牛铁翠", "牛铁花", "牛铁香", "牛铁芬", "牛铁芳"};
        final Boolean[] item = {false, false, false, false, false};
        final String course = name;
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(title)
                .setSingleChoiceItems(teacher, 1, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        for (int i = 0; i < 5; i++)
                        {
                            item[i] = false;
                        }
                        item[which] = true;
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String str = "";
                        for (int i = 0; i < 5; i++)
                        {
                            if (item[i] == true)
                            {
                                str = "成功预定" + teacher[i] + "老师的" + course + "课程";
                                break;
                            }
                        }
                        Toast.makeText(BookActivity.this, str, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }
}
