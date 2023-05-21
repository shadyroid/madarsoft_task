package com.madarsoft.task.ui.users;

import androidx.lifecycle.MutableLiveData;

import com.madarsoft.task.classes.room_db.entity.User;
import com.madarsoft.task.ui.$base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import timber.log.Timber;

@HiltViewModel
public class UsersViewModel extends BaseViewModel {
    @Inject
    public UsersViewModel() {
    }


    @Inject
    MutableLiveData<List<User>> usersResponseMutableLiveData;


    public void queryAllUsers() {
        getCompositeDisposable().add(Observable.just("")
                .observeOn(Schedulers.io())
                .flatMap(__ -> getRepository().queryAllUsers())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> usersResponseMutableLiveData.setValue(response), Timber::e));
    }

    public MutableLiveData<List<User>> getUsersResponseMutableLiveData() {
        return this.usersResponseMutableLiveData;
    }
}