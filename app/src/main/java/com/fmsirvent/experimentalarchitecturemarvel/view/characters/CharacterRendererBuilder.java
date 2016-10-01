package com.fmsirvent.experimentalarchitecturemarvel.view.characters;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.LinkedList;
import java.util.List;

public class CharacterRendererBuilder extends RendererBuilder<MarvelCharacterMVO> {
    public CharacterRendererBuilder() {
        List<Renderer<MarvelCharacterMVO>> prototypes = getMarvelCharacterRendererPrototypes();
        setPrototypes(prototypes);
    }

    @Override
    protected Class getPrototypeClass(MarvelCharacterMVO content) {
        Class prototypeClass;
        prototypeClass = CharacterRenderer.class;
        return prototypeClass;
    }

    private List<Renderer<MarvelCharacterMVO>> getMarvelCharacterRendererPrototypes() {
        List<Renderer<MarvelCharacterMVO>> prototypes = new LinkedList<>();
        CharacterRenderer characterRenderer = new CharacterRenderer();
        prototypes.add(characterRenderer);
        return prototypes;
    }
}
