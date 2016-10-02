package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelImage;

import java.util.ArrayList;
import java.util.List;

public class CharactersMapper {
    public static List<MarvelCharacter> map(List<CharacterDataResponse> characters) {
        List<MarvelCharacter> marvelCharacters = new ArrayList<>();
        for (CharacterDataResponse characterDataResponse : characters) {
            marvelCharacters.add(map(characterDataResponse));
        }
        return marvelCharacters;
    }

    public static MarvelCharacter map(CharacterDataResponse characterDataResponse) {
        MarvelCharacter.Builder builder = new MarvelCharacter.Builder();
        MarvelImage thumbnail = ImageMapper.map(characterDataResponse.getThumbnail());
        return builder.setId(characterDataResponse.getId())
                      .setName(characterDataResponse.getName())
                      .setDescription(characterDataResponse.getDescription())
                      .setModified(characterDataResponse.getModified())
                      .setThumbnail(thumbnail)
                      .build();
    }
}
