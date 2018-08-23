package com.example.jiangweihao.training2048;

import android.app.Application;
import android.content.SharedPreferences;

public class Config extends Application {
    /**
     * SP
     */
    public static SharedPreferences mSp;


    public static int mGameGoal;

    /**
     * 行列数
     */
    public static int mGameLines;

    /**
     * 宽高
     */
    public static int mItemSize;

    /**
     * 计分
     */
    public static int SCROE = 0;

    public static String SP_HIGH_SCROE = "SP_HIGHSCROE";

    public static String KEY_HIGH_SCROE = "KEY_HighScore";

    public static String KEY_GAME_LINES = "KEY_GAMELINES";

    public static String KEY_GAME_GOAL = "KEY_GameGoal";

    @Override
    public void onCreate() {
        super.onCreate();
//        mSp = getSharedPreferences(SP_HIGH_SCROE,0);
//        //获取到edit对象
//        SharedPreferences.Editor edit = mSp.edit();
//        //通过editor对象写入数据
//        edit.putInt(KEY_HIGH_SCROE,4);
//        edit.putInt(KEY_GAME_GOAL,2048);
//        //提交数据存入到xml文件中
//        edit.commit();

        /**
         *原版代码
         *
          */
        mSp = getSharedPreferences(SP_HIGH_SCROE,0);
        mGameLines = mSp.getInt(KEY_HIGH_SCROE,4);
        mGameGoal = mSp.getInt(KEY_GAME_GOAL,4096);
        mItemSize = 0;
    }
}
