package com.yanyusong.y_divideritemdecoration;

/**
 * Created by mac on 2017/5/17.
 */

public class Y_Divider {

    public Y_SideLine leftSideLine;
    public Y_SideLine topSideLine;
    public Y_SideLine rightSideLine;
    public Y_SideLine bottomSideLine;


    public Y_Divider(Y_SideLine leftSideLine, Y_SideLine topSideLine, Y_SideLine rightSideLine, Y_SideLine bottomSideLine) {
        this.leftSideLine = leftSideLine;
        this.topSideLine = topSideLine;
        this.rightSideLine = rightSideLine;
        this.bottomSideLine = bottomSideLine;
    }

    public Y_SideLine getLeftSideLine() {
        return leftSideLine;
    }

    public void setLeftSideLine(Y_SideLine leftSideLine) {
        this.leftSideLine = leftSideLine;
    }

    public Y_SideLine getTopSideLine() {
        return topSideLine;
    }

    public void setTopSideLine(Y_SideLine topSideLine) {
        this.topSideLine = topSideLine;
    }

    public Y_SideLine getRightSideLine() {
        return rightSideLine;
    }

    public void setRightSideLine(Y_SideLine rightSideLine) {
        this.rightSideLine = rightSideLine;
    }

    public Y_SideLine getBottomSideLine() {
        return bottomSideLine;
    }

    public void setBottomSideLine(Y_SideLine bottomSideLine) {
        this.bottomSideLine = bottomSideLine;
    }
}



