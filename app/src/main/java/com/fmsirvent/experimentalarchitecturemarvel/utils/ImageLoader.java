package com.fmsirvent.experimentalarchitecturemarvel.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;

public class ImageLoader {
    public static final int FADE_DURATION = 2000;

    public static void loadImage(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
                .load(imageURL)
                .into(imageView);
    }

    public static void loadImageFade(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
             .load(imageURL)
             .crossFade(FADE_DURATION)
             .skipMemoryCache(true)
             .into(imageView);
    }

    public static void loadCircularImage(final CharacterAvatarView imageView, String imageURL) {
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
