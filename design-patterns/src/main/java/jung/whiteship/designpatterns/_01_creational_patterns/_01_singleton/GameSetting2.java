package jung.whiteship.designpatterns._01_creational_patterns._01_singleton;

// if 이용 Lazy Initialization
public class GameSetting2 {

    private static GameSetting2 instance;

    private GameSetting2(){

    }

    public static GameSetting2 getInstance(){
        if(instance == null)
            instance = new GameSetting2();

        return instance;
    }
}
