package ma.cu.lalewicz.enigmaapi.elements;

import ma.cu.lalewicz.enigmaapi.model.SimpleSwitch;
import org.springframework.stereotype.Component;

@Component
public class ReflectorReversing extends SimpleSwitch {
    private String name;

    public ReflectorReversing() {
    }

    public ReflectorReversing(String switchSetting, String name)
    {
        super(switchSetting);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
