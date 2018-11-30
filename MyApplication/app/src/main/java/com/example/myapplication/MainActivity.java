package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import connect.ConnectHttp;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText acc = (EditText)findViewById(R.id.acc);//账户
        final EditText passWord = (EditText)findViewById(R.id.pass);//密码
        Button button1 = (Button)findViewById(R.id.button1);//登陆

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent;
                intent = new Intent("com.app.first");
                startActivity(intent);
                //联网登陆
                /*new Thread()
                {
                    @Override
                    public void run()
                    {
                        String response = doPost("login").trim();
                        Intent intent;
                        switch (response)
                        {
                            case "1":
                                intent = new Intent("com.app.first");
                                startActivity(intent);
                                break;
                            case "2":
                                intent = new Intent(MainActivity.this,Coach.class);
                                startActivity(intent);
                                break;
                            case "3":
                                intent = new Intent(MainActivity.this,AdminActivity.class);
                                startActivity(intent);
                                break;
                            case "NO":
                                showRes();
                                break;
                            default:
                                System.out.println("default");
                                break;
                        }
                    }
                }.start();*/
            }
        });

        ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)//不可见
                {
                    passWord.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else
                {
                    passWord.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new Thread()
                {
                    @Override
                    public void run()
                    {
                        if(doPost("register").trim().equals("YES"))
                        {
                            Intent intent = new Intent("com.app.first");
                            startActivity(intent);
                        }
                        else
                        {
                            showRes();
                        }
                    }
                }.start();
            }
        });
    }

    public String doPost(String type)
    {
        final EditText acc = (EditText)findViewById(R.id.acc);//账号编辑域
        final EditText passWord = (EditText)findViewById(R.id.pass);//密码编辑域
        String account = acc.getText().toString().trim();
        String pass = passWord.getText().toString().trim();
        String result = " ";
        String data = "req=" + type + "&acc=" + account + "&password=" + pass;//要post的数据
        //建立连接
        ConnectHttp con = new ConnectHttp("POST");
        con.connect();
        HttpURLConnection connection = con.getConnection();
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Length", data.length() + "");
        //得到返回值
        try
        {
            connection.getOutputStream().write(data.getBytes());//post数据
            System.out.println(data);
            int code = connection.getResponseCode();
            if (code == 200)
            {
                InputStream is = connection.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = is.read(buffer)) != -1)
                {
                    bos.write(buffer, 0, len);
                }
                result = new String(bos.toByteArray());
                is.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    private void showRes()
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                Toast.makeText(MainActivity.this,"失败",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
