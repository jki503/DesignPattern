package com.designpattern.excode.singleton;

public class SingletonEagerInitialization {
    private static final SingletonEagerInitialization instance = new SingletonEagerInitialization();

    private SingletonEagerInitialization(){}

    public static SingletonEagerInitialization getInstance(){
        return instance;
    }
}
