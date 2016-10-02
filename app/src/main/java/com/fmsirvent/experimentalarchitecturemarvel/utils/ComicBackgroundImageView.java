package com.fmsirvent.experimentalarchitecturemarvel.utils;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.fmsirvent.experimentalarchitecturemarvel.view.images.MarvelImageMVO;

import java.util.List;

public class ComicBackgroundImageView extends FrameLayout {
    public static final int DELAY_MILLIS = 3000;
    private int currentImage;
    private List<MarvelImageMVO> images;
    private Runnable runnable;
    private Runnable frontRunnable;
    private AppCompatImageView backgroundImage;
    private AppCompatImageView overBackgroundImage;

    public ComicBackgroundImageView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ComicBackgroundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ComicBackgroundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        backgroundImage = new AppCompatImageView(context);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        backgroundImage.setLayoutParams(params);
        backgroundImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(backgroundImage);
        overBackgroundImage = new AppCompatImageView(context);
        overBackgroundImage.setLayoutParams(params);
        overBackgroundImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(overBackgroundImage);
    }

    public void renderImages(final List<MarvelImageMVO> images) {
        this.images = images;
        currentImage = 0;
        loadCurrentImage();
    }

    private void postDelayedLoadMore() {
        if (runnable == null) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    loadCurrentImageInBackground();
                    postDelayLoadOverBackground();
                }
            };
        }
        postDelayed(runnable, DELAY_MILLIS);
    }

    private void postDelayLoadOverBackground() {
        if (frontRunnable == null) {
            frontRunnable = new Runnable() {
                @Override
                public void run() {
                    increaseCircularCurrentImage();
                    loadCurrentImage();
                }
            };
        }
        postDelayed(frontRunnable, DELAY_MILLIS);
    }

    private void increaseCircularCurrentImage() {
        currentImage++;
        if (currentImage >= images.size()) {
            currentImage = 0;
        }
    }

    private void loadCurrentImageInBackground() {
        if (currentImage < images.size()) {
            String imageURL = images.get(currentImage).getURL(MarvelImageMVO.Original.DETAIL);
            ImageLoader.loadImage(backgroundImage, imageURL);
        }
    }

    private void loadCurrentImage() {
        if (currentImage < images.size()) {
            String imageURL = images.get(currentImage).getURL(MarvelImageMVO.Original.DETAIL);
            ImageLoader.loadImageFade(overBackgroundImage, imageURL);
            if (images.size() > 1) {
                postDelayedLoadMore();
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        if (runnable != null) {
            removeCallbacks(runnable);
            removeCallbacks(frontRunnable);
        }
        super.onDetachedFromWindow();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (images != null
            && images.size() > 1) {
            postDelayedLoadMore();
        }
    }
}
