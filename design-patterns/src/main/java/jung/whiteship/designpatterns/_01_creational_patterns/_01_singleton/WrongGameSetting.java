package jung.whiteship.designpatterns._01_creational_patterns._01_singleton;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WrongGameSetting {

    private String KeySetting;
    private String os;

    private WrongGameSetting(){}

    private static class WrongGameSettingHolder{
        private static final WrongGameSetting SETTING = new WrongGameSetting();
    }

    public static WrongGameSetting getInstance(){
        return WrongGameSettingHolder.SETTING;
    }

}
