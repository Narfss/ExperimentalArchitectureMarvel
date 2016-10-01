package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.comics;


import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.BaseResponse;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.ComicDataResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ComicsService {
    String COMICS = "v1/public/comics";
    String ID = "/{id}";

    @GET(COMICS + ID)
    Call<BaseResponse<ComicDataResponse>> getComicById(@Path("id") long id,
                                                       @QueryMap Map<String, String> options);
}
