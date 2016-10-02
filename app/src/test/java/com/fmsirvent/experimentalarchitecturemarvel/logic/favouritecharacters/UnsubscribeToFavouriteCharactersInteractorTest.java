package com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters;

import com.fmsirvent.experimentalarchitecturemarvel.BaseTest;
import com.fmsirvent.experimentalarchitecturemarvel.logic.PostExecutionThread;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class UnsubscribeToFavouriteCharactersInteractorTest extends BaseTest {
    private static final int SUBSCRIBE_ID = 1;
    @Mock FavouriteCharactersLocalRepository repository;
    @Mock ThreadExecutor threadExecutor;
    private UnsubscribeToFavouriteCharactersInteractor interactor;

    @Override
    public void setup() {
        interactor = new UnsubscribeToFavouriteCharactersInteractor(repository, threadExecutor);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                interactor.run();
                return null;
            }
        }).when(threadExecutor).execute(eq(interactor));
    }

    @Test
    public void shouldUnsubscribeToFavourites() throws RepositoryException {
        interactor.execute(SUBSCRIBE_ID);

        verify(repository).unsubscribe(eq(SUBSCRIBE_ID));
        verifyNoMoreInteractions(repository);
    }

}