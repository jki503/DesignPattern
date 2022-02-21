package proejct.designpattern.singletonpattern;

public class SingletonLazyHolder {

    private SingletonLazyHolder(){}

//    1. 내부 클래스 로딩 시점에서 객체 생성
    private static class InnerClass{
        private static final SingletonLazyHolder instance = new SingletonLazyHolder();
    }

//    2. 내부 클래스에서 인스턴스 가져오기
    public static SingletonLazyHolder getInstance(){
        return InnerClass.instance;
    }

}
