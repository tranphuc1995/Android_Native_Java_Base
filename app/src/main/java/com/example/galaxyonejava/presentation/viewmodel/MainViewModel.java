package com.example.galaxyonejava.presentation.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galaxyonejava.data.entity.FilmEntity;
import com.example.galaxyonejava.domain.usecase.GetListFilmUsecase;
import com.example.galaxyonejava.presentation.model.TabItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {
    public MutableLiveData<List<TabItem>> getTabItemLiveData() {
        return tabItemLiveData;
    }

    private MutableLiveData<List<TabItem>> tabItemLiveData = new MutableLiveData<List<TabItem>>();
    private ArrayList<TabItem> tabItems = new ArrayList<>();

    private GetListFilmUsecase getListFilmUsecase;

    private final CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    public MainViewModel(GetListFilmUsecase getListFilmUsecase) {
        this.getListFilmUsecase = getListFilmUsecase;
    }

    public void initDataTab() {
        for (int i = 0; i < 2; i++) {
            Boolean isActive = false;
            if (i == 0) {
                isActive = true;
            }
            tabItems.add(new TabItem("Demo", isActive));
        }
        tabItemLiveData.postValue(tabItems);
    }

    public void clickTab(int position) {
        for (int i = 0; i < tabItems.size(); i++) {
            if (i == position) {
                tabItems.set(i, new TabItem(tabItems.get(i).getTitle(), true));
            } else {
                tabItems.set(i, new TabItem(tabItems.get(i).getTitle(), false));
            }
        }
        tabItemLiveData.postValue(tabItems);
    }

    public void excuteUseCase() {
        disposables.add(getListFilmUsecase.excute().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResponse, this::handleError));

    }

    private void handleResponse(FilmEntity filmEntity) {
        Log.d("debug_phuc", "aaa");
    }

    private void handleError(Throwable error) {
        Log.d("debug_phuc", "bbb");
    }

    @Override
    protected void onCleared() {
        disposables.clear();
        super.onCleared();
    }
}
