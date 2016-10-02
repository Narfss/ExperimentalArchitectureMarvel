package com.fmsirvent.experimentalarchitecturemarvel.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.fmsirvent.experimentalarchitecturemarvel.R;
import com.fmsirvent.experimentalarchitecturemarvel.view.images.MarvelImageMVO;

public class CharacterAvatarView extends AppCompatImageView {
    public CharacterAvatarView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CharacterAvatarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CharacterAvatarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_background));
    }

    public void renderAvatar(MarvelImageMVO image) {
        String imageURL =
                image.getURL(MarvelImageMVO.AspectRatio.STANDARD, MarvelImageMVO.AspectSize.MEDIUM);
        ImageLoader.loadCircularImage(this, imageURL);
    }

    public void imagePalette(Palette palette) {
        int vibrantColor = palette.getVibrantColor(Color.WHITE);
        Drawable wrappedDrawable = DrawableCompat.wrap(getBackground());
        DrawableCompat.setTintList(wrappedDrawable, ColorStateList.valueOf(vibrantColor));
        setBackgroundDrawable(wrappedDrawable);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, heightMeasureSpec);
    }
}
