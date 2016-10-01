package com.fmsirvent.experimentalarchitecturemarvel.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader {
    public static void loadImage(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
             .load(imageURL)
             .into(imageView);
    }
}
