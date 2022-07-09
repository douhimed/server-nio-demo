package org.adex.servers.handlers.impl;

import org.adex.servers.handlers.Handler;

import java.io.IOException;

public class PrinterHanlder<T> implements Handler<T> {

    private final Handler<T> other;

    public PrinterHanlder(Handler<T> handler) {
        this.other = handler;
    }

    @Override
    public void handle(T t) throws IOException {
        try {
            System.out.println("Connected " + t);
            other.handle(t);
        } finally {
            System.out.println("Disconnected " + t);
        }
    }
}
