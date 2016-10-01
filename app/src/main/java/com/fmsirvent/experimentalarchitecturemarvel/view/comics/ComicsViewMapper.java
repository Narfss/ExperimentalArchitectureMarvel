package com.fmsirvent.experimentalarchitecturemarvel.view.comics;

import com.fmsirvent.experimentalarchitecturemarvel.logic.comics.MarvelComic;
import com.fmsirvent.experimentalarchitecturemarvel.view.images.ImageViewMapper;
import com.fmsirvent.experimentalarchitecturemarvel.view.images.MarvelImageMVO;

import java.util.ArrayList;
import java.util.List;

public class ComicsViewMapper {
    public static List<MarvelComicMVO> map(List<MarvelComic> marvelComics) {
        List<MarvelComicMVO> comicsMVO = new ArrayList<>();
        for (MarvelComic marvelComic : marvelComics) {
            comicsMVO.add(map(marvelComic));
        }
        return comicsMVO;
    }

    public static MarvelComicMVO map(MarvelComic marvelComic) {
        MarvelImageMVO thumbnail = ImageViewMapper.map(marvelComic.getThumbnail());
        return new MarvelComicMVO.Builder()
                                 .setId(marvelComic.getId())
                                 .setDigitalId(marvelComic.getDigitalId())
                                 .setTitle(marvelComic.getTitle())
                                 .setIssueNumber(marvelComic.getIssueNumber())
                                 .setDescription(marvelComic.getDescription())
                                 .setModified(marvelComic.getModified())
                                 .setIsbn(marvelComic.getIsbn())
                                 .setPageCount(marvelComic.getPageCount())
                                 .setThumbnail(thumbnail)
                                 .setImages(ImageViewMapper.map(marvelComic.getImages()))
                                 .build();
    }
}
