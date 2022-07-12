package com.finco.framework.observer;

import com.finco.framework.observer.Observer;

import java.util.List;

public interface Subject {

    List<Observer> getObserver();

    default void addObserver(Observer observer){
        getObserver().add(observer);
    }

    default void notifyObserver(String data, String type){
        for (Observer observer:getObserver()){
            observer.update(data, type);
        }
    }

    default void removeObserver(Observer observer){
        this.getObserver().remove(observer);
    }
}
