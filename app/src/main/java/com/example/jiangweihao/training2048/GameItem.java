package com.example.jiangweihao.training2048;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class GameItem extends FrameLayout {
    private int mCardShowNum = 0;
    private TextView mtvNum;
    private LayoutParams mParams;

    public GameItem(@NonNull Context context) {
        super(context);
    }

    public GameItem(@NonNull Context context, int cardShowNum) {
        super(context);
        this.mCardShowNum = cardShowNum;
        initCardItem();
    }


    public GameItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initCardItem() {

        setBackgroundColor(Color.GRAY);
        mtvNum = new TextView(getContext());
        setNum(mCardShowNum);
        int gamelines = Config.mSp.getInt(Config.KEY_GAME_LINES,4);
        if (gamelines == 4){
            mtvNum.setTextSize(35);
        }else if(gamelines == 5){
            mtvNum.setTextSize(25);

        }else  mtvNum.setTextSize(20);

        // TODO: 2018/8/22 不懂待查
        TextPaint tp = mtvNum.getPaint();
        tp.setFakeBoldText(true);
        mtvNum.setGravity(Gravity.CENTER);
        mParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        mParams.setMargins(5,5,5,5);
        addView(mtvNum,mParams);


    }

    public View getItemView() {
        return mtvNum;
    }

    public int getNum() {
        return mCardShowNum;
    }

    //设置方块的数字
    public void setNum(int num) {

        this.mCardShowNum = num;
        if (num == 0) {
            mtvNum.setText("");
        } else {
            mtvNum.setText("" + num);
        }
        //颜色
        switch (num) {
            case 0:
                mtvNum.setBackgroundColor(0X00000000);
                break;
            case 2:
                mtvNum.setBackgroundColor(0xffeee5db);
                break;
            case 4:
                mtvNum.setBackgroundColor(0xffeee0ca);
                break;
            case 8:
                mtvNum.setBackgroundColor(0xfff2c17a);
                break;
            case 16:
                mtvNum.setBackgroundColor(0xfff68c6f);
                break;
            case 32:
                mtvNum.setBackgroundColor(0xfff68c6f);
                break;
            case 64:
                mtvNum.setBackgroundColor(0xfff66e3c);
                break;
            case 128:
                mtvNum.setBackgroundColor(0xffedcf74);
                break;
            case 256:
                mtvNum.setBackgroundColor(0xffedcc64);
                break;
            case 512:
                mtvNum.setBackgroundColor(0xffedc854);
                break;
            case 1024:
                mtvNum.setBackgroundColor(0xffedc54f);
                break;
            case 2048:
                mtvNum.setBackgroundColor(0xff3c4a34);
                break;

            default:
                mtvNum.setBackgroundColor(0xff3c4a34);
                break;


        }
    }
}
