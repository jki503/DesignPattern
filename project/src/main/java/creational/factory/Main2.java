package creational.factory;

import creational.factory.unit.LandUnit;
import creational.factory.unit.Unit;

public class Main2 {

    public static void main(String[] args) {

        // 하나의 클래스가 생성과 비즈니스 책임을 갖는 경우.
        Unit land = new LandUnit();
        Unit swim = new LandUnit();
        Unit fly = new LandUnit();

        land.attack();
        swim.attack();
        fly.attack();
    }

}
