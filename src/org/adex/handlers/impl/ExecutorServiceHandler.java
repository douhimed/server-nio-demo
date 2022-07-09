package org.adex.handlers.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ExecutorServiceHandler<T> extends DecoratedHandler<T> {

    private final ExecutorService pool;
    private final Thread.UncaughtExceptionHandler exceptionHandler;

    public ExecutorServiceHandler(Handler<T> other, ExecutorService pool, Thread.UncaughtExceptionHandler exceptionHandler) {
        super(other);
        this.pool = pool;
        this.exceptionHandler = exceptionHandler;
    }

    public ExecutorServiceHandler(Handler<T> other, ExecutorService pool) {
        this(other, pool, (thread, exception) -> System.err.println("Uncaught " + thread + ", Exception :" + exception));
    }

    public ExecutorServiceHandler(Handler<T> other) {
        this(other,
                Executors.newFixedThreadPool(10)
                , (thread, exception) -> System.err.println("Uncaught " + thread + ", Exception :" + exception));
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
