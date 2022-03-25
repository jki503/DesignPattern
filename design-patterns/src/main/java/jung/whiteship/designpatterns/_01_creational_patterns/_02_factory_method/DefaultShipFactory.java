package jung.whiteship.designpatterns._01_creational_patterns._02_factory_method;

public abstract class DefaultShipFactory implements ShipFactory{

    @Override
    public void sendMailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었습니다.");
    }

}
