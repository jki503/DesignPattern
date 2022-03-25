package jung.whiteship.designpatterns._01_creational_patterns._02_factory_method;

public class WhiteShipFactory extends DefaultShipFactory{

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
