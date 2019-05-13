package com.example.playandroid.view.customview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/9 0009
 * Time: 20:26
 * Describe: ${as}
 */
public class Welcome_WanAndroid extends View {
    private Paint paint;
    public Welcome_WanAndroid(Context context) {
        this(context,null);
    }

    public Welcome_WanAndroid(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Welcome_WanAndroid(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.parseColor("#000000"));
        paint.setTextSize(40.0f);
        canvas.drawText("WanAndroid",getMeasuredWidth()/2-100,getMeasuredHeight()/2 ,paint);
    }
}
