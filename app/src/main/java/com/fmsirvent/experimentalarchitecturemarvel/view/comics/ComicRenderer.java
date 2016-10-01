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
    @BindView(R.id.comic_title) AppCompatTextView name;

    @LayoutRes
    protected int onLayoutRequest()  {
        return R.layout.comic_renderer;
    }

    @Override
    public void render() {
        MarvelComicMVO character = getContent();
        renderThumbnail(character.getThumbnail());
        renderName(character);
    }

    private void renderName(MarvelComicMVO character) {
        name.setText(character.getTitle());
    }

    private void renderThumbnail(MarvelImageMVO image) {
        String imageURL =
                image.getURL(MarvelImageMVO.AspectRatio.STANDARD, MarvelImageMVO.AspectSize.MEDIUM);
        ImageLoader.loadImage(thumbnail, imageURL);
    }
}
