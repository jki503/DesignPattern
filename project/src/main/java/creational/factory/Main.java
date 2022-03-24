package creational.factory;

import creational.factory.config.UnitCreator;
import creational.factory.type.UnitType;
import creational.factory.unit.Unit;

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
