package com.madarsoft.task.ui.$base;

import androidx.lifecycle.ViewModel;

import com.madarsoft.task.classes.Repository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@HiltViewModel
public class BaseViewModel extends ViewModel {


    @Inject
    Repository repository;
    @Inject
    CompositeDisposable compositeDisposable;

    @Inject
    public BaseViewModel() {
    }



    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

    public Repository getRepository() {
        return this.repository;
    }

    public CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }
}
