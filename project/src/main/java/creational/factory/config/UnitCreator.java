package creational.factory.config;

import creational.factory.type.UnitType;
import creational.factory.unit.FlyUnit;
import creational.factory.unit.LandUnit;
import creational.factory.unit.SwimUnit;
import creational.factory.unit.Unit;

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
