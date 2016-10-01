package com.fmsirvent.experimentalarchitecturemarvel.view.comics;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.LinkedList;
import java.util.List;

public class ComicsRendererBuilder extends RendererBuilder<MarvelComicMVO> {
    public ComicsRendererBuilder() {
        List<Renderer<MarvelComicMVO>> prototypes = getMarvelComicsRendererPrototypes();
        setPrototypes(prototypes);
    }

    @Override
    protected Class getPrototypeClass(MarvelComicMVO content) {
        Class prototypeClass;
        prototypeClass = ComicRenderer.class;
        return prototypeClass;
    }

    private List<Renderer<MarvelComicMVO>> getMarvelComicsRendererPrototypes() {
        List<Renderer<MarvelComicMVO>> prototypes = new LinkedList<>();
        ComicRenderer comicRenderer = new ComicRenderer();
        prototypes.add(comicRenderer);
        return prototypes;
    }
}
