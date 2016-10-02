package com.fmsirvent.experimentalarchitecturemarvel.logic.dto;

import java.util.List;

public class MarvelComic {
    long id;
    int digitalId;
    String title;
    int issueNumber;
    String description;
    String modified;
    String isbn;
    int pageCount;
    MarvelImage thumbnail;
    List<MarvelImage> images;

    public long getId() {
        return id;
    }

    public int getDigitalId() {
        return digitalId;
    }

    public String getTitle() {
        return title;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPageCount() {
        return pageCount;
    }

    public MarvelImage getThumbnail() {
        return thumbnail;
    }

    public List<MarvelImage> getImages() {
        return images;
    }

    public static class Builder {
        long id;
        int digitalId;
        String title;
        int issueNumber;
        String description;
        String modified;
        String isbn;
        int pageCount;
        MarvelImage thumbnail;
        List<MarvelImage> images;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setDigitalId(int digitalId) {
            this.digitalId = digitalId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setIssueNumber(int issueNumber) {
            this.issueNumber = issueNumber;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setModified(String modified) {
            this.modified = modified;
            return this;
        }

        public Builder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder setPageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        public Builder setThumbnail(MarvelImage thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder setImages(List<MarvelImage> images) {
            this.images = images;
            return this;
        }

        public MarvelComic build() {
            MarvelComic marvelComic = new MarvelComic();
            marvelComic.id = id;
            marvelComic.digitalId = digitalId;
            marvelComic.title = title;
            marvelComic.issueNumber = issueNumber;
            marvelComic.description = description;
            marvelComic.modified = modified;
            marvelComic.isbn = isbn;
            marvelComic.pageCount = pageCount;
            marvelComic.thumbnail = thumbnail;
            marvelComic.images = images;
            return marvelComic;
        }
    }
}
