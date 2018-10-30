package com.innowave.assessment.networking;

import android.support.annotation.NonNull;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import com.innowave.assessment.api.GithubApi;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.innowave.assessment.BuildConfig.SERVER_DOMAIN;

class RestClient {

    private static GithubApi githubApi = null;

    public static GithubApi getInstance() {
        if (githubApi == null) {
            githubApi = getRetrofit().create(GithubApi.class);
        }
        return githubApi;
    }

    @NonNull
    private static Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new Retrofit.Builder()
                .baseUrl(SERVER_DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
