package com.yanyusong.divideritemdecoration.y_recycleradapter;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 16/6/24.
 */
public class Y_ItemEntityList {

    private List<Object> mItems = new ArrayList<>();

    private List<Integer> mItemLayoutIds = new ArrayList<>();

    private SparseArray<Y_OnBind> mOnBinds = new SparseArray<>(10);

    public Y_ItemEntityList() {
    }

    public Y_ItemEntityList addItem(int itemLayoutId, Object itemData) {
        mItemLayoutIds.add(itemLayoutId);
        mItems.add(itemData);
        return this;
    }

    public Y_ItemEntityList addItem(int position, int itemLayoutId, Object itemData) {
        mItemLayoutIds.add(position, itemLayoutId);
        mItems.add(position, itemData);
        return this;
    }

    public Y_ItemEntityList addItems(int position, int itemLayoutId, List<?> itemDatas) {

        List<Integer> mlayoutIds = new ArrayList<>();
        for (int i = 0; i < itemDatas.size(); i++) {
            mlayoutIds.add(itemLayoutId);
        }
        mItemLayoutIds.addAll(position, mlayoutIds);
        mItems.addAll(position, itemDatas);
        return this;
    }

    public Y_ItemEntityList addItems(int itemLayoutId, List<?> itemDatas) {
        for (int i = 0; i < itemDatas.size(); i++) {
            mItemLayoutIds.add(itemLayoutId);
        }
        mItems.addAll(itemDatas);
        return this;
    }

    public Y_ItemEntityList addOnBind(int itemLayoutId, Y_OnBind YOnBind) {
        mOnBinds.put(itemLayoutId, YOnBind);
        return this;
    }

    public void clear() {
        clearItemDatas();
        clearOnBinds();
    }

    public void clearItemDatas() {
        mItems.clear();
        mItemLayoutIds.clear();
    }

    public void clearOnBinds() {
        mOnBinds.clear();
    }

    public void replace(int position, int itemLayoutId, Object itemData) {
        remove(position);
        addItem(position, itemLayoutId, itemData);
    }


    public void remove(int position) {
        mItems.remove(position);
        mItemLayoutIds.remove(position);
    }

    public List<Object> getItemDatasForViewType(int itemLayoutId) {

        List<Object> items = new ArrayList<>();

        for (int i = 0; i < mItemLayoutIds.size(); i++) {
            if (itemLayoutId == mItemLayoutIds.get(i)) {
                items.add(mItems.get(i));
            }
        }
        return items;
    }

    public List<Integer> getPositionsForViewType(int itemLayoutId) {

        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i < mItemLayoutIds.size(); i++) {
            if (itemLayoutId == mItemLayoutIds.get(i)) {
                positions.add(i);
            }
        }
        return positions;
    }

    public int getItemCount() {
        return mItems.size();
    }

    public int getItemLayoutId(int position) {
        return mItemLayoutIds.get(position);
    }

    public Object getItemData(int position) {
        return mItems.get(position);
    }

    public Y_OnBind getOnBind(int position) {

        return mOnBinds.get(getItemLayoutId(position), null);
    }

    private Y_OnBind getOnBindByLayoutId(int itemLayoutId) {
        return mOnBinds.get(itemLayoutId, null);
    }


}
