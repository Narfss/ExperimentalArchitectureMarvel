package com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters;

import com.fmsirvent.experimentalarchitecturemarvel.view.characters.MarvelCharacterMVO;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.LinkedList;
import java.util.List;

public class FavouriteCharacterRendererBuilder extends RendererBuilder<MarvelCharacterMVO> {
    public FavouriteCharacterRendererBuilder() {
        List<Renderer<MarvelCharacterMVO>> prototypes = getMarvelCharacterRendererPrototypes();
        setPrototypes(prototypes);
    }

    @Override
    protected Class getPrototypeClass(MarvelCharacterMVO content) {
        Class prototypeClass;
        prototypeClass = FavouriteCharacterRenderer.class;
        return prototypeClass;
    }

    private List<Renderer<MarvelCharacterMVO>> getMarvelCharacterRendererPrototypes() {
        List<Renderer<MarvelCharacterMVO>> prototypes = new LinkedList<>();
        FavouriteCharacterRenderer favouriteCharacterRenderer = new FavouriteCharacterRenderer();
        prototypes.add(favouriteCharacterRenderer);
        return prototypes;
    }
}
