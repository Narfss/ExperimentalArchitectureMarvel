package com.fmsirvent.experimentalarchitecturemarvel.logic.dto;

public class MarvelCharacter {
    private long id;
    private String name;
    private String description;
    private String modified;
    private MarvelImage thumbnail;

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

    public MarvelImage getThumbnail() {
        return thumbnail;
    }

    public static class Builder {
        private long id;
        private String name;
        private String description;
        private String modified;
        private MarvelImage thumbnail;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
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

        public Builder setThumbnail(MarvelImage thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public MarvelCharacter build() {
            MarvelCharacter marvelCharacter = new MarvelCharacter();
            marvelCharacter.id = id;
            marvelCharacter.name = name;
            marvelCharacter.description = description;
            marvelCharacter.modified = modified;
            marvelCharacter.thumbnail = thumbnail;
            return marvelCharacter;
        }
    }
}
