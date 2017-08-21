package com.yanyusong.divideritemdecoration;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yanyusong.divideritemdecoration.y_recycleradapter.GeneralRecyclerViewHolder;
import com.yanyusong.divideritemdecoration.y_recycleradapter.Y_ItemEntityList;
import com.yanyusong.divideritemdecoration.y_recycleradapter.Y_MultiRecyclerAdapter;
import com.yanyusong.divideritemdecoration.y_recycleradapter.Y_OnBind;
import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;
import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2017/4/6.
 */

public class GridLayoutManager2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private Y_ItemEntityList itemEntityList = new Y_ItemEntityList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        List<String> items = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            items.add("item" + i);
        }
        itemEntityList.addItems(R.layout.item_recyclerview_text, items)
                .addOnBind(R.layout.item_recyclerview_text, new Y_OnBind() {
                    @Override
                    public void onBindChildViewData(GeneralRecyclerViewHolder holder, Object itemData, int position) {
                        holder.setText(R.id.textView, (String) itemData);
                    }
                });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new Y_MultiRecyclerAdapter(this, itemEntityList));

        recyclerView.addItemDecoration(new DividerItemDecoration(this));
    }

    /**
     * 大分割线的解决方案是，将中间分割线的宽度平均分配到左右两个分割线上，
     * 这样item的宽度就一样了
     */
    private class DividerItemDecoration extends Y_DividerItemDecoration {

        private DividerItemDecoration(Context context) {
            super(context);
        }

        @Override
        public Y_Divider getDivider(int itemPosition) {

            Y_Divider divider = null;

            switch (itemPosition % 2) {
                case 0:
                    //每一行第一个显示rignt和bottom
                    divider = new Y_DividerBuilder()
                            .setRightSideLine(true, 0xff666666, 10, 0, 0)
                            .setBottomSideLine(true, 0xff666666, 20, 0, 0)
                            .create();
                    break;
                case 1:
                    //第二个显示Left和bottom
                    divider = new Y_DividerBuilder()
                            .setLeftSideLine(true, 0xff666666, 10, 0, 0)
                            .setBottomSideLine(true, 0xff666666, 20, 0, 0)
                            .create();
                    break;
                default:
                    break;
            }
            return divider;
        }
    }


}
