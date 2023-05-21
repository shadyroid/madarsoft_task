package com.madarsoft.task.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.madarsoft.task.classes.room_db.entity.User;
import com.madarsoft.task.databinding.ActivityMainBinding;
import com.madarsoft.task.ui.$base.BaseActivity;
import com.madarsoft.task.ui.users.UsersActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getAddUserResponseMutableLiveData().observe(this, this::onAddUserResponse);

        binding.btnAdd.setOnClickListener(this::onAddClick);
        binding.fabList.setOnClickListener(this::onListClick);
    }

    private void onAddUserResponse(Boolean isAdded) {
        binding.etUserName.setText("");
        binding.etAge.setText("");
        binding.etJobTitle.setText("");
        binding.rbMale.setChecked(true);
        binding.rbFemale.setChecked(false);
    }

    private void onListClick(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }

    private void onAddClick(View view) {
        if (!isValid())
            return;
        viewModel.insertFavoriteProduct(User.builder()
                .userName(binding.etUserName.getText().toString())
                .age(binding.etAge.getText().toString())
                .jobTitle(binding.etJobTitle.getText().toString())
                .gender(binding.rbMale.isChecked() ? 0 : 1)
                .build());

    }

    private boolean isValid() {
        return
                validator.isNotEmpty(binding.etUserName) &&
                        validator.isNotEmpty(binding.etAge) &&
                        validator.isNotEmpty(binding.etJobTitle);

    }
}