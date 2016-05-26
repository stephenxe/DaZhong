package com.xiaokai.hitsz.dazhong.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by xukaifang on 16/5/26.
 */

public class SharedPreferenceUtils {
    private final static String FILENAME="dazhong";
    private final static String ISGUIDE="welcome";
    //获取导航偏爱设置
    public static boolean getIsGuide(Context context){
        SharedPreferences sp = context.getSharedPreferences(FILENAME,Context.MODE_PRIVATE);
        return  sp.getBoolean(ISGUIDE,false);

    }
    public  static  void setIsguide(Context context,boolean bool){
        SharedPreferences sp = context.getSharedPreferences(FILENAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean(ISGUIDE,bool);
        editor.commit();
    }
}


