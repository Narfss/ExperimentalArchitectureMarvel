package com.fmsirvent.experimentalarchitecturemarvel.logic.characters;

import com.fmsirvent.experimentalarchitecturemarvel.BaseTest;
import com.fmsirvent.experimentalarchitecturemarvel.logic.PostExecutionThread;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharactersServerRepository;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result.Data;

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

public class GetCharactersInteractorTest extends BaseTest {
    private static final int OFFSET = 0;
    @Mock CharactersServerRepository repository;
    @Mock ThreadExecutor threadExecutor;
    @Mock PostExecutionThread postExecutionThread;
    @Mock GetCharactersInteractor.Callback callback;
    @Mock Data<MarvelCharacter> charactersData;
    @Mock List<MarvelCharacter> characters;
    @Mock MarvelCharacter character;
    private GetCharactersInteractor interactor;

    @Override
    public void setup() {
        interactor = new GetCharactersInteractor(repository,
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
    public void shouldGetCharacters() throws RepositoryException {
        doReturn(charactersData).when(repository).getCharacters(OFFSET);
        doReturn(characters).when(charactersData).getResult();

        interactor.execute(OFFSET, callback);

        verify(repository).getCharacters(eq(OFFSET));
        verify(callback).onData(eq(characters));
        verifyNoMoreInteractions(callback);
        verifyNoMoreInteractions(repository);
    }
}