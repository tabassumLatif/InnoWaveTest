package com.innowave.assessment.api;


import java.util.List;

import com.innowave.assessment.models.User;
import com.innowave.assessment.models.Follower;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.innowave.assessment.BuildConfig.API_USER_FOLLOWERS;
import static com.innowave.assessment.BuildConfig.API_USER_NAME;


public interface GithubApi {

    @GET(API_USER_NAME)
    Call <User> getUser(@Path("username") String username);
//    Observable<List<User>> getUser(@Path("username") String user);

    @GET(API_USER_FOLLOWERS)
    Call <List<Follower>> getUsersFollowers(@Path("username") String username);

}