package org.adex.servers.handlers.impl;

import org.adex.servers.handlers.Handler;

import java.io.IOException;
import java.io.UncheckedIOException;

public class UncheckedIoExceptionConverterHandler<T> implements Handler<T> {

    private final Handler<T> other;

    public UncheckedIoExceptionConverterHandler(Handler<T> other) {
        this.other = other;
    }

    @Override
    public void handle(T t) {
        try {
            other.handle(t);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
