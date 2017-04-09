package com.offer.day01;

public class SingleTonClass2 {
    private static SingleTonClass2  instance = null;
    private SingleTonClass2(){}
    public synchronized static SingleTonClass2 getInstance(){
        if(instance==null){
            instance = new SingleTonClass2();
        }
        return instance;
    }
    
}
