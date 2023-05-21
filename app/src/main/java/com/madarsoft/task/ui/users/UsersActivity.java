package com.madarsoft.task.ui.users;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.madarsoft.task.classes.adapters.UsersAdapter;
import com.madarsoft.task.classes.room_db.entity.User;
import com.madarsoft.task.databinding.ActivityUsersBinding;
import com.madarsoft.task.ui.$base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class UsersActivity extends BaseActivity {


    ActivityUsersBinding mBinding;
    private UsersViewModel mViewModel;
    @Inject
    UsersAdapter usersAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


        init();

    }

    private void init() {
        mViewModel = new ViewModelProvider(this).get(UsersViewModel.class);
        mViewModel.getUsersResponseMutableLiveData().observe(this, this::onUsersResponse);

        mBinding.actionBar.setNavigationOnClickListener(this::onBackClick);
        mBinding.rvUsers.setAdapter(usersAdapter);

        mViewModel.queryAllUsers();
    }
    protected void onBackClick(View view) {
        finish();
    }

    private void onUsersResponse(List<User> users) {
        usersAdapter.setData(users);
    }


}