package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText acc = (EditText)findViewById(R.id.acc);
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String account = acc.getText().toString();
                Intent intent;
                if(account.equals("111"))//普通用户
                {
                    intent = new Intent("com.app.first");
                    startActivity(intent);
                }
                if(account.equals("222"))//教练
                {
                    intent = new Intent(MainActivity.this,Coach.class);
                    startActivity(intent);
                }
                if(account.equals("333"))//管理员
                {
                    intent = new Intent(MainActivity.this,AdminActivity.class);
                    startActivity(intent);
                }
            }
        });

        ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        final EditText editText = (EditText)findViewById(R.id.pass);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)//不可见
                {
                    editText.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else
                {
                    editText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
            }
        });
    }
}
