package com.madarsoft.task.classes.others;

import android.app.Application;

import com.madarsoft.task.BuildConfig;

import javax.inject.Inject;

import dagger.hilt.android.HiltAndroidApp;
import timber.log.Timber;


@HiltAndroidApp
public class MainApplication extends Application {

    @Inject
    Timber.DebugTree debugTree;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(debugTree);
        }
    }
}