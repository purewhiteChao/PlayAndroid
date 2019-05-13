package com.example.playandroid.view.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 13:49
 * Describe: ${as}
 */
public class CircleImageView extends AppCompatImageView {
    private Paint paint;
    private BitmapShader shader;
    private Matrix matrix;
    private Bitmap bitmap;

    public CircleImageView(Context context) {
        this(context,null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        notifyCircle();
    }

    private void notifyCircle() {
        paint = new Paint();
        paint.setAntiAlias(true);
        BitmapDrawable drawable = (BitmapDrawable) this.getDrawable();
        bitmap = drawable.getBitmap();
        shader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        paint.setShader(shader);
        matrix = new Matrix();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int r = Math.min(measuredHeight,measuredWidth)/2;

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = width/measuredWidth;
        float scaleHeight = height/measuredHeight;
        float scale = Math.max(scaleHeight,scaleWidth);
        matrix.setScale(scaleWidth,scaleHeight);
        shader.setLocalMatrix(matrix);
        paint.setShader(shader);
        canvas.drawCircle(measuredWidth/2,measuredHeight/2,r,paint);
    }
}
