package com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters;

import android.support.annotation.LayoutRes;

import com.fmsirvent.experimentalarchitecturemarvel.R;
import com.fmsirvent.experimentalarchitecturemarvel.utils.CharacterAvatarView;
import com.fmsirvent.experimentalarchitecturemarvel.utils.RendererButterKnife;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.MarvelCharacterMVO;
import com.fmsirvent.experimentalarchitecturemarvel.view.images.MarvelImageMVO;

import butterknife.BindView;

public class FavouriteCharacterRenderer extends RendererButterKnife<MarvelCharacterMVO> {
    @BindView(R.id.character_thumbnail)
    CharacterAvatarView thumbnail;

    @LayoutRes
    protected int onLayoutRequest()  {
        return R.layout.favourite_character_renderer;
    }

    @Override
    public void render() {
        MarvelCharacterMVO character = getContent();
        renderThumbnail(character.getThumbnail());
    }

    private void renderThumbnail(MarvelImageMVO image) {
        thumbnail.renderAvatar(image);
    }
}
