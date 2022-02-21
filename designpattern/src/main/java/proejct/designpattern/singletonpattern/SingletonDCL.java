package com.designpattern.excode.singleton;

public class SingletonDCL {
    //volatile 추가
    private volatile static SingletonDCL instance;

    private SingletonDCL(){}

    private static SingletonDCL getInstance(){

        if(instance == null){
//          synchrnoized를 객체가 없는 경우에만 적용.
            synchronized (SingletonDCL.class){
                if(instance == null)
                    instance = new SingletonDCL();
            }
        }
        return instance;
    }
}
