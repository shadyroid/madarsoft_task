package com.madarsoft.task.classes.di.modules;

import static com.madarsoft.task.classes.others.CONSTANTS.DB_NAME;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.madarsoft.task.classes.room_db.dao.UsersDao;
import com.madarsoft.task.classes.room_db.db.AppDatabase;
import com.madarsoft.task.classes.room_db.entity.User;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@Module
@InstallIn(SingletonComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static AppDatabase provideAppDatabase(Application application) {
        return Room.databaseBuilder(application,
                        AppDatabase.class, DB_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public static UsersDao provideUsersDao(AppDatabase appDatabase) {
        return appDatabase.usersDao();
    }

    @Provides
    public MutableLiveData<List<User>> provideUsersMutableLiveData() {
        return new MutableLiveData<>();
    }

    @Provides
    public MutableLiveData<Boolean> provideBooleanMutableLiveData() {
        return new MutableLiveData<>();
    }

    @Provides
    public CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
