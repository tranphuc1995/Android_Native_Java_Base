package com.example.galaxyonejava.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.galaxyonejava.R;
import com.example.galaxyonejava.presentation.adapter.ItemClick;
import com.example.galaxyonejava.presentation.adapter.TabAdapter;
import com.example.galaxyonejava.presentation.di.ViewModelFactory;
import com.example.galaxyonejava.presentation.model.TabItem;
import com.example.galaxyonejava.presentation.viewmodel.MainViewModel;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ItemClick {
    private MainViewModel mainViewModel;
    private RecyclerView rvTab;
    private TabAdapter tabAdapter;

    private FragmentA fragmentA = new FragmentA();
    private FragmentB fragmentB = new FragmentB();
    private FragmentManager fragmentManager;
    private final String tagFragmentA = "FRAGMENT_A";
    private final String tagFragmentB = "FRAGMENT_B";

    @Inject
    ViewModelFactory mViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplicationContext()).appComponent.inject(this);
        initView();
        initObservers();
        mainViewModel.initDataTab();
        mainViewModel.excuteUseCase();
        addFragment();
    }

    private void addFragment() {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.layout, fragmentA, tagFragmentA).commit();
    }

    private void initObservers() {
        mainViewModel.getTabItemLiveData().observe(this, new Observer<List<TabItem>>() {
            @Override
            public void onChanged(List<TabItem> tabItems) {
                tabAdapter.updateList(tabItems);
            }
        });
    }

    private void initView() {
        rvTab = findViewById(R.id.rvTab);
        mainViewModel = new ViewModelProvider(this, mViewModelFactory).get(MainViewModel.class);
        initRvTab();
    }

    private void initRvTab() {
        tabAdapter = new TabAdapter(this);
        rvTab.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rvTab.setAdapter(tabAdapter);
    }

    @Override
    public void onItemRecyclerViewClick(int position) {
        mainViewModel.clickTab(position);
        changeContentViewPager(position);
    }

    private void changeContentViewPager(int position) {
        if (position == 0) {
            Fragment fragment = fragmentManager.findFragmentByTag(tagFragmentA);
            if (fragment != null) {
                fragmentManager.beginTransaction().replace(R.id.layout, fragmentA).commit();
            } else {
                fragmentManager.beginTransaction().add(R.id.layout, fragmentA, tagFragmentA).commit();
            }
        } else {
            Fragment fragment = fragmentManager.findFragmentByTag(tagFragmentB);
            if (fragment != null) {
                fragmentManager.beginTransaction().replace(R.id.layout, fragmentB).commit();
            } else {
                fragmentManager.beginTransaction().add(R.id.layout, fragmentB, tagFragmentB).commit();
               // fragmentManager.beginTransaction().replace(R.id.layout, fragmentB).commit();
            }
        }

    }
}