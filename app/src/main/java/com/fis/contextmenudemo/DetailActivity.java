package com.fis.contextmenudemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        TextView username = (TextView) findViewById(R.id.usename);
        TextView passsword = (TextView) findViewById(R.id.password);

        Intent intent = getIntent();

        String user = intent.getStringExtra("username");
        String pwd = intent.getStringExtra("password");

        username.setText("用户名："+user);
        passsword.setText("密码：："+pwd);



    }
}
