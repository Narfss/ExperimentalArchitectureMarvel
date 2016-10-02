package com.fmsirvent.experimentalarchitecturemarvel.logic.comics;

import com.fmsirvent.experimentalarchitecturemarvel.BaseTest;
import com.fmsirvent.experimentalarchitecturemarvel.logic.PostExecutionThread;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelComic;
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

public class GetCharacterComicsInteractorTest extends BaseTest {
    private static final long COMIC_ID = 1;
    private static final int OFFSET = 0;
    @Mock CharactersServerRepository repository;
    @Mock ThreadExecutor threadExecutor;
    @Mock PostExecutionThread postExecutionThread;
    @Mock GetCharacterComicsInteractor.Callback callback;
    @Mock Data<MarvelComic> comicData;
    @Mock List<MarvelComic> comics;
    @Mock MarvelComic comic;
    private GetCharacterComicsInteractor interactor;

    @Override
    public void setup() {
        interactor = new GetCharacterComicsInteractor(repository,
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
    public void shouldGetCharacterComics() throws RepositoryException {
        doReturn(comicData).when(repository).getCharacterComics(COMIC_ID, OFFSET);
        doReturn(comics).when(comicData).getResult();

        interactor.execute(COMIC_ID, OFFSET, callback);

        verify(repository).getCharacterComics(eq(COMIC_ID), eq(OFFSET));
        verify(callback).onData(eq(comics));
        verifyNoMoreInteractions(callback);
        verifyNoMoreInteractions(repository);
    }
}