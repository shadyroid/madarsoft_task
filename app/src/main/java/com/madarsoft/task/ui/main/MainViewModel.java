package com.madarsoft.task.ui.main;

import androidx.lifecycle.MutableLiveData;

import com.madarsoft.task.classes.room_db.entity.User;
import com.madarsoft.task.ui.$base.BaseViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import timber.log.Timber;

@HiltViewModel
public class MainViewModel extends BaseViewModel {
    @Inject
    public MainViewModel() {
    }


    @Inject
    MutableLiveData<Boolean> addUserResponseMutableLiveData;


    public void insertFavoriteProduct(User user) {
        getCompositeDisposable().add(Observable.just(user)
                .observeOn(Schedulers.io())
                .flatMap(data -> Observable.fromCallable(() -> getRepository().insertUser(data)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    addUserResponseMutableLiveData.setValue(true);
                }, Timber::e));
    }


    public MutableLiveData<Boolean> getAddUserResponseMutableLiveData() {
        return this.addUserResponseMutableLiveData;
    }
}
