package com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "favourite_character")
public class FavouriteCharacterEntity {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String MODIFIED = "modified";
    private static final String THUMBNAIL_PATH = "thumbnail_path";
    private static final String THUMBNAIL_EXTENSION = "thumbnail_extension";

    @DatabaseField(columnName = ID, id = true)
    int id;
    @DatabaseField(columnName = NAME)
    String name;
    @DatabaseField(columnName = DESCRIPTION)
    String description;
    @DatabaseField(columnName = MODIFIED)
    String modified;
    @DatabaseField(columnName = THUMBNAIL_PATH)
    String thumbnailPath;
    @DatabaseField(columnName = THUMBNAIL_EXTENSION)
    String thumbnailExtension;

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

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public String getThumbnailExtension() {
        return thumbnailExtension;
    }

    public static class Builder {
        int id;
        String name;
        String description;
        String modified;
        String thumbnailPath;
        String thumbnailExtension;

        public Builder setId(int id) {
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

        public Builder setThumbnailPath(String thumbnailPath) {
            this.thumbnailPath = thumbnailPath;
            return this;
        }

        public Builder setThumbnailExtension(String thumbnailExtension) {
            this.thumbnailExtension = thumbnailExtension;
            return this;
        }

        public FavouriteCharacterEntity build() {
            FavouriteCharacterEntity favouriteCharacterEntity = new FavouriteCharacterEntity();
            favouriteCharacterEntity.id = id;
            favouriteCharacterEntity.name = name;
            favouriteCharacterEntity.description = description;
            favouriteCharacterEntity.modified = modified;
            favouriteCharacterEntity.thumbnailPath = thumbnailPath;
            favouriteCharacterEntity.thumbnailExtension = thumbnailExtension;
            return favouriteCharacterEntity;
        }
    }
}