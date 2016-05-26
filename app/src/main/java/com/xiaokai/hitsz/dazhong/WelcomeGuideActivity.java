package com.xiaokai.hitsz.dazhong;

import android.content.Intent;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

import java.util.List;


@ContentView(value = R.layout.activity_welcome_guide)
public class WelcomeGuideActivity extends AppCompatActivity {

    @ViewInject(R.id.welcome_pager)
    ViewPager welcome_pager;

    @ViewInject(R.id.welcome_guide_btn)
    Button welcome_guide_btn;

    List<View> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        initViewPagers();
    }

    //初始化viewPager
    private void initViewPagers() {
        list= new ArrayList<View>();
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.guide_01);
        list.add(iv);
        ImageView iv1 = new ImageView(this);
        iv1.setImageResource(R.drawable.guide_02);
        list.add(iv1);
        ImageView iv2 = new ImageView(this);
        iv2.setImageResource(R.drawable.guide_03);
        list.add(iv2);
        welcome_pager.setAdapter(new MyPagerAdapter());
        welcome_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==2){
                    welcome_guide_btn.setVisibility(View.VISIBLE);
                }else{
                    welcome_guide_btn.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Event(R.id.welcome_guide_btn)
    private void onButtonClick(View view){
        switch(view.getId()){
            case R.id.welcome_guide_btn:
                startActivity(new Intent(WelcomeGuideActivity.this,MainActivity.class));
                finish();
        }
    }

    //定义ViewPager的适配器

    class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==(View)object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position,Object object) {
            container.removeView(list.get(position));
        }
    }
}
