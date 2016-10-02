package com.fmsirvent.experimentalarchitecturemarvel.logic.comics;

import com.fmsirvent.experimentalarchitecturemarvel.logic.PostExecutionThread;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelComic;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharactersServerRepository;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result.Data;

import java.util.List;

import javax.inject.Inject;

public class GetCharacterComicsInteractor implements Runnable, GetCharacterComicsUseCase {
    private final CharactersServerRepository charactersServerRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private long id;
    private int offset;
    private Callback callback;

    @Inject
    public GetCharacterComicsInteractor(CharactersServerRepository charactersServerRepository,
                                        ThreadExecutor threadExecutor,
                                        PostExecutionThread postExecutionThread) {
        this.charactersServerRepository = charactersServerRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public void execute(long id,
                        int offset,
                        Callback callback) {
        this.id = id;
        this.offset = offset;
        this.callback = callback;
        threadExecutor.execute(this);
    }

    @Override
    public void run() {
        try {
            Data<MarvelComic> charactersComicsData = charactersServerRepository.getCharacterComics(id, offset);
            notifySuccess(charactersComicsData.getResult());
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    private void notifySuccess(final List<MarvelComic> comics) {
        postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onData(comics);
            }
        });
    }
}
