package com.example.galaxyonejava.ui.motion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.galaxyonejava.R;
import com.example.galaxyonejava.presentation.adapter.ItemClick;
import com.example.galaxyonejava.presentation.adapter.TabAdapter;
import com.example.galaxyonejava.presentation.model.TabItem;

import java.util.ArrayList;

public class MotionRecyclerViewActivity extends AppCompatActivity implements ItemClick {

    private RecyclerView rvTest;
    private TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_recycler_view);
        rvTest = findViewById(R.id.rvTest);
        tabAdapter = new TabAdapter(this);
        rvTest.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvTest.setAdapter(tabAdapter);
        ArrayList<TabItem> tabItems = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Boolean isActive = false;
            if (i == 0) {
                isActive = true;
            }
            tabItems.add(new TabItem("Demo", isActive));
        }
        tabAdapter.updateList(tabItems);
    }

    @Override
    public void onItemRecyclerViewClick(int position) {

    }
}