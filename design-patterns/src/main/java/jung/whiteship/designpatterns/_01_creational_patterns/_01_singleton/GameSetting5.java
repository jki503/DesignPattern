package jung.whiteship.designpatterns._01_creational_patterns._01_singleton;

// inner class
public class GameSetting5 {

    private GameSetting5(){}

    private static class GameSettingHolder{
        private static final GameSetting5 SETTINGS = new GameSetting5();

    }

    public static GameSetting5 getInstance(){
        return GameSettingHolder.SETTINGS;
    }

}
