package com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters;

import com.fmsirvent.experimentalarchitecturemarvel.BaseTest;
import com.fmsirvent.experimentalarchitecturemarvel.logic.PostExecutionThread;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class GetFavouriteCharactersInteractorTest extends BaseTest {
    @Mock FavouriteCharactersLocalRepository repository;
    @Mock ThreadExecutor threadExecutor;
    @Mock PostExecutionThread postExecutionThread;
    @Mock GetFavouriteCharactersInteractor.Callback callback;
    @Mock List<MarvelCharacter> favouriteCharacters;
    private GetFavouriteCharactersInteractor interactor;

    @Override
    public void setup() {
        interactor = new GetFavouriteCharactersInteractor(repository,
                threadExecutor,
                postExecutionThread);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                interactor.run();
                return null;
            }
        }).when(threadExecutor).execute(eq(interactor));
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((Runnable) invocation.getArguments()[0]).run();
                return null;
            }
        }).when(postExecutionThread).post(any(Runnable.class));
    }

    @Test
    public void shouldGetFavourites() throws RepositoryException {
        doReturn(favouriteCharacters).when(repository).getFavouriteCharacters();

        interactor.execute(callback);

        verify(repository).getFavouriteCharacters();
        verify(callback).onData(eq(favouriteCharacters));
        verifyNoMoreInteractions(callback);
        verifyNoMoreInteractions(repository);
    }
}