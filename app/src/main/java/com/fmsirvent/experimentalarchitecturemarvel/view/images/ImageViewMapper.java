package com.fmsirvent.experimentalarchitecturemarvel.view.images;

import com.fmsirvent.experimentalarchitecturemarvel.logic.images.MarvelImage;

import java.util.ArrayList;
import java.util.List;

public class ImageViewMapper {
    public static MarvelImageMVO map(MarvelImage image) {
        return new MarvelImageMVO.Builder()
                                 .setPath(image.getPath())
                                 .setExtension(image.getExtension())
                                 .build();
    }

    public static MarvelImage map(MarvelImageMVO image) {
        return new MarvelImage.Builder()
                              .setPath(image.getPath())
                              .setExtension(image.getExtension())
                              .build();
    }

    public static List<MarvelImageMVO> map(List<MarvelImage> images) {
        List<MarvelImageMVO> imagesMVO = new ArrayList<>();
        for (MarvelImage image : images) {
            imagesMVO.add(map(image));
        }
        return imagesMVO;
    }
}
