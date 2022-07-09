package org.adex.servers;

import org.adex.handlers.impl.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorServiceBlockingServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9090);
        final Handler<Socket> handler = new ExecutorServiceHandler<>(new PrinterHanlder<>(new TransHandler()));

        while (true) {
            final Socket socket = serverSocket.accept();
            handler.handle(socket);
        }
    }

}
