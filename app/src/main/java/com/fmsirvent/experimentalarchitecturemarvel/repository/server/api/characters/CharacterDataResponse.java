package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters;

import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.ImageResponse;

public class CharacterDataResponse {
    long id;
    String name;
    String description;
    String modified;
    ImageResponse thumbnail;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public ImageResponse getThumbnail() {
        return thumbnail;
    }
}
