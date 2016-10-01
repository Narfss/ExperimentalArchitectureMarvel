package com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.logic.images.ImageMapper;
import com.fmsirvent.experimentalarchitecturemarvel.logic.images.MarvelImage;

import java.util.ArrayList;
import java.util.List;

public class CharacterEntityMapper {
    public static List<MarvelCharacter> map(List<FavouriteCharacterEntity> characters) {
        List<MarvelCharacter> marvelCharacters = new ArrayList<>();
        for (FavouriteCharacterEntity characterDataResponse : characters) {
            marvelCharacters.add(map(characterDataResponse));
        }
        return marvelCharacters;
    }

    public static MarvelCharacter map(FavouriteCharacterEntity characterDataResponse) {
        MarvelCharacter.Builder builder = new MarvelCharacter.Builder();
        MarvelImage thumbnail = ImageMapper.map(characterDataResponse.getThumbnailPath(),
                                                characterDataResponse.getThumbnailExtension());
        return builder.setId(characterDataResponse.getId())
                .setName(characterDataResponse.getName())
                .setDescription(characterDataResponse.getDescription())
                .setModified(characterDataResponse.getModified())
                .setThumbnail(thumbnail)
                .build();
    }

    public static FavouriteCharacterEntity map(MarvelCharacter character) {
        return new FavouriteCharacterEntity.Builder()
                .setId(character.getId())
                .setName(character.getName())
                .setDescription(character.getDescription())
                .setModified(character.getModified())
                .setThumbnailPath(character.getThumbnail().getPath())
                .setThumbnailExtension(character.getThumbnail().getExtension())
                .setTimestamp(System.currentTimeMillis())
                .build();
    }
}
