package com.madarsoft.task.classes.utils;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.madarsoft.task.R;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ActivityContext;


public class Validator {


    Context context;


    @Inject
    public Validator(@ActivityContext Context context) {
        this.context = context;

    }


    public boolean isNotEmpty(TextView view) {
        String value = view.getText().toString().trim();
        if (value.equals("")) {
            view.setError(context.getString(R.string.required));
            view.requestFocus();
            return false;
        }
        return true;
    }



}
