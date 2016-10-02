package com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters;

import com.fmsirvent.experimentalarchitecturemarvel.BaseTest;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelImage;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharacterEntity;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class AddFavouriteCharacterInteractorTest extends BaseTest {
    @Mock FavouriteCharactersLocalRepository repository;
    @Mock ThreadExecutor threadExecutor;
    @Mock MarvelCharacter character;
    @Mock MarvelImage image;
    @Mock FavouriteCharacterEntity entity;
    private AddFavouriteCharacterInteractor interactor;

    @Override
    public void setup() {
        interactor = new AddFavouriteCharacterInteractor(repository, threadExecutor);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                interactor.run();
                return null;
            }
        }).when(threadExecutor).execute(eq(interactor));
    }

    @Test
    public void shouldAddOrUpdateFavourite() throws RepositoryException {
        doReturn(image).when(character).getThumbnail();

        interactor.execute(character);

        verify(repository).addOrUpdateFavouriteCharacters(any(FavouriteCharacterEntity.class));
        verifyNoMoreInteractions(repository);
    }
}