package org.adex.utils;

import java.io.IOException;
import java.net.Socket;

public class NustyChamp {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket[] sockets = new Socket[30000];
        for (int i = 0; i < sockets.length; i++) {
            sockets[i] = new Socket("localhost", 9090);
        }
        Thread.sleep(100_000);
    }
    
}
