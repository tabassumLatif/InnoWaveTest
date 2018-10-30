package com.innowave.assessment.networking;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.List;

import com.innowave.assessment.R;
import com.innowave.assessment.callback.FollowerCallBack;
import com.innowave.assessment.callback.UserCallBack;
import com.innowave.assessment.models.User;
import com.innowave.assessment.models.Follower;
import com.innowave.assessment.views.aleart.AleartDialogs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkManager {

    private FollowerCallBack followerCallBack;
    private UserCallBack userCallBack;

    @NonNull
    private Callback<User> getNetworkCallback(final Activity mActivity, final String TAG) {
        return new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> userCall, @NonNull Response<User> userResponse) {
                if (userResponse.isSuccessful()) {
                    if (userCallBack != null) {
                        userCallBack.onNetworkSuccess(TAG, userResponse.body());
                    }
                } else{
                    userCallBack.error();
                   AleartDialogs.userNotFound(mActivity,TAG);
                }
            }
            @Override
            public void onFailure(@NonNull Call<User> userCall, @NonNull Throwable throwable) {
            }
        };
    }

    @NonNull
    private Callback<List<Follower>> getUserFollowers(final Activity mActivity, final String TAG) {
        return new Callback<List<Follower>>() {
            @Override
            public void onResponse(@NonNull Call<List<Follower>> call, @NonNull Response<List<Follower>> followers) {
                if (followers.isSuccessful()) {
                    if (followerCallBack != null) {
                        followerCallBack.onNetworkSuccess(TAG, followers.body());
                    }
                } else
                    Toast.makeText(mActivity, mActivity.getString(R.string.no_data_found), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<List<Follower>> call, @NonNull Throwable throwable) {
            }
        };
    }

    public NetworkManager(FollowerCallBack mListener) {
        this.followerCallBack = mListener;
    }
    public NetworkManager(UserCallBack userRequest) {
        this.userCallBack = userRequest;
    }

    public void getUser(final Activity mActivity, final String userName) {
        Call<User> getUserInfo = RestClient.getInstance().getUser(userName);
        getUserInfo.enqueue(getNetworkCallback(mActivity, "/users/" + userName));
    }

    public void getUsersFollowers(final Activity mActivity, String userName) {
        Call<List<Follower>> userFollowers = RestClient.getInstance().getUsersFollowers(userName);
        userFollowers.enqueue(getUserFollowers(mActivity, "/users/" + userName + "/followers"));
    }
}