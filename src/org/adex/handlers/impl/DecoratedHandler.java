package org.adex.handlers.impl;

import java.io.IOException;

public abstract class DecoratedHandler<T> implements Handler<T> {

    private final Handler<T> other;

    public DecoratedHandler(Handler<T> other) {
        this.other = other;
    }

    @Override
    public void handle(T t) throws IOException {
        other.handle(t);
    }
}
