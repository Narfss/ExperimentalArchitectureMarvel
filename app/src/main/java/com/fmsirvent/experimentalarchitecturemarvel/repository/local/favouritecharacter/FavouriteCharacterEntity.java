package com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter;

import android.app.Notification;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "favourite_character")
public class FavouriteCharacterEntity {
    public static final String ID = "id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String MODIFIED = "modified";
    private static final String THUMBNAIL_PATH = "thumbnail_path";
    private static final String THUMBNAIL_EXTENSION = "thumbnail_extension";
    public static final String TIMESTAMP = "timestamp";

    @DatabaseField(columnName = ID, id = true)
    long id;
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
    @DatabaseField(columnName = TIMESTAMP)
    long timestamp;

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

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public String getThumbnailExtension() {
        return thumbnailExtension;
    }

    public static class Builder {
        long id;
        String name;
        String description;
        String modified;
        String thumbnailPath;
        String thumbnailExtension;
        private long timestamp;

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

        public Builder setThumbnailPath(String thumbnailPath) {
            this.thumbnailPath = thumbnailPath;
            return this;
        }

        public Builder setThumbnailExtension(String thumbnailExtension) {
            this.thumbnailExtension = thumbnailExtension;
            return this;
        }

        public Builder setTimestamp(long timestamp) {
            this.timestamp = timestamp;
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
            favouriteCharacterEntity.timestamp = timestamp;
            return favouriteCharacterEntity;
        }
    }
}
