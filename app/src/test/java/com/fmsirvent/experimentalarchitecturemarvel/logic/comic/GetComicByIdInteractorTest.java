package com.fmsirvent.experimentalarchitecturemarvel.logic.comic;

import com.fmsirvent.experimentalarchitecturemarvel.BaseTest;
import com.fmsirvent.experimentalarchitecturemarvel.logic.PostExecutionThread;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelComic;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.comics.ComicsServerRepository;
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

public class GetComicByIdInteractorTest extends BaseTest {
    private static final long COMIC_ID = 1;
    @Mock ComicsServerRepository repository;
    @Mock ThreadExecutor threadExecutor;
    @Mock PostExecutionThread postExecutionThread;
    @Mock GetComicByIdInteractor.Callback callback;
    @Mock Data<MarvelComic> comicData;
    @Mock List<MarvelComic> comics;
    @Mock MarvelComic comic;
    private GetComicByIdInteractor interactor;

    @Override
    public void setup() {
        interactor = new GetComicByIdInteractor(repository,
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
    public void shouldGetComicById() throws RepositoryException {
        doReturn(comicData).when(repository).getComicById(COMIC_ID);
        doReturn(comics).when(comicData).getResult();
        doReturn(true).when(comicData).isUniqueResult();
        doReturn(comic).when(comicData).getFirstResult();

        interactor.execute(COMIC_ID, callback);

        verify(repository).getComicById(eq(COMIC_ID));
        verify(callback).onData(eq(comic));
        verifyNoMoreInteractions(callback);
        verifyNoMoreInteractions(repository);
    }
}