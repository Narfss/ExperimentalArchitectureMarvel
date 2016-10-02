package com.fmsirvent.experimentalarchitecturemarvel.repository.local.base;

public interface ObservableInterface {
    int subscribe(Observer subscriber);
    void unsubscribe(int subscriptionId);

    interface Observer {
        void onChange();
        void onSubscribe(int subscribeId);
    }
}
