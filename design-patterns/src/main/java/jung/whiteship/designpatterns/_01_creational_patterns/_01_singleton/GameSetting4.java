package jung.whiteship.designpatterns._01_creational_patterns._01_singleton;

// Double checking
public class GameSetting4 {

    private static volatile GameSetting4 instance;

    private GameSetting4() {}

    public static GameSetting4 getInstance(){

        if(instance == null){
            synchronized ((GameSetting4.class)){
                if(instance == null)
                    instance = new GameSetting4();
            }

        }
        return instance;
    }

}
