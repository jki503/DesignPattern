package creational.factory.unit;

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
