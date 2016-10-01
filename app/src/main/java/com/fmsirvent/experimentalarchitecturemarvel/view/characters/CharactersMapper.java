package com.fmsirvent.experimentalarchitecturemarvel.view.characters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.logic.images.MarvelImage;
import com.fmsirvent.experimentalarchitecturemarvel.view.images.ImageMapper;

import java.util.ArrayList;
import java.util.List;

public class CharactersMapper {
    public static List<MarvelCharacterMVO> map(List<MarvelCharacter> characters) {
        List<MarvelCharacterMVO> charactersMVO = new ArrayList<>();
        for (MarvelCharacter character : characters) {
            charactersMVO.add(map(character));
        }
        return charactersMVO;
    }

    public static MarvelCharacterMVO map(MarvelCharacter character) {
        MarvelCharacterMVO.Builder builder = new MarvelCharacterMVO.Builder();
        return builder.setId(character.getId())
                        .setName(character.getName())
                        .setDescription(character.getDescription())
                        .setModified(character.getModified())
                        .setThumbnail(ImageMapper.map(character.getThumbnail()))
                        .build();
    }

    public static MarvelCharacter map(MarvelCharacterMVO character) {
        MarvelCharacter.Builder builder = new MarvelCharacter.Builder();
        MarvelImage thumbnail = ImageMapper.map(character.getThumbnail());
        return builder.setId(character.getId())
                .setName(character.getName())
                .setDescription(character.getDescription())
                .setModified(character.getModified())
                .setThumbnail(thumbnail)
                .build();
    }
}
