package com.example.galaxyonejava.presentation.di;

import com.example.galaxyonejava.data.di.NetworkModule;
import com.example.galaxyonejava.data.di.RepositoryModule;
import com.example.galaxyonejava.presentation.FragmentA;
import com.example.galaxyonejava.presentation.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, UsecaseModule.class, ViewModelModule.class, RepositoryModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(FragmentA fragmentA);
}
