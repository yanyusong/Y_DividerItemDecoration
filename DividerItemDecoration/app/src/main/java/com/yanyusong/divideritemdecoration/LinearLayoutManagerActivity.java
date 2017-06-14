package com.yanyusong.divideritemdecoration;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
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
        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        recyclerView.setAdapter(new Y_MultiRecyclerAdapter(this, itemEntityList));

    }


    class DividerItemDecoration extends Y_DividerItemDecoration {

        public DividerItemDecoration(Context context) {
            super(context);
        }

        @Override
        public Y_Divider getDivider(int itemPosition) {
            Y_Divider divider = null;
            switch (itemPosition) {
                case 0:
                    divider = new Y_DividerBuilder()
                            .setBottomSideLine(true, 0xffFF4081, 6, 0, 0)
                            .create();
                    break;
                case 1:
                    //
                    divider = new Y_DividerBuilder()
                            .setBottomSideLine(true, 0xff666666, 6, 0, 0)
                            .create();
                    break;
                case 2:
                    divider = new Y_DividerBuilder()
                            .setBottomSideLine(true, 0xffFF4081, 4, 0, 0)
                            .create();
                    break;
                case 3:
                    divider = new Y_DividerBuilder()
                            .setBottomSideLine(true, 0xffFF4081, 6, 16, 16)
                            .create();
                    break;
                case 4:
                    divider = new Y_DividerBuilder()
                            .setBottomSideLine(true, 0xffFF4081, 6, 16, 32)
                            .create();
                    break;
                case 5:
                    divider = new Y_DividerBuilder()
                            .setBottomSideLine(true, 0xffFF4081, 6, 0, 0)
                            .create();
                    break;
                case 6:
                    divider = new Y_DividerBuilder()
                            .setLeftSideLine(true, 0xffFF4081, 3, 0, 0)
                            .setRightSideLine(true, 0xffFF4081, 8, 0, 0)
                            .setBottomSideLine(true, 0xffFF4081, 6, 0, 0)
                            .create();
                    break;
                default:
                    divider = new Y_DividerBuilder()
                            .setBottomSideLine(true, 0xff666666, 6, 0, 0)
                            .create();
                    break;
            }


            return divider;
        }
    }


}
