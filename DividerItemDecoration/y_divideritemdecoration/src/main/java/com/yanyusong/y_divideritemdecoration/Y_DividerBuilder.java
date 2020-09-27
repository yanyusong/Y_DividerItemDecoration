package com.yanyusong.y_divideritemdecoration;

import androidx.annotation.ColorInt;

/**
 * Created by mac on 2017/5/17.
 */

public class Y_DividerBuilder {

    private Y_SideLine leftSideLine;
    private Y_SideLine topSideLine;
    private Y_SideLine rightSideLine;
    private Y_SideLine bottomSideLine;


    public Y_DividerBuilder setLeftSideLine(boolean isHave, @ColorInt int color, float widthDp, float startPaddingDp, float endPaddingDp) {
        this.leftSideLine = new Y_SideLine(isHave, color, widthDp, startPaddingDp, endPaddingDp);
        return this;
    }

    public Y_DividerBuilder setTopSideLine(boolean isHave, @ColorInt int color, float widthDp, float startPaddingDp, float endPaddingDp) {
        this.topSideLine = new Y_SideLine(isHave, color, widthDp, startPaddingDp, endPaddingDp);
        return this;
    }

    public Y_DividerBuilder setRightSideLine(boolean isHave, @ColorInt int color, float widthDp, float startPaddingDp, float endPaddingDp) {
        this.rightSideLine = new Y_SideLine(isHave, color, widthDp, startPaddingDp, endPaddingDp);
        return this;
    }

    public Y_DividerBuilder setBottomSideLine(boolean isHave, @ColorInt int color, float widthDp, float startPaddingDp, float endPaddingDp) {
        this.bottomSideLine = new Y_SideLine(isHave, color, widthDp, startPaddingDp, endPaddingDp);
        return this;
    }

    public Y_Divider create() {
        //提供一个默认不显示的sideline，防止空指针
        Y_SideLine defaultSideLine = new Y_SideLine(false, 0xff666666, 0, 0, 0);

        leftSideLine = (leftSideLine != null ? leftSideLine : defaultSideLine);
        topSideLine = (topSideLine != null ? topSideLine : defaultSideLine);
        rightSideLine = (rightSideLine != null ? rightSideLine : defaultSideLine);
        bottomSideLine = (bottomSideLine != null ? bottomSideLine : defaultSideLine);

        return new Y_Divider(leftSideLine, topSideLine, rightSideLine, bottomSideLine);
    }


}



