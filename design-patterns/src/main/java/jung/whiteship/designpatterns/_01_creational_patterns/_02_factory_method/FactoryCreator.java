package jung.whiteship.designpatterns._01_creational_patterns._02_factory_method;

public interface FactoryCreator {

    static ShipFactory getInstance(FactoryType type){
        switch (type){
            case WHITE:
                return new WhiteShipFactory();
            case BLACK:
                return new BlackShipFactory();
            default:
                throw new IllegalArgumentException("그런 공장은 없다!");
        }

    }
}
