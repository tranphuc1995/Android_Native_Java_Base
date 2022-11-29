package com.example.galaxyonejava.presentation;

import android.app.Application;

import com.example.galaxyonejava.presentation.di.ApplicationComponent;
import com.example.galaxyonejava.presentation.di.DaggerApplicationComponent;

public class MyApplication extends Application {

    ApplicationComponent appComponent = DaggerApplicationComponent.create();
}
