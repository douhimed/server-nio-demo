package org.adex.handlers.impl;


import java.io.IOException;

public interface Handler <T>{
    void handle(T t) throws IOException;
}
