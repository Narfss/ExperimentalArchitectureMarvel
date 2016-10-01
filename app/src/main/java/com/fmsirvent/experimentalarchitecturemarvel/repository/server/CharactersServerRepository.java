package com.fmsirvent.experimentalarchitecturemarvel.repository.server;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.EndPointFactory;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.BaseRequest;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.BaseResponse;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharacterDataResponse;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharactersService;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result.Data;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result.DataMapper;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result.OffsetRequest;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class CharactersServerRepository extends BaseRepository {
    private EndPointFactory endPointFactory;

    @Inject
    CharactersServerRepository(EndPointFactory endPointFactory) {
        this.endPointFactory = endPointFactory;
    }

    public Data<MarvelCharacter> getCharacters(int offset) throws RepositoryException {
        Data<MarvelCharacter> marvelCharactersData = null;
        CharactersService service =
                (CharactersService) endPointFactory.getService(CharactersService.class);
        Call<BaseResponse<CharacterDataResponse>> characters =
                service.getCharacters(OffsetRequest.getMap(offset));
        Response<BaseResponse<CharacterDataResponse>> execute;
        try {
            execute = characters.execute();
            if (execute.isSuccessful()) {
                BaseResponse<CharacterDataResponse> body = execute.body();
                if (body.getStatus().compareToIgnoreCase(STATUS_OK) == 0) {
                    marvelCharactersData = DataMapper.map(body.getData());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RepositoryException();
        }
        return marvelCharactersData;
    }
}
