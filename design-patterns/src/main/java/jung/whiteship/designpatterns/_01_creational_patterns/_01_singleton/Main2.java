package jung.whiteship.designpatterns._01_creational_patterns._01_singleton;

public class Main2 {
    public static void main(String[] args) {

        WrongGameSetting instance1 = WrongGameSetting.getInstance();
        WrongGameSetting instance2 = WrongGameSetting.getInstance();

        instance1.setKeySetting("Standard");
        instance1.setOs("Mac");

        instance2.setKeySetting("Custom");
        instance2.setOs("Windows7");

        // ???????????
        System.out.println(instance1.getKeySetting()
                +"\n" + instance2.getOs());

    }
}
