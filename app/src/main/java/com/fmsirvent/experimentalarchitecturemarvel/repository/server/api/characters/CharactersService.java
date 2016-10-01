package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters;


import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.BaseResponse;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.DataResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface CharactersService {
    String CHARACTERS = "v1/public/characters";
    String ID = "/{id}";
    String COMICS = "/comics";

    @GET(CHARACTERS)
    Call<BaseResponse<CharacterDataResponse>> getCharacters(@QueryMap Map<String, String> options);

    @GET(CHARACTERS + ID)
    Call<BaseResponse<CharacterDataResponse>> getCharacter(@Path("id") long id,
                                                           @QueryMap Map<String, String> options);

    @GET(CHARACTERS + ID + COMICS)
    Call<BaseResponse<ComicDataResponse>> getCharacterComics(@Path("id") long id,
                                                             @QueryMap Map<String, String> options);
}
