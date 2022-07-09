package org.adex.handlers.impl;

import java.io.IOException;
import java.io.UncheckedIOException;

public class UncheckedIoExceptionConverterHandler<T> extends DecoratedHandler<T> {

    public UncheckedIoExceptionConverterHandler(Handler<T> other) {
        super(other);
    }

    @Override
    public void handle(T t) {
        try {
            super.handle(t);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
