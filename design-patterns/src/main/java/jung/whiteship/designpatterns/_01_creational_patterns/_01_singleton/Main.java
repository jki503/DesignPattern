package jung.whiteship.designpatterns._01_creational_patterns._01_singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // Holder innerClass 사용
        GameSetting5 instance = GameSetting5.getInstance();

        Constructor<GameSetting5> constructor = GameSetting5.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        GameSetting5 instance2 = constructor.newInstance();

        if(instance == instance2)
            System.out.println("게임 설정의 인스턴스는 같아요!");
        else
            System.out.println("xxxxxxx?");

    }

}
