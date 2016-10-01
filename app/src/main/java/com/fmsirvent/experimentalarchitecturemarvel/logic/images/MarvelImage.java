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

    public static class Builder {
        private String path;
        private String extension;

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public Builder setExtension(String extension) {
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
