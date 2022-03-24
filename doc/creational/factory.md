# Factory Method

</br>

> 구현체를 생성하기 위한 인터페이스를 정의 하고, 어떤 클래스의 인스턴스를 생성할 것인지 처리해주는 디자인 패턴

</br>

|                       UML                       |
| :---------------------------------------------: |
| ![factory method img](./res/factory_method.png) |

</br>

- 장점

> 클래스의 `생성과 비즈니스 로직을 분리`하여 클래스간의 직접적인 의존도를 낮출 수 있다는 장점.  
> 하나의 클래스가 `직접 객체를 생성하는 것을 방지`하고  
> `생성 관련 로직을 담당하는 클래스에게 위임` 하는 것.

</br>

- 예제 코드 및 패키지 구조

</br>

- factory
  - config
    - UnitCreator.java
  - type
    - UnitType.java
  - unit
    - Unit.java
    - LandUnit.java
    - SwimUnit.java
    - FlyUnit.java
  - Main.java (팩토리 메서드 적용한 클라이언트)
  - Main2.java (그냥 생성 로직 다 처리하는 클라이언트)

</br>

</br>

```java

public interface Unit {

    void move();
    void attack();
}

public class LandUnit implements Unit{
    @Override
    public void move() {
        System.out.println("땅에서 뜁니다.");
    }

    @Override
    public void attack() {
        System.out.println("지상에서 공격합니다.");
    }
}

public class FlyUnit implements Unit{

    @Override
    public void move() {
        System.out.println("하늘을 날아요!");
    }

    @Override
    public void attack() {
        System.out.println("하늘에서 공격해요!");
    }
}

public class SwimUnit implements Unit{

    @Override
    public void move() {
        System.out.println("수중에서 움직입니다.");
    }

    @Override
    public void attack() {
        System.out.println("수중에서 공격합니다.");
    }
}
```

- 하나의 클래스가 생성과 비즈니스 책임을 갖는 경우.

```java
public class Main2 {

    public static void main(String[] args) {

        Unit land = new LandUnit();
        Unit swim = new LandUnit();
        Unit fly = new LandUnit();

        land.attack();
        swim.attack();
        fly.attack();
    }

}

```

> 위의 경우가 생성의 책임 유닛의 액션 역할의 책임을 보여주는 예시.  
> 모든 구조들이 그렇듯 역할이 중첩되면 유지보수 할 때 side effect가 크다..

</br>
</br>
</br>

```java

public class UnitCreator {

    public static Unit getUnit(UnitType type){

        switch (type){
            case LandUnit: return new LandUnit();
            case FlyUnit: return new FlyUnit();
            case SwimUnit: return new SwimUnit();
            default :
                throw new IllegalArgumentException("그런 유닛은 없어요!");
        }
    }

}

public enum UnitType {
    LandUnit, FlyUnit, SwimUnit
}

public class Main {

    public static void main(String[] args) {

        Unit tank = UnitCreator.getUnit(UnitType.LandUnit);
        Unit submarine = UnitCreator.getUnit(UnitType.SwimUnit);
        Unit fighter = UnitCreator.getUnit(UnitType.FlyUnit);

        tank.move();
        tank.attack();

        System.out.println();

        submarine.move();
        submarine.attack();

        System.out.println();

        fighter.move();
        fighter.attack();

    }
}

```

- `UnitCreator` : 사용자로부터 객체 생성의 책임을 위임 받음.
- `UnitType` : 각 Unit의 enum type을 통해 인스턴스 생성.

## 정적 팩토리 메서드

</br>

```java

public class UnitCreator {

    public static Unit getUnit(UnitType type){

        switch (type){
            case LandUnit: return new LandUnit();
            case FlyUnit: return new FlyUnit();
            case SwimUnit: return new SwimUnit();
            default :
                throw new IllegalArgumentException("그런 유닛은 없어요!");
        }
    }

}

```

</br>

- 다시 찾아보게된 이유

</br>

> getUnit 함수를 보면 정적 메소드로 정의 한 것을 볼 수 있다.  
> 사실 개인적으로 정적 메소드로 정의 하지 않으면  
> `UnitCreator를 위의 Main함수에서 (new)생성`해서  
> 사용하기 불편하다는 생각으로 일단 만들었는데 어떤 장점이 있는지 찾아보았다.

</br>

- 메서드의 이름이 주는 의도

</br>

```java

public class Creator{


  public static Unit getUnit();
  public static Unit getWeapon();

}

```

</br>

> 위의 예제에서 확장하여 각 유닛에 무기를 만들어주려고 할 때,
> 정적 메소드를 정의 할 경우 메소드 명칭만 보고도  
> `어떤 인스턴스를 반환해주는 것인지에 대해 의도`가 보다 더 잘 전달된다.

</br>

- 객체 생성을 캡슐화 할 수 있다는 장점

> 생성자를 정적 메서드 안으로 숨기면서 내부 상태를 외부에 드러낼 필요가 없다.

</br>

- 정적 팩토리 메서드 네이밍 컨벤션

</br>

|                           |                                                     |
| :-----------------------: | :-------------------------------------------------: |
|           from            |        하나의 매개 변수를 받아서 객체를 생성        |
|            of             |        여러개의 매개 변수를 받아서 객체 생성        |
| getInstance 혹은 instance | 인스턴스를 생성. 이전에 반환했던 것과 같을 수 있다. |
|         get(type)         |             다른 타입의 인스턴스를 생성             |
|      new(otherType)       |          다른 타임의 새로운 인스턴스 생성           |
