package com.fmsirvent.experimentalarchitecturemarvel.view.characters;

import com.fmsirvent.experimentalarchitecturemarvel.view.images.MarvelImageMVO;

public class MarvelCharacterMVO {
    private int id;
    private String name;
    private String description;
    private String modified;
    private MarvelImageMVO thumbnail;

    public int getId() {
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

    public MarvelImageMVO getThumbnail() {
        return thumbnail;
    }

    static class Builder {
        private int id;
        private String name;
        private String description;
        private String modified;
        private MarvelImageMVO thumbnail;

        Builder setId(int id) {
            this.id = id;
            return this;
        }

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        Builder setModified(String modified) {
            this.modified = modified;
            return this;
        }

        Builder setThumbnail(MarvelImageMVO thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public MarvelCharacterMVO build() {
            MarvelCharacterMVO marvelCharacter = new MarvelCharacterMVO();
            marvelCharacter.id = id;
            marvelCharacter.name = name;
            marvelCharacter.description = description;
            marvelCharacter.modified = modified;
            marvelCharacter.thumbnail = thumbnail;
            return marvelCharacter;
        }
    }
}
