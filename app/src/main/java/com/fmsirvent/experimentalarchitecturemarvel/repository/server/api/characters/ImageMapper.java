package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelImage;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.ImageResponse;

import java.util.ArrayList;
import java.util.List;

public class ImageMapper {
    public static MarvelImage map(ImageResponse image) {
        return new MarvelImage.Builder()
                              .setPath(image.getPath())
                              .setExtension(image.getExtension())
                              .build();
    }

    public static MarvelImage map(String thumbnailPath, String thumbnailExtension) {
        return new MarvelImage.Builder()
                .setPath(thumbnailPath)
                .setExtension(thumbnailExtension)
                .build();
    }

    public static List<MarvelImage> map(List<ImageResponse> images) {
        ArrayList<MarvelImage> marvelImages = new ArrayList<>();
        for (ImageResponse image : images) {
            marvelImages.add(map(image));
        }
        return marvelImages;
    }
}
