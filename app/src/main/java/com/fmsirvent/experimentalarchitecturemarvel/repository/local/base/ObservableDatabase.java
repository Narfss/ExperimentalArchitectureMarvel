package com.fmsirvent.experimentalarchitecturemarvel.repository.local.base;

import java.util.HashMap;
import java.util.Map;

public class ObservableDatabase implements ObservableInterface {
    private Integer observableId = 0;
    private Map<Integer, ObservableInterface.Observer> observers;

    public ObservableDatabase() {
        observers = new HashMap<>();
    }

    protected void notifyChange() {
        for (Observer observer : observers.values()) {
            observer.onChange();
        }
    }

    @Override
    public int subscribe(Observer observer) {
        observableId++;
        this.observers.put(observableId, observer);
        observer.onSubscribe(observableId);
        return observableId;
    }

    @Override
    public void unsubscribe(int subscriptionId) {
        observers.remove(subscriptionId);
    }
}
