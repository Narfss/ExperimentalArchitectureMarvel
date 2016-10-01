package com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.CharacterEntityMapper;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;

import javax.inject.Inject;

public class AddFavouriteCharacterUseCase implements Runnable {
    private final FavouriteCharactersLocalRepository favouriteCharactersLocalRepository;
    private final ThreadExecutor threadExecutor;
    private MarvelCharacter character;

    @Inject
    public AddFavouriteCharacterUseCase(FavouriteCharactersLocalRepository favouriteCharactersLocalRepository,
                                        ThreadExecutor threadExecutor) {
        this.favouriteCharactersLocalRepository = favouriteCharactersLocalRepository;
        this.threadExecutor = threadExecutor;
    }

    public void execute(MarvelCharacter character) {
        this.character = character;
        threadExecutor.execute(this);
    }

    @Override
    public void run() {
        try {
            favouriteCharactersLocalRepository.addOrUpdateFavouriteCharacters(CharacterEntityMapper.map(character));
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }
}
