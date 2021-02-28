package com.will.drawcheckmarkdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TickView extends View {
    Paint mCirclePaint;
    Paint mTickPaint;

    // view的宽高
    private int mViewWidth;
    private int mViewHeight;

    // view的中心
    private int mViewCenterX;
    private int mViewCenterY;

    // 半径
    private int mRadius;

    private PointF mPoint1;
    private PointF mPoint2;
    private PointF mPoint7;
    private PointF mPoint3;

    public TickView(Context context) {
        this(context,null);
    }

    public TickView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TickView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setColor(getResources().getColor(android.R.color.holo_blue_dark));


        mTickPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTickPaint.setColor(Color.WHITE);
        mTickPaint.setAntiAlias(true);
        mTickPaint.setStyle(Paint.Style.STROKE);
        mTickPaint.setStrokeCap(Paint.Cap.ROUND);
        mTickPaint.setStrokeJoin(Paint.Join.ROUND);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mViewWidth = measureWidth(widthMeasureSpec);
        mViewHeight = measureHeight(heightMeasureSpec);
        mViewCenterX = mViewWidth / 2;
        mViewCenterY = mViewHeight / 2;

        mRadius = mViewCenterX <= mViewCenterY ? mViewCenterX : mViewCenterY;
        mTickPaint.setStrokeWidth(mRadius * 2 / 18);

        setMeasuredDimension(mViewWidth, mViewHeight);
    }

    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 500;
        if (specMode == MeasureSpec.AT_MOST) {
            result = specSize;
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }

    private int measureWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 500;
        if (specMode == MeasureSpec.AT_MOST) {
            result = specSize;
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (mViewWidth != 0) {
            // 为八个点定坐标

            mPoint1 = new PointF(mRadius / 2 * 3, mRadius / 2);
            mPoint2 = new PointF(mRadius / 2, mRadius / 2 * 2);
            mPoint7 = new PointF(mRadius / 2 * 2, mRadius / 2 * 3);
            mPoint3 = new PointF(mRadius /2 *3 + mRadius / 2 /2 ,mRadius /2 + mRadius / 2 /2);
        }
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 先绘制背景
        canvas.drawCircle(mViewCenterX, mViewCenterY, mRadius, mCirclePaint);
        drawLine(canvas,mPoint2,mPoint7);
//        drawLine(canvas,mPoint7,mPoint1);
        drawLine(canvas,mPoint7,mPoint3);

    }

    // 绘制线段
    private void drawLine(Canvas canvas, PointF start, PointF end) {
        if (start.x != 0 && end.x != 0) {
            canvas.drawLine(start.x, start.y, end.x, end.y, mTickPaint);
        }
    }
}