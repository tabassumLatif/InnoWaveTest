package com.innowave.assessment.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.innowave.assessment.R;
import com.innowave.assessment.models.Follower;
import com.innowave.assessment.utils.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.FollowerHolder> {


    private List<Follower> followers;

    public FollowersAdapter(List<Follower> genericResponse) {
        this.followers = genericResponse;
    }

    @NonNull
    @Override
    public FollowerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_follower, parent, false);
        return new FollowerHolder(view);
    }

    @Override
    public void onBindViewHolder(FollowerHolder holder, int index) {
        Follower followers = this.followers.get(index);
        holder.tvUserName.setText(followers.getLogin());
        ImageLoader.loadImage(holder.ivProfile, followers.getAvatarUrl());
    }

    @Override
    public int getItemCount() {
        return followers.size();
    }

    public class FollowerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivProfile)
        ImageView ivProfile;
        @BindView(R.id.tvUserName)
        TextView tvUserName;

         FollowerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
