# Singleton

## **(싱글톤 패턴)Singleton pattern**

---

</br>

> 단 한 번 객체를 생성하여 `인스턴스`를 메모리의 할당한 후  
> 객체 생성 없이 인스턴스를 참조하여 사용하는 디자인 패턴

</br>

### **싱글톤 패턴 장점**

</br>

- 메모리 할당 되는 인스턴스가 한 개임으로 메모리 낭비가 적다.

- 설정값이 변경될 위험을 사전에 예방한다.

</br>

### **싱글톤 패턴 고려 해야할 점**

</br>

- 싱글톤은 stateless 해야한다.(not stateful)

> - **짧은 설명**
>
> - `stateless`: 이전 트랜잭션에 영향을 받으면 안됨. 즉 내부 객체의 설정 값이 변경 되지 않아야 한다.
>
> - `stateful`: 이전 트랜잭션의 상황에 따라 요청의 영향을 받는다.
>
> - ex) 결제 서비스에서 고객의 주문 요청을 받은 후 특정 상품의 가격이 변경된다면? -> 굉장히 큰 문제.

- 멀티쓰레드 환경에서의 concurrency 문제를 고려해야한다.
- Thread-safe 해야한다.

</br>

> - **짧은 설명!**
>
> `Thread-safe` : 특정 객체가 여러 쓰레드로부터 동시 접근이 발생하여도 프로그램의 실행에 문제가 없는 것.

</br>

### **싱글톤 패턴 구현**

</br>

- `Eager Initialization (static binding)`

</br>

```java
public class SingletonEagerInitialization {
    private static final SingletonEagerInitialization instance = new SingletonEagerInitialization();

    private SingletonEagerInitialization(){}

    public static SingletonEagerInitialization getInstance(){
        return instance;
    }
}
```

</br>

> 클래스 로더가 초기화 할 때  
> `static binding` (정적바인딩)으로
> 인스턴스를 컴파일 시점에서 결정하여 사용하는 것.
>
> 로딩 될 때 객체가 생성 됨으로 Thread-safe

- `Lazy Initialization with Synchronized (dynamic binding)`

</br>

```java
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
```

</br>

> - 메서드에 synchronized로 동기화 블럭 지정 -> Thread-safe
>
> - 객체가 생성 된 여부와 상관없이 getInstance 메서드에서 동기화 블럭을 거치게 되어 있다. -> 성능 문제
>
> - 안 좋은 방법.

- `Lazy Initialization. Double Checking Locking (dynamic binding)`

```java
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
```

</br>

> - 위의 getInstance에 동기화 블럭 방식의 단점을 개선.  
>   `동시화 블록을 객체가 없을때만 적용.`
>
> - volatile 키워드를 사용하여 멀티스레딩을 사용함에도 singleton 인스턴스로 초기화 되는 과정 수행.
>
> - volatile에 대해

- `Lazy Initializtion. LazyHolder (dynamic binding)`

</br>

```java
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

```

</br>

> - dynamic binding에 의한 메모리 이점
>
> - SingletonLazyHolder를 호출 해도 InnerClass의 변수가 없음으로 메모리 이점.

- `Lazy Initialization. Enum`

</br>

```java
public enum SingletonEnum{
  instance;
}
```

</br>

> - Reflection에 의한 추가 인스턴스 생성X
> - Enum 인스턴스 생성은 Thread-safe이지만
> - Enum내의 메서드가 Thread-safe인지는 개발자의 책임
>
> - 이 Enum 방식은 상속 X,
> - Context 의존성이 있는 환경(Android)에서
>   Context 의존성이 끼어들 가능성이 있음.

</br>

### **싱글톤 패턴 요약**

> - Singleton 구현시
>   - Thread-safe인지?
>   - stateless인지?
>   - Concurrency를 고려 했는지?
>   - 스프링이 아닌 순수 자바로 구현 할 때 의존성이  
>     맞물리는 문제 주의(private constructor)

</br>
</br>
</br>
