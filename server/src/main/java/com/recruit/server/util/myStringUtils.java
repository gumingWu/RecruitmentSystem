package com.recruit.server.util;

public class myStringUtils {
    public static String printArray(int[] array){
        StringBuilder res = new StringBuilder();
        for (int i: array){
            res.append(i).append("\t");
        }
        return res.toString();
    }
}
