package com.fis.contextmenudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Random;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class MessageActivity extends AppCompatActivity {

    private String appKey = "157532f3c898c";
    private String appSecret = "3e2241c6124e2de86cd557aa1b128500";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        SMSSDK.initSDK(MessageActivity.this,appKey,appSecret);
        Button button =  (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //注册手机号
                RegisterPage registerPage = new RegisterPage();
                //注册回调事件
                registerPage.setRegisterCallback(new EventHandler() {
                    @Override
                    public void afterEvent(int event, int result, Object data) {
                        //判断结果是否完成
                        if(result==SMSSDK.RESULT_COMPLETE){
                            HashMap<String,Object> maps = (HashMap<String, Object>) data;
                            String country =(String) maps.get("country");
                            String phone = (String)maps.get("phone");

                            submitUserInfo(country,phone);

                        }
                    }
                });
                //显示注册页面
                registerPage.show(MessageActivity.this);
            }
        });
    }

    private void submitUserInfo(String country,String phone) {
        Random random = new Random();
        String uid = Math.abs(random.nextInt())+"";
        String nickname = getString(R.string.imooc);
        SMSSDK.submitUserInfo(uid,nickname,null,country,phone);
    }
}
