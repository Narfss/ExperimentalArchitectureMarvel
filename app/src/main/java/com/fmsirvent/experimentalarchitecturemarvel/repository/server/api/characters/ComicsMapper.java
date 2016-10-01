package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.comics.MarvelComic;
import com.fmsirvent.experimentalarchitecturemarvel.logic.images.ImageMapper;
import com.fmsirvent.experimentalarchitecturemarvel.logic.images.MarvelImage;

import java.util.ArrayList;
import java.util.List;

public class ComicsMapper {
    public static List<MarvelComic> map(List<ComicDataResponse> characters) {
        List<MarvelComic> marvelCharacters = new ArrayList<>();
        for (ComicDataResponse comicDataResponse : characters) {
            marvelCharacters.add(map(comicDataResponse));
        }
        return marvelCharacters;
    }

    public static MarvelComic map(ComicDataResponse comicDataResponse) {
        MarvelComic.Builder builder = new MarvelComic.Builder();
        MarvelImage thumbnail = ImageMapper.map(comicDataResponse.getThumbnail());
        List<MarvelImage> images = ImageMapper.map(comicDataResponse.getImages());
        return builder.setId(comicDataResponse.getId())
                      .setDigitalId(comicDataResponse.getDigitalId())
                      .setTitle(comicDataResponse.getTitle())
                      .setIssueNumber(comicDataResponse.getIssueNumber())
                      .setDescription(comicDataResponse.getDescription())
                      .setModified(comicDataResponse.getModified())
                      .setIsbn(comicDataResponse.getIsbn())
                      .setPageCount(comicDataResponse.getPageCount())
                      .setThumbnail(thumbnail)
                      .setImages(images)
                      .build();
    }
}
