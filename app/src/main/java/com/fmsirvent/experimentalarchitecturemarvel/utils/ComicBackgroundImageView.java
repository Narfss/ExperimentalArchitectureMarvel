package com.fmsirvent.experimentalarchitecturemarvel.utils;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.fmsirvent.experimentalarchitecturemarvel.R;
import com.fmsirvent.experimentalarchitecturemarvel.view.images.MarvelImageMVO;

import java.util.List;

public class ComicBackgroundImageView extends AppCompatImageView {
    public static final int DELAY_MILLIS = 10000;
    private int currentImage;
    private List<MarvelImageMVO> images;
    private Runnable runnable;

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

    private void init(Context context, AttributeSet attrs, int defStyleAttr) { }

    public void renderImages(final List<MarvelImageMVO> images) {
        this.images = images;
        currentImage = 0;
        loadCurrentImage();
        if (images.size() > 1) {
            postDelayedLoadMore();
        }
    }

    private void postDelayedLoadMore() {
        if (runnable == null) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    increaseCircularCurrentImage();
                    loadCurrentImage();
                }
            };
        }
        postDelayed(runnable, DELAY_MILLIS);
    }

    private void increaseCircularCurrentImage() {
        currentImage++;
        if (currentImage > images.size()) {
            currentImage = 0;
        }
    }

    private void loadCurrentImage() {
        if (currentImage < images.size()) {
            String imageURL = images.get(currentImage).getURL(MarvelImageMVO.Original.DETAIL);
            ImageLoader.loadImageFade(this, imageURL);
            postDelayedLoadMore();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        if (runnable != null) {
            removeCallbacks(runnable);
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
