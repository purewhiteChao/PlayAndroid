package com.example.playandroid.view.activity.welcome;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;

import com.example.playandroid.MainActivity;
import com.example.playandroid.R;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.view.customview.Welcome_WanAndroid;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/9 0009
 * Time: 20:02
 * Describe: ${as}
 */
public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.word_welcome)
    Welcome_WanAndroid wordWelcome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(wordWelcome,"Alpha",0,1);
        animator.setDuration(1500);
        animator.start();

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();

            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_welcome;
    }
}
