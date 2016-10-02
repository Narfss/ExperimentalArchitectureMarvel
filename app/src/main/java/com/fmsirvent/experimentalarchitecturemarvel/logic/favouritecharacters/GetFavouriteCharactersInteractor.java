package com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.PostExecutionThread;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;

import java.util.List;

import javax.inject.Inject;

public class GetFavouriteCharactersInteractor implements Runnable, GetFavouriteCharactersUseCase {
    private final FavouriteCharactersLocalRepository favouriteCharactersLocalRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private Callback callback;

    @Inject
    public GetFavouriteCharactersInteractor(FavouriteCharactersLocalRepository favouriteCharactersLocalRepository,
                                            ThreadExecutor threadExecutor,
                                            PostExecutionThread postExecutionThread) {
        this.favouriteCharactersLocalRepository = favouriteCharactersLocalRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public void execute(Callback callback) {
        this.callback = callback;
        threadExecutor.execute(this);
    }

    @Override
    public void run() {
        try {
            List<MarvelCharacter> characters =
                    favouriteCharactersLocalRepository.getFavouriteCharacters();
            notifySuccess(characters);
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
