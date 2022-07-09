package org.adex.servers.handlers.impl;

import org.adex.servers.handlers.Handler;

import java.io.IOException;

public class PrinterHanlder<T> extends DecoratedHandler<T> {

    public PrinterHanlder(Handler<T> handler) {
        super(handler);
    }

    @Override
    public void handle(T t) throws IOException {
        try {
            System.out.println("Connected " + t);
            super.handle(t);
        } finally {
            System.out.println("Disconnected " + t);
        }
    }
}
