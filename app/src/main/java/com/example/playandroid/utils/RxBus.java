package com.example.playandroid.utils;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/13 0013
 * Time: 9:35
 * Describe: ${as}
 */
public class RxBus {
    private static RxBus ourInstance = new RxBus();
    private final Subject mBus;

    public static RxBus getInstance() {
        return ourInstance;
    }

    private RxBus() {
        mBus = PublishSubject.create().toSerialized();
    }

    public void Post(Object object){
        mBus.onNext(object);
    }

    public <T> Observable<T> getObservable(Class<T> eventType){
        return mBus.ofType(eventType);
    }

    public boolean isHasObserver(){
        return mBus.hasObservers();
    }

    public void reset(){
        ourInstance = null;
    }
}
