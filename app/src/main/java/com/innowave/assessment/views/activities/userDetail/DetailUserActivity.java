package com.innowave.assessment.views.activities.userDetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import com.innowave.assessment.R;
import com.innowave.assessment.callback.FollowerCallBack;
import com.innowave.assessment.models.Follower;
import com.innowave.assessment.models.User;
import com.innowave.assessment.networking.NetworkManager;
import com.innowave.assessment.utils.ImageLoader;
import com.innowave.assessment.views.adapters.FollowersAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.innowave.assessment.utils.Constents.KEY_USER;

public class DetailUserActivity extends AppCompatActivity implements FollowerCallBack {

    @BindView(R.id.ivProfilePic)
    ImageView ivProfilePic;
    @BindView(R.id.tvUserName)
    TextView tvUserName;
    @BindView(R.id.tvUserBio)
    TextView tvUserBio;
    @BindView(R.id.tvFollowers)
    TextView tvFollowers;
    @BindView(R.id.rvFollowers)
    RecyclerView rvFollowers;

    private NetworkManager networkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        initializeNetworkRequest();
        initViews();
    }

    private void initializeNetworkRequest() {
        networkManager = new NetworkManager(this);
    }

    private void initViews() {
        User user = (User) Objects.requireNonNull(getIntent().getExtras()).getSerializable(KEY_USER);
        if (user != null) {
            ImageLoader.loadImage(ivProfilePic, user.getAvatarUrl());
            tvUserBio.setText(user.getBio());
            tvUserName.setText(user.getName());
            getFollowers(user);
        }
    }

    private void getFollowers(User user) {
        networkManager.getUsersFollowers(this, user.getLogin());
    }

    @Override
    public void onNetworkSuccess(String tag, List<Follower> followers) {
        FollowersAdapter followersAdapter = new FollowersAdapter(followers);
        rvFollowers.setLayoutManager(new LinearLayoutManager(this));
        rvFollowers.setAdapter(followersAdapter);
        if(followers.isEmpty()){
            tvFollowers.setText(R.string.notFound);
        }
    }

}
