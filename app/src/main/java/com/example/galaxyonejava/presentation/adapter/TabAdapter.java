package com.example.galaxyonejava.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galaxyonejava.R;
import com.example.galaxyonejava.presentation.model.TabItem;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<TabItem> tabItems = new ArrayList<>();
    private ItemClick itemClick;

    public TabAdapter(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tab, parent, false);
        return new TabViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((TabViewHolder) holder).bindData(tabItems.get(holder.getAdapterPosition()));
        ((TabViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.onItemRecyclerViewClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return tabItems.size();
    }

    public void updateList(List<TabItem> newList) {
        TabDiffUtil tabDiffUtil = new TabDiffUtil(tabItems, newList);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(tabDiffUtil);
        tabItems.clear();
        tabItems.addAll(newList);
        result.dispatchUpdatesTo(this);
    }
}
