package jung.whiteship.designpatterns._01_creational_patterns._02_factory_method;

public interface ShipFactory {

    default Ship orderShip(String name, String email){
        validate(name,email);
        prepareFor(name);
        Ship ship = createShip();
        sendMailTo(email,ship);
        return ship;
    }

    private void prepareFor(String name){
        System.out.println(name + "을 만들 준비 중...");
    };

    void sendMailTo(String email, Ship ship);

    Ship createShip();

    private void validate(String name, String email){

        if(name == null || name.isBlank())
            throw new IllegalArgumentException("이름을 적어주세요.");

        if(email == null || email.isBlank())
            throw new IllegalArgumentException("이메일을 적어주세요");
    }

}
