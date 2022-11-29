package com.example.galaxyonejava.presentation.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galaxyonejava.R;
import com.example.galaxyonejava.presentation.model.TabItem;

public class TabViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitleTab;
    ImageView ivIconTab;
    ConstraintLayout bgTab;
    View view;

    public TabViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitleTab = itemView.findViewById(R.id.tvTitleTab);
        ivIconTab = itemView.findViewById(R.id.ivIconTab);
        bgTab = itemView.findViewById(R.id.bgTab);
        view = itemView;
    }

    public void bindData(TabItem tabItem) {
        tvTitleTab.setText(tabItem.getTitle());
        if (tabItem.getActive()) {
            tvTitleTab.setTextColor(ContextCompat.getColor(view.getContext(), R.color.white));
            bgTab.setBackgroundResource(R.drawable.background_tab_active);
        } else {
            tvTitleTab.setTextColor(ContextCompat.getColor(view.getContext(), R.color.neutral200));
            bgTab.setBackgroundResource(R.drawable.background_tab_not_active);
        }
    }
}
