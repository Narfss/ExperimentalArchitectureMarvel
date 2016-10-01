package com.fmsirvent.experimentalarchitecturemarvel.view.images;

public class MarvelImageMVO {
    private String path;
    private String extension;

    public enum Original {
        DETAIL, FULL_SIZE;
    }

    public enum AspectRatio {
        PORTRAIT("portrait"),
        STANDARD("standard"), //square
        LANDSCAPE("landscape");

        private String ratio;

        AspectRatio(String ratio) {
            this.ratio = ratio;
        }

        @Override
        public String toString() {
            return ratio;
        }
    }

    public enum AspectSize {
        SMALL("small"),
        MEDIUM("medium"),
        XLARGE("xlarge"),
        FANTASTIC("fantastic"),
        UNCANNY("uncanny"),
        INCREDIBLE("incredible");

        private String size;

        AspectSize(String size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return size;
        }
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

    public String getURL(AspectRatio ratio, AspectSize size) {
        return String.format("%s/%s_%s.%s", path, ratio, size, extension);
    }

    public String getURL(Original original) {
        String imageUrl = null;
        switch (original) {
            case DETAIL:
                imageUrl = String.format("%s/detail.%s", path, extension);
                break;
            case FULL_SIZE:
                imageUrl = String.format("%s.%s", path, extension);
                break;
        }
        return imageUrl;
    }

    static class Builder {
        private String path;
        private String extension;

        Builder setPath(String path) {
            this.path = path;
            return this;
        }

        Builder setExtension(String extension) {
            this.extension = extension;
            return this;
        }

        public MarvelImageMVO build() {
            MarvelImageMVO marvelImage = new MarvelImageMVO();
            marvelImage.path = path;
            marvelImage.extension = extension;
            return marvelImage;
        }
    }
}
