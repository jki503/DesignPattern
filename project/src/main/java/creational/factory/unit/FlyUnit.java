package creational.factory.unit;

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
