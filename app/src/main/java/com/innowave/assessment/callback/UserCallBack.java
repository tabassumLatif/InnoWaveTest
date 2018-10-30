package com.innowave.assessment.callback;

import com.innowave.assessment.models.User;

public interface UserCallBack {
    void onNetworkSuccess(String tag, User user);
    void error();
}
