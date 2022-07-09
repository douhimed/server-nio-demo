package org.adex.handlers.impl;

public class ThreadedHandler<T> extends UncheckedIoExceptionConverterHandler<T> {

    public ThreadedHandler(Handler<T> other) {
        super(other);
    }

    @Override
    public void handle(T t) {
        new Thread(() -> super.handle(t)).start();
    }
}
