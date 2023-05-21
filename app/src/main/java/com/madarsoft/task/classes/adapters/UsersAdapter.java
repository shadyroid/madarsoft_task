package com.madarsoft.task.classes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.madarsoft.task.R;
import com.madarsoft.task.classes.room_db.entity.User;
import com.madarsoft.task.databinding.ListItemUserBinding;

import java.util.List;

import javax.inject.Inject;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersAdapterViewHolder> {

    //The list of Objects that will populate the RecyclerView
    private List<User> mData;

    Context context;


    @Inject
    public UsersAdapter(List<User> users) {
        mData = users;
    }

    @NonNull
    @Override
    public UsersAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_user, parent, false);
        return new UsersAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapterViewHolder holder, int position) {
        holder.mBinding.tvUserName.setText(mData.get(position).getUserName());
        holder.mBinding.tvAge.setText(mData.get(position).getAge());
        holder.mBinding.tvJobTitle.setText(mData.get(position).getJobTitle());
        holder.mBinding.tvGender.setText(context.getString(mData.get(position).getGender() == 0 ? R.string.male : R.string.female));

    }

    @Override
    public int getItemCount() {
        if (null == mData) return 0;
        return mData.size();
    }

    public void setData(List<User> data) {
        mData = data;
        notifyDataSetChanged();
    }


    public class UsersAdapterViewHolder extends RecyclerView.ViewHolder {

        ListItemUserBinding mBinding;


        public UsersAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mBinding = ListItemUserBinding.bind(itemView);
        }



    }


}
