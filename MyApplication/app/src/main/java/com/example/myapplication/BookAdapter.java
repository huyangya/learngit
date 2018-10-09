package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 16301029 on 2018/10/3.
 */

public class BookAdapter extends ArrayAdapter<Course>
{
    private int resourseId;
    public BookAdapter(Context context, int textViewResourseId, List<Course>objects)
    {
        super(context,textViewResourseId,objects);
        resourseId = textViewResourseId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Course course = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourseId,parent,false);
        ImageView courseImage = (ImageView) view.findViewById(R.id.course_image);
        TextView courseName = (TextView) view.findViewById(R.id.course_name);
        courseImage.setImageResource(course.getCourseImage());
        courseName.setText(course.getCourseName());
        return view;
    }
}