package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result;

import com.fmsirvent.experimentalarchitecturemarvel.logic.comics.MarvelComic;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharactersMapper;
import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.DataResponse;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharacterDataResponse;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.ComicDataResponse;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.ComicsMapper;

public class DataMapper {
    public static Data<MarvelCharacter> mapCharacters(DataResponse<CharacterDataResponse> data) {
        Data.Builder<MarvelCharacter> builder = new Data.Builder<>();
        return builder.setCount(data.getCount())
                      .setLimit(data.getLimit())
                      .setOffset(data.getOffset())
                      .setTotal(data.getTotal())
                      .setResult(CharactersMapper.map(data.getResults()))
                      .build();
    }

    public static Data<MarvelComic> mapComics(DataResponse<ComicDataResponse> data) {
        Data.Builder<MarvelComic> builder = new Data.Builder<>();
        return builder.setCount(data.getCount())
                      .setLimit(data.getLimit())
                      .setOffset(data.getOffset())
                      .setTotal(data.getTotal())
                      .setResult(ComicsMapper.map(data.getResults()))
                      .build();
    }
}
