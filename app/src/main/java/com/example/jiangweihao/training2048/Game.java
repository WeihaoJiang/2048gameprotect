package com.example.jiangweihao.training2048;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Game extends Activity implements View.OnClickListener {

    // Activity的引用
    private static Game mGame;
    // 记录分数
    private TextView mTvScore;
    // 历史记录分数
    private TextView mTvHighScore;
    private int mHighScore;
    // 目标分数
    private TextView mTvGoal;
    private int mGoal;
    // 重新开始按钮
    private Button mBtnRestart;

    // 游戏面板
    private GameView mGameView;

    public Game() {
        mGame = this;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化View
        initView();
        mGameView = new GameView(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.game_panel);
        // 为了GameView能居中
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.game_panel_rl);
        relativeLayout.addView(mGameView);
    }

    /**
     * 初始化View
     */
    private void initView() {
        mTvScore = (TextView) findViewById(R.id.scroe);
        mTvGoal = (TextView) findViewById(R.id.tv_Goal);
        mTvHighScore = (TextView) findViewById(R.id.record);
        mBtnRestart = (Button) findViewById(R.id.btn_restart);
        mBtnRestart.setOnClickListener(this);

        mHighScore = Config.mSp.getInt(Config.KEY_HIGH_SCROE, 0);
        mGoal = Config.mSp.getInt(Config.KEY_GAME_GOAL, 2048);
        mTvHighScore.setText("" + mHighScore);
        mTvGoal.setText("" + mGoal);
        mTvScore.setText("0");
        setScore(0, 0);
    }

    public void setGoal(int num) {
        mTvGoal.setText(String.valueOf(num));
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_restart:
                mGameView.startGame();
                setScore(0, 0);
                break;

            default:
                break;
        }
    }

    /**
     * 获取当前Activity的引用
     *
     * @return Activity.this
     */
    public static Game getGameActivity() {
        return mGame;
    }


    /**
     * 修改得分
     *
     * @param score score
     * @param flag  0 : score 1 : high score
     */
    public void setScore(int score, int flag) {
        switch (flag) {
            case 0:
                mTvScore.setText("" + score);
                break;
            case 1:
                mTvHighScore.setText("" + score);
                break;
            default:
                break;
        }
    }

}
