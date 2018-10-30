package com.innowave.assessment.callback;

import java.util.List;

import com.innowave.assessment.models.Follower;

public interface FollowerCallBack {
    void onNetworkSuccess(String tag, List<Follower> followers);
}