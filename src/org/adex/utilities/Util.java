package org.adex.utils;

public class Util {
    public static int trans(int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }
}