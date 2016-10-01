package com.fmsirvent.experimentalarchitecturemarvel.view.images;

import com.fmsirvent.experimentalarchitecturemarvel.logic.images.MarvelImage;

public class ImageMapper {
    public static MarvelImageMVO map(MarvelImage image) {
        return new MarvelImageMVO.Builder()
                                 .setPath(image.getPath())
                                 .setExtension(image.getExtension())
                                 .build();
    }
}
