package ma.cu.lalewicz.enigmaapi.utils;

import org.springframework.stereotype.Component;

@Component
public class Util {
    public static char toChar(int charInt){
        return (char)(charInt+65);
    }

    public static int toInt(char intChar) {
        return ((int)(intChar))-65;
    }
}
