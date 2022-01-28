package ma.cu.lalewicz.enigmaapi.elements;

import ma.cu.lalewicz.enigmaapi.model.SimpleSwitch;
import org.springframework.stereotype.Component;

@Component
public class ReflectorReversing extends SimpleSwitch {

    public ReflectorReversing(String switchSetting) {
        super(switchSetting);
    }


}
