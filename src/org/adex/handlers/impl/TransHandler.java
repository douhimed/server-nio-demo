package org.adex.handlers.impl;

import org.adex.utilities.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TransHandler implements Handler<Socket> {

    @Override
    public void handle(Socket socket) throws IOException {
        try (socket; // Java 9 mocking for closing
             final InputStream inputStream = socket.getInputStream();
             final OutputStream outputStream = socket.getOutputStream()) {
            //inputStream.transferTo(outputStream); // jdk +9
            int data;
            while ((data = inputStream.read()) != -1) {
                if(data == '%') throw new IOException("Ooopsie"); // simulation for Thread.UncaughtExceptionHandler in ExecutorServiceHandler
                outputStream.write(Util.trans(data));
            }
        }
    }
}
