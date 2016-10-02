package com.fmsirvent.experimentalarchitecturemarvel.view.comics;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;

import com.fmsirvent.experimentalarchitecturemarvel.R;
import com.fmsirvent.experimentalarchitecturemarvel.utils.ImageLoader;
import com.fmsirvent.experimentalarchitecturemarvel.utils.RendererButterKnife;
import com.fmsirvent.experimentalarchitecturemarvel.view.images.MarvelImageMVO;

import butterknife.BindView;

public class ComicRenderer extends RendererButterKnife<MarvelComicMVO> {
    @BindView(R.id.comic_thumbnail) AppCompatImageView thumbnail;

    @LayoutRes
    protected int onLayoutRequest()  {
        return R.layout.comic_renderer;
    }

    @Override
    public void render() {
        MarvelComicMVO character = getContent();
        renderThumbnail(character.getThumbnail());
    }

    private void renderThumbnail(MarvelImageMVO image) {
        String imageURL =
                image.getURL(MarvelImageMVO.AspectRatio.PORTRAIT, MarvelImageMVO.AspectSize.MEDIUM);
        ImageLoader.loadImage(thumbnail, imageURL);
    }
}
