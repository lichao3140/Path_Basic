package com.lqh.lichao.path_basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 绘制贝塞尔曲线
 * Created by Administrator on 2017-10-11.
 */

public class CurveView extends View {

    private float mStartX, mStartY;
    private float mEndX, mEndY;
    private float mContorlX = 200, mContorlY = 60;//默认值
    private Paint mPaint;
    private Path mPath;

    public CurveView(Context context) {
        this(context,null);
    }

    public CurveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mStartX = 60;
        mStartY = 350;
        mEndX = 450;
        mEndY = 350;
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        mPath.moveTo(mStartX, mStartY);
        mPath.quadTo(mContorlX, mContorlY, mEndX, mEndY);
        canvas.drawPath(mPath, mPaint);
        canvas.drawPoint(mContorlX, mContorlY, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_MOVE){
            mContorlX = event.getX();
            mContorlY = event.getY();
            invalidate();
        }
        return true;
    }
}
