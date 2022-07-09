package org.adex.servers;

import org.adex.handlers.impl.Handler;
import org.adex.handlers.impl.PrinterHanlder;
import org.adex.handlers.impl.TransHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreaderBlockingServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9090);
        final Handler<Socket> printerHanlder = new PrinterHanlder<>(new TransHandler());
        while (true) {
            final Socket socket = serverSocket.accept();
            printerHanlder.handle(socket);
        }
    }


}
