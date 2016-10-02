package com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.PostExecutionThread;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;

import javax.inject.Inject;


public class SubscribeToFavouriteCharactersUseCase implements Runnable {
    private final FavouriteCharactersLocalRepository favouriteCharactersLocalRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private Callback callback;
    private FavouriteCharactersLocalRepository.Observer
            observer = new FavouriteCharactersLocalRepository.Observer() {
                            @Override
                            public void onChange() {
                                callback.onChange();
                            }

                            @Override
                            public void onSubscribe(int subscribeId) {
                                callback.onSubscribe(subscribeId);
                            }
                        };

    @Inject
    public SubscribeToFavouriteCharactersUseCase(FavouriteCharactersLocalRepository favouriteCharactersLocalRepository,
                                                 ThreadExecutor threadExecutor,
                                                 PostExecutionThread postExecutionThread) {
        this.favouriteCharactersLocalRepository = favouriteCharactersLocalRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    public void execute(Callback callback) {
        this.callback = callback;
        threadExecutor.execute(this);
    }

    @Override
    public void run() {
        int subscribeId = favouriteCharactersLocalRepository.subscribe(observer);
        notifySubscription(subscribeId);
        callback.onSubscribe(subscribeId);
    }

    private void notifySubscription(final int subscriptionId) {
        postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onSubscribe(subscriptionId);
            }
        });
    }

    public interface Callback {
        void onSubscribe(int subscriptionId);
        void onChange();
    }
}
