package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result;

import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharactersMapper;
import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.DataResponse;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharacterDataResponse;

public class DataMapper {
    public static Data<MarvelCharacter> map(DataResponse<CharacterDataResponse> data) {
        Data.Builder<MarvelCharacter> builder = new Data.Builder<>();
        return builder.setCount(data.getCount())
                      .setLimit(data.getLimit())
                      .setOffset(data.getOffset())
                      .setTotal(data.getTotal())
                      .setResult(CharactersMapper.map(data.getResults()))
                      .build();
    }
}
