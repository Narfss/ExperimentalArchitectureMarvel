package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.comics;

import com.fmsirvent.experimentalarchitecturemarvel.logic.comics.MarvelComic;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result.Data;

public interface ComicsServerRepository {
    Data<MarvelComic> getComicById(long comicId) throws RepositoryException;
}
