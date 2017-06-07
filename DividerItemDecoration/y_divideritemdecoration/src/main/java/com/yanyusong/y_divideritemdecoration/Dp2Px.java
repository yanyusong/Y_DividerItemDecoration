package com.yanyusong.y_divideritemdecoration;

import android.content.Context;
import android.util.TypedValue;

/**
 * 常用单位转换的辅助类
 *
 * @author zhy
 */
public class Dp2Px {
    private Dp2Px() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * dp转px
     *
     * @param context
     * @param dpVal
     * @return
     */
    public static int convert(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }


}
