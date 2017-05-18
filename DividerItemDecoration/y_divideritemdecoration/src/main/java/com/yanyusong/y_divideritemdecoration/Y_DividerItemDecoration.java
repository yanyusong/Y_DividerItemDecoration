package com.yanyusong.y_divideritemdecoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;


public abstract class Y_DividerItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;

    private Context context;

    public Y_DividerItemDecoration(Context context) {
        this.context = context;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //left, top, right, bottom
        int childCount1 = parent.getChildCount();
        for (int i = 0; i < childCount1; i++) {
            View child = parent.getChildAt(i);

            int itemPosition = ((RecyclerView.LayoutParams) child.getLayoutParams()).getViewLayoutPosition();

            Y_Divider divider = getDivider(itemPosition);
            int lineWidthPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, divider.getLineWidthDp(), context.getResources().getDisplayMetrics());

            if (divider.getLeft()) {
                drawChildLeftVertical(child, c, parent, divider.getColorARGB(), lineWidthPx);
            }
            if (divider.getTop()) {
                drawChildTopHorizontal(child, c, parent, divider.getColorARGB(), lineWidthPx);
            }
            if (divider.getRight()) {
                drawChildRightVertical(child, c, parent, divider.getColorARGB(), lineWidthPx);
            }
            if (divider.getBottom()) {
                drawChildBottomHorizontal(child, c, parent, divider.getColorARGB(), lineWidthPx);
            }
        }
    }

    private void drawChildBottomHorizontal(View child, Canvas c, RecyclerView parent, @ColorInt int color, int lineWidthPx) {

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();
        int left = child.getLeft() - params.leftMargin - lineWidthPx;
        int right = child.getRight() + params.rightMargin + lineWidthPx;
        int top = child.getBottom() + params.bottomMargin;
        int bottom = top + lineWidthPx;
        mPaint.setColor(color);

        c.drawRect(left, top, right, bottom, mPaint);

    }

    private void drawChildTopHorizontal(View child, Canvas c, RecyclerView parent, @ColorInt int color, int lineWidthPx) {
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();
        int left = child.getLeft() - params.leftMargin - lineWidthPx;
        int right = child.getRight() + params.rightMargin + lineWidthPx;
        int bottom = child.getTop() - params.topMargin;
        int top = bottom - lineWidthPx;
        mPaint.setColor(color);

        c.drawRect(left, top, right, bottom, mPaint);

    }

    private void drawChildLeftVertical(View child, Canvas c, RecyclerView parent, @ColorInt int color, int lineWidthPx) {
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();
        int top = child.getTop() - params.topMargin - lineWidthPx;
        int bottom = child.getBottom() + params.bottomMargin + lineWidthPx;
        int right = child.getLeft() - params.leftMargin;
        int left = right - lineWidthPx;
        mPaint.setColor(color);

        c.drawRect(left, top, right, bottom, mPaint);

    }

    private void drawChildRightVertical(View child, Canvas c, RecyclerView parent, @ColorInt int color, int lineWidthPx) {
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();
        int top = child.getTop() - params.topMargin - lineWidthPx;
        int bottom = child.getBottom() + params.bottomMargin + lineWidthPx;
        int left = child.getRight() + params.rightMargin;
        int right = left + lineWidthPx;
        mPaint.setColor(color);

        c.drawRect(left, top, right, bottom, mPaint);

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        //outRect 看源码可知这里只是把Rect类型的outRect作为一个封装了left,right,top,bottom的数据结构,
        //作为传递left,right,top,bottom的偏移值来用的

        int itemPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();

        Y_Divider divider = getDivider(itemPosition);
        int lineWidthPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, divider.getLineWidthDp(), context.getResources().getDisplayMetrics());

        int left = divider.getLeft() ? lineWidthPx : 0;
        int top = divider.getTop() ? lineWidthPx : 0;
        int right = divider.getRight() ? lineWidthPx : 0;
        int bottom = divider.getBottom() ? lineWidthPx : 0;

        outRect.set(left, top, right, bottom);
    }


    public abstract Y_Divider getDivider(int itemPosition);


}

















