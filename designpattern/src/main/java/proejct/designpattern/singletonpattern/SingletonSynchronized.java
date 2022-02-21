package proejct.designpattern.singletonpattern;

public class SingletonSynchronized{
    private static SingletonSynchronized instance;

    private SingletonSynchronized(){}

    // synchronized때문에 객체가 생성되었음에도 lock이 걸리는 상황.
    private static synchronized SingletonSynchronized getInstance(){
        if(instance == null){
            instance = new SingletonSynchronized();
        }
        return instance;
    }
}

