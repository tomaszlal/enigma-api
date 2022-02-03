package ma.cu.lalewicz.enigmaapi.utils;

import ma.cu.lalewicz.enigmaapi.model.ReflectorReversingTemplate;
import ma.cu.lalewicz.enigmaapi.model.RotorTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class EnigmaConst {
    //hash mapa zawierajaca wszystkie dostepne konfiguracje bebenkow szysfujacych
    //dopisac wszystkie bebenki !!!!!!!!!!!
    private final static Map<String, RotorTemplate> rotors = new HashMap<>();
    private final static Map<String, ReflectorReversingTemplate> reflectors = new HashMap<>();

    // konstruktor definiujacy hash mape bebenkow
    public EnigmaConst() {

        //create static rotors
        rotors.put("I",new RotorTemplate("EKMFLGDQVZNTOWYHXUSPAIBRCJ",Util.toInt('R'),"I"));
        rotors.put("II",new RotorTemplate("AJDKSIRUXBLHWTMCQGZNPYFVOE",Util.toInt('F'),"II"));
        rotors.put("III",new RotorTemplate("BDFHJLCPRTXVZNYEIWGAKMUSQO",Util.toInt('W'),"III"));

        //create static reflectors
        reflectors.put("B",new ReflectorReversingTemplate("(AY) (BR) (CU) (DH) (EQ) (FS) (GL) (IP) (JX) (KN) (MO) (TZ) (VW)","B"));
    }

    //zwraca ustawienia podanego w sposób rzymski(do zastnowienia) bebenka wirnika
    public static RotorTemplate getRotorSettings(String nameRotor){
        return rotors.get(nameRotor);
    }

    //zwraca ustawienia reflektora odwracającego
    public static ReflectorReversingTemplate getReflectorSettings(String nameReflector){
        return reflectors.get(nameReflector);
    }

}
