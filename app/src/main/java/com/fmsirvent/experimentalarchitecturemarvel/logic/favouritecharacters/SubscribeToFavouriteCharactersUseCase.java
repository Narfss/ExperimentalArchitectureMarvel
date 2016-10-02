package com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters;

public interface SubscribeToFavouriteCharactersUseCase {
    void execute(Callback callback);

    interface Callback {
        void onSubscribe(int subscriptionId);
        void onChange();
    }
}
