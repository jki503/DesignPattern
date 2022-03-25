package jung.whiteship.designpatterns._01_creational_patterns._02_factory_method;

public class Client {
    public static void main(String[] args) {

        ShipFactory shipFactory = FactoryCreator.getInstance(FactoryType.BLACK);
        print(shipFactory.orderShip("BlackShipByjung","jkixxx@hufs.ac.kr"));

    }

    private static void print(Ship ship){
        System.out.println(ship);
    }
}
