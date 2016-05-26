package com.xiaokai.hitsz.dazhong;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaokai.hitsz.dazhong.utils.SharedPreferenceUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import java.util.Timer;
import java.util.TimerTask;


@ContentView(value = R.layout.activity_welcome)
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //两种方法实现页面跳转
        //1.采用Handler方式
//        new Handler(new Handler.Callback() {
//            @Override
//            public boolean handleMessage(Message msg) {
//                //实现页面跳转
//                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
//                return false;
//            }
//        }).sendEmptyMessageDelayed(0,3000);
        //第二种方法使用timer
        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                //如果没有导航
                if (SharedPreferenceUtils.getIsGuide(getBaseContext())){
                    startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                }else{
                    startActivity(new Intent(WelcomeActivity.this,WelcomeGuideActivity.class));
                    SharedPreferenceUtils.setIsguide(getBaseContext(),true);
                }
                finish();

            }
        };
        timer.schedule(timerTask,3000);
    }
}
