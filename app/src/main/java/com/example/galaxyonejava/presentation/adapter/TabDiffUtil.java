package com.example.galaxyonejava.presentation.adapter;

import androidx.recyclerview.widget.DiffUtil;

import com.example.galaxyonejava.presentation.model.TabItem;

import java.util.List;

public class TabDiffUtil extends DiffUtil.Callback {
    private List<TabItem> oldList;
    private List<TabItem> newList;

    public TabDiffUtil(List<TabItem> oldList, List<TabItem> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return true;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        if (oldList.get(oldItemPosition).getActive() == newList.get(newItemPosition).getActive()) {
            return true;
        } else {
            return false;
        }
    }
}
