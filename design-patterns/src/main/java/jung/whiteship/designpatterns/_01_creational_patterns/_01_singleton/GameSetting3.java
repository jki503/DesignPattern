package jung.whiteship.designpatterns._01_creational_patterns._01_singleton;

// Synchronized
public class GameSetting3 {

    private static GameSetting3 instance;

    private GameSetting3() {}

    public static synchronized GameSetting3 getInstance(){
        if(instance == null)
            instance = new GameSetting3();
        return instance;
    }
}
