package com.madarsoft.task.classes;


import com.madarsoft.task.classes.room_db.db.AppDatabase;
import com.madarsoft.task.classes.room_db.entity.User;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ViewModelScoped;
import io.reactivex.rxjava3.core.Observable;
@ViewModelScoped
public class Repository {
    private final AppDatabase db;


    @Inject
    public Repository(AppDatabase db) {
        this.db = db;
    }


    /*
     * Room Setup
     */
    public Observable<List<User>> queryAllUsers() {
        return Observable.fromCallable(() -> db.usersDao().queryAllUsers());
    }

    public Observable<Boolean> insertUser(User user) {
        db.usersDao().insertUser(user);
        return Observable.fromCallable(() -> false);
    }


}

