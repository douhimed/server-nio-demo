package org.adex.handlers;


import java.io.IOException;

public interface Handler <T>{
    void handle(T t) throws IOException;
}
