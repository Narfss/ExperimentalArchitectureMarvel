package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters;

import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.ImageResponse;

import java.util.List;

public class ComicDataResponse {
    long id;
    int digitalId;
    String title;
    int issueNumber;
    String description;
    String modified;
    String isbn;
    int pageCount;
    ImageResponse thumbnail;
    List<ImageResponse> images;

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

    public ImageResponse getThumbnail() {
        return thumbnail;
    }

    public List<ImageResponse> getImages() {
        return images;
    }
}
