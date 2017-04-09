package com.offer.day01;

import java.util.Scanner;
//eager模式的singleton
public class SingleTonClass {
    private static SingleTonClass syso = new SingleTonClass();
    private SingleTonClass(){};
    public static SingleTonClass getInstance(){
        return syso;
    }
}
