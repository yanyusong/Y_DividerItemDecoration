package com.yanyusong.y_divideritemdecoration;

import android.support.annotation.ColorInt;

/**
 * Created by mac on 2017/5/17.
 */

public class Y_Divider {

    public boolean left = false;
    public boolean top = false;
    public boolean right = false;
    public boolean bottom = false;
    /**
     * A single color value in the form 0xAARRGGBB.
     **/
    public int colorARGB;
    /**
     * 单位dp
     */
    public float lineWidthDp;

    public Y_Divider(boolean left, boolean top, boolean right, boolean bottom, float lineWidthDp, @ColorInt int colorARGB) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.colorARGB = colorARGB;
        this.lineWidthDp = lineWidthDp;
    }

    public boolean getLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean getTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean getRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean getBottom() {
        return bottom;
    }

    public void setBottom(boolean bottom) {
        this.bottom = bottom;
    }

    public int getColorARGB() {
        return colorARGB;
    }

    public void setColorARGB(@ColorInt int colorARGB) {
        this.colorARGB = colorARGB;
    }

    public float getLineWidthDp() {
        return lineWidthDp;
    }

    public void setLineWidthDp(float lineWidthDp) {
        this.lineWidthDp = lineWidthDp;
    }
}
