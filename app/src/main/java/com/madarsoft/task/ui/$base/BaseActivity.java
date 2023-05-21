package com.madarsoft.task.ui.$base;

import androidx.appcompat.app.AppCompatActivity;

import com.madarsoft.task.classes.utils.Validator;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BaseActivity extends AppCompatActivity {

    @Inject
    public Validator validator;

}
