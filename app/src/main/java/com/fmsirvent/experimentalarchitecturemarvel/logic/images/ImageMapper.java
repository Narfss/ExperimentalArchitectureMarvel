package com.fmsirvent.experimentalarchitecturemarvel.logic.images;

import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.ImageResponse;

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
}
