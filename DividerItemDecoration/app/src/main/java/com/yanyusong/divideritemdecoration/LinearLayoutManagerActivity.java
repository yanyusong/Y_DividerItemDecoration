package com.yanyusong.divideritemdecoration;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yanyusong.divideritemdecoration.y_recycleradapter.GeneralRecyclerViewHolder;
import com.yanyusong.divideritemdecoration.y_recycleradapter.Y_ItemEntityList;
import com.yanyusong.divideritemdecoration.y_recycleradapter.Y_MultiRecyclerAdapter;
import com.yanyusong.divideritemdecoration.y_recycleradapter.Y_OnBind;
import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2017/4/6.
 */

public class LinearLayoutManagerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private Y_ItemEntityList itemEntityList = new Y_ItemEntityList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        List<String> items = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            items.add("item" + i);
        }
        itemEntityList.addItems(R.layout.item_recyclerview_text, items)
                .addOnBind(R.layout.item_recyclerview_text, new Y_OnBind() {
                    @Override
                    public void onBindChildViewData(GeneralRecyclerViewHolder holder, Object itemData, int position) {
                        holder.setText(R.id.textView, (String) itemData);
                    }
                });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Y_MultiRecyclerAdapter(this, itemEntityList));


        recyclerView.addItemDecoration(new DividerItemDecoration(this, 6, 0xff666666));


    }


    class DividerItemDecoration extends Y_DividerItemDecoration {

        public DividerItemDecoration(Context context, int lineWidthDp, @ColorInt int colorRGB) {
            super(context, lineWidthDp, colorRGB);
        }

        @Override
        public boolean[] getItemSidesIsHaveOffsets(int itemPosition) {
            //顺序:left, top, right, bottom
            boolean[] isOffset = {false, false, false, true};//默认只有bottom显示分割线

            if (itemPosition == 3 || itemPosition == 6 || itemPosition == 9) {
                //当position == 3，6，9时，把left和right的分割线也显示出来
                isOffset[0] = true;
                isOffset[2] = true;
            }

            return isOffset;
        }
    }


}
