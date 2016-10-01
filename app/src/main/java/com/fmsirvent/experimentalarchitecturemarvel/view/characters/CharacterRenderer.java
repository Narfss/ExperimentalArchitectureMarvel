package com.fmsirvent.experimentalarchitecturemarvel.view.characters;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;

import com.fmsirvent.experimentalarchitecturemarvel.R;
import com.fmsirvent.experimentalarchitecturemarvel.utils.ImageLoader;
import com.fmsirvent.experimentalarchitecturemarvel.utils.RendererButterKnife;
import com.fmsirvent.experimentalarchitecturemarvel.view.images.MarvelImageMVO;

import butterknife.BindView;

public class CharacterRenderer extends RendererButterKnife<MarvelCharacterMVO> {
    @BindView(R.id.character_thumbnail) AppCompatImageView thumbnail;
    @BindView(R.id.character_name) AppCompatTextView name;

    @LayoutRes
    protected int onLayoutRequest()  {
        return R.layout.character_renderer;
    }

    @Override
    public void render() {
        MarvelCharacterMVO character = getContent();
        renderThumbnail(character.getThumbnail());
        renderName(character);
    }

    private void renderName(MarvelCharacterMVO character) {
        name.setText(character.getName());
    }

    private void renderThumbnail(MarvelImageMVO image) {
        String imageURL =
                image.getURL(MarvelImageMVO.AspectRatio.STANDARD, MarvelImageMVO.AspectSize.MEDIUM);
        ImageLoader.loadImage(thumbnail, imageURL);
    }
}
