package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.comics;

import com.fmsirvent.experimentalarchitecturemarvel.logic.comics.MarvelComic;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.EndPointFactory;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.BaseRepository;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.BaseRequest;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.BaseResponse;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.ComicDataResponse;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result.Data;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result.DataMapper;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class ComicsServerApi extends BaseRepository implements ComicsServerRepository {
    private EndPointFactory endPointFactory;

    @Inject
    public ComicsServerApi(EndPointFactory endPointFactory) {
        this.endPointFactory = endPointFactory;
    }

    @Override
    public Data<MarvelComic> getComicById(long comicId) throws RepositoryException {
        Data<MarvelComic> marvelComicsData = null;
        ComicsService service =
                (ComicsService) endPointFactory.getService(ComicsService.class);
        Call<BaseResponse<ComicDataResponse>> characters =
                service.getComicById(comicId, BaseRequest.getMap());
        Response<BaseResponse<ComicDataResponse>> execute;
        try {
            execute = characters.execute();
            if (execute.isSuccessful()) {
                BaseResponse<ComicDataResponse> body = execute.body();
                if (body.getStatus().compareToIgnoreCase(STATUS_OK) == 0
                        && body.getData().getResults().size() == 1) {
                    marvelComicsData = DataMapper.mapComics(body.getData());
                } else {
                    throw new RepositoryException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RepositoryException();
        }
        return marvelComicsData;
    }
}
