package com.fmsirvent.experimentalarchitecturemarvel.logic.comic;

import com.fmsirvent.experimentalarchitecturemarvel.logic.PostExecutionThread;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelComic;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.comics.ComicsServerRepository;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result.Data;

import java.util.List;

import javax.inject.Inject;

public class GetComicByIdInteractor implements Runnable, GetComicByIdUseCase {
    private final ComicsServerRepository comicsServerRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private long id;
    private Callback callback;

    @Inject
    public GetComicByIdInteractor(ComicsServerRepository comicsServerRepository,
                                  ThreadExecutor threadExecutor,
                                  PostExecutionThread postExecutionThread) {
        this.comicsServerRepository = comicsServerRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public void execute(long id,
                        Callback callback) {
        this.id = id;
        this.callback = callback;
        threadExecutor.execute(this);
    }

    @Override
    public void run() {
        try {
            Data<MarvelComic> charactersComicsData = comicsServerRepository.getComicById(id);
            List<MarvelComic> result = charactersComicsData.getResult();
            if (result.size() == 1) {
                notifySuccess(result.get(0));
            }
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    private void notifySuccess(final MarvelComic comic) {
        postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onData(comic);
            }
        });
    }
}
