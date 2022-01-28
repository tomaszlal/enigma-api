package ma.cu.lalewicz.enigmaapi.elements;

import ma.cu.lalewicz.enigmaapi.model.SimpleSwitch;
import org.springframework.stereotype.Component;

@Component
public class SwitchBoard extends SimpleSwitch {

    public SwitchBoard(String switchSetting) {
        super(switchSetting);
    }

}
