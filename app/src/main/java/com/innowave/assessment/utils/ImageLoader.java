package com.innowave.assessment.utils;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public abstract class ImageLoader {
    public static void loadImage(ImageView imageView, String url){
        Picasso.get().load(url).into(imageView);
    }
}
