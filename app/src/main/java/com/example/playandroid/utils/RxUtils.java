package com.example.playandroid.utils;

import com.example.playandroid.model.BaseResponse;

import rx.Observable;
import rx.Single;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/10 0010
 * Time: 19:40
 * Describe: ${as}
 */
//public class RxUtils<T> implements Observable.Transformer<T,T> {
//    @Override
//    public Observable<T> call(Observable<T> tObservable) {
//        return tObservable.flatMap(new Func1<T, Observable<T>>() {
//            @Override
//            public Observable<T> call(final T t) {
//                return Observable.create(new Observable.OnSubscribe<T>() {
//                    @Override
//                    public void call(Subscriber<? super T> subscriber) {
//                        subscriber.onNext(t);
//                    }
//                });
//            }
//        });
//    }
//}
public class RxUtils{

    public static <T> Observable.Transformer<BaseResponse<T>,T> handleResult() {

        return new Observable.Transformer<BaseResponse<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseResponse<T>> baseResponseObservable) {
                return baseResponseObservable.flatMap(new Func1<BaseResponse<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(final BaseResponse<T> tBaseResponse) {
                        return Observable.create(new Observable.OnSubscribe<T>() {
                            @Override
                            public void call(Subscriber<? super T> subscriber) {
                                subscriber.onNext(tBaseResponse.getData());
                            }
                        });
                    }
                });
            }
        };
    }
}
