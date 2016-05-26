package com.xiaokai.hitsz.dazhong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(value = R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.button)
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(value = R.id.button,type = View.OnClickListener.class)
    private void onButtonClick(View v){
        switch (v.getId()){
            case R.id.button:
                Toast.makeText(this,"你好我是Xutils的IOC功能",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
