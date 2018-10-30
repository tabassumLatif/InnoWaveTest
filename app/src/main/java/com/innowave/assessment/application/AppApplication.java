package com.innowave.assessment.application;

import android.app.Application;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        cachePicasso();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private void cachePicasso() {
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this, Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);
    }
}
