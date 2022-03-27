package jung.whiteship.designpatterns._01_creational_patterns._01_singleton;

// Eager initialization
public class GameSetting1 {

    private static final GameSetting1 INSTANCE = new GameSetting1();

    private GameSetting1() {}

}
