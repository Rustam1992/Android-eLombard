package com.elombard.interfaces;

import com.elombard.model.results.Error;

public interface Single<T> {
    void send(T t);
    void success();
    void failure(Error e);

}
