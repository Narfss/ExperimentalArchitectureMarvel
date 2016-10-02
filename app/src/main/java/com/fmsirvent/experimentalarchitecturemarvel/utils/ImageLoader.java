package com.fmsirvent.experimentalarchitecturemarvel.utils;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

public class ImageLoader {
    public static void loadImage(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
             .load(imageURL)
             .into(imageView);
    }

    public static void loadCircularImage(final CharacterAvatar imageView, String imageURL) {
        Glide.with(imageView.getContext())
             .load(imageURL)
             .asBitmap()
             .centerCrop()
             .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(imageView.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        imageView.setImageDrawable(circularBitmapDrawable);
                        imageView.imagePalette(Palette.from(resource).generate());
                    }
              });
    }
}
