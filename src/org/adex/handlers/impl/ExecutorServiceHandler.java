package org.adex.handlers.impl;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorServiceHandler<T> extends DecoratedHandler<T> {

    private final ExecutorService pool;
    private final Thread.UncaughtExceptionHandler exceptionHandler;

    public ExecutorServiceHandler(Handler<T> other, ExecutorService pool, Thread.UncaughtExceptionHandler exceptionHandler) {
        super(other);
        this.pool = pool;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void handle(T t) {

        pool.submit(new FutureTask<>(() -> {
            super.handle(t);
            return null;
        }) {
            @Override
            protected void setException(Throwable e) {
                exceptionHandler.uncaughtException(Thread.currentThread(), e);
            }
        });
    }
}
