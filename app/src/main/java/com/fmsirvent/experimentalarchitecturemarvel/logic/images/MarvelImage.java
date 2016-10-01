package com.fmsirvent.experimentalarchitecturemarvel.logic.images;

public class MarvelImage {
    private String path;
    private String extension;

    public String getExtension() {
        return extension;
    }

    public String getPath() {
        return path;
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

        public MarvelImage build() {
            MarvelImage marvelImage = new MarvelImage();
            marvelImage.path = path;
            marvelImage.extension = extension;
            return marvelImage;
        }
    }
}
