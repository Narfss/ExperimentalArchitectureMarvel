package com.fmsirvent.experimentalarchitecturemarvel.logic.characters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.PostExecutionThread;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharactersServerRepository;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result.Data;

import java.util.List;

import javax.inject.Inject;

public class GetCharactersInteractor implements Runnable, GetCharactersUseCase {
    private final CharactersServerRepository charactersServerRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private int offset;
    private Callback callback;

    @Inject
    public GetCharactersInteractor(CharactersServerRepository charactersServerRepository,
                                   ThreadExecutor threadExecutor,
                                   PostExecutionThread postExecutionThread) {
        this.charactersServerRepository = charactersServerRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public void execute(int offset, Callback callback) {
        this.offset = offset;
        this.callback = callback;
        threadExecutor.execute(this);
    }

    @Override
    public void run() {
        try {
            Data<MarvelCharacter> charactersData = charactersServerRepository.getCharacters(offset);
            notifySuccess(charactersData.getResult());
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    private void notifySuccess(final List<MarvelCharacter> characters) {
        postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onData(characters);
            }
        });
    }
}
