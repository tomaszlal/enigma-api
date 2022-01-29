package ma.cu.lalewicz.enigmaapi.utils;

import ma.cu.lalewicz.enigmaapi.model.RotorTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class EnigmaConst {
    //hash mapa zawierajaca wszystkie dostepne konfiguracje bebenkow szysfujacych
    private final static Map<String, RotorTemplate> rotors = new HashMap<String, RotorTemplate>();

    // konstruktor definiujacy hash mape bebenkow
    public EnigmaConst() {
        rotors.put("I",new RotorTemplate("EKMFLGDQVZNTOWYHXUSPAIBRCJ",Util.toInt('R')));
        rotors.put("II",new RotorTemplate("AJDKSIRUXBLHWTMCQGZNPYFVOE",Util.toInt('F')));
        rotors.put("III",new RotorTemplate("BDFHJLCPRTXVZNYEIWGAKMUSQO",Util.toInt('W')));
    }

    //zwraca ustawienia podanego w sposób rzymski(do zastnowienia) bebenka odwracajacego
    public static RotorTemplate getRotorSettings(String nameRotor){
        return rotors.get(nameRotor);
    }


}
