package com.madarsoft.task.classes.di.modules;


import com.madarsoft.task.classes.room_db.entity.User;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class ActivityModule {


    @Provides
    public List<User> posts() {
        return new ArrayList<>();
    }


}
