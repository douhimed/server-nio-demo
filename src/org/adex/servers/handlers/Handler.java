package org.adex.servers.handlers;

import java.io.IOException;

public interface Handler <T>{
    void handle(T t) throws IOException;
}
