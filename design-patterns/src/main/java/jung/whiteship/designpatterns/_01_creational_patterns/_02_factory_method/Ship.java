package jung.whiteship.designpatterns._01_creational_patterns._02_factory_method;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.whiteship.designpatterns._01_creational_patterns._03_abstract_factory._02_after.Anchor;
import me.whiteship.designpatterns._01_creational_patterns._03_abstract_factory._02_after.Wheel;

@Getter
@Setter
public class Ship {

    private String name;
    private String color;
    private String logo;
    private Wheel wheel;
    private Anchor anchor;

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
