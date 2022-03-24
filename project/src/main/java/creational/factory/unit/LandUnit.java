package creational.factory.unit;

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
