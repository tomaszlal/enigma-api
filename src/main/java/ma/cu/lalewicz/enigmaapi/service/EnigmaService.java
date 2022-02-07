package ma.cu.lalewicz.enigmaapi.service;

import ma.cu.lalewicz.enigmaapi.elements.ReflectorReversing;
import ma.cu.lalewicz.enigmaapi.elements.Rotor;
import ma.cu.lalewicz.enigmaapi.elements.RotorBlock;
import ma.cu.lalewicz.enigmaapi.elements.SwitchBoard;
import ma.cu.lalewicz.enigmaapi.model.EnigmaSettings;
import ma.cu.lalewicz.enigmaapi.utils.EnigmaConst;
import ma.cu.lalewicz.enigmaapi.utils.Util;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static java.util.Set.*;

@Service
public class EnigmaService {

    private RotorBlock rotorBlock;

    private EnigmaSettings enigmaSet;

    public EnigmaService(EnigmaConst enigmaConst) {
        SwitchBoard switchBoard = new SwitchBoard("(FR) (YE) (US) (QO) (FS) (GL) (KB)");
        Rotor rotorR = new Rotor(enigmaConst.getRotorSettings("I").getEncryptionWiring(), 0, enigmaConst.getRotorSettings("I").getIndentPosition(), enigmaConst.getRotorSettings("I").getNameRotor());
        Rotor rotorM = new Rotor(enigmaConst.getRotorSettings("II").getEncryptionWiring(), 0, enigmaConst.getRotorSettings("II").getIndentPosition(), enigmaConst.getRotorSettings("II").getNameRotor());
        Rotor rotorL = new Rotor(enigmaConst.getRotorSettings("III").getEncryptionWiring(), 0, enigmaConst.getRotorSettings("III").getIndentPosition(), enigmaConst.getRotorSettings("III").getNameRotor());
        ReflectorReversing invertReflector = new ReflectorReversing(enigmaConst.getReflectorSettings("B").getEncryptionWiring(), "B");
        rotorBlock = new RotorBlock(switchBoard, rotorR, rotorM, rotorL, invertReflector);
        enigmaSet = new EnigmaSettings(rotorBlock);


    }

    //pobranie aktualnych ustawien bebnkow
    public EnigmaSettings getEnigmaSet() {
        enigmaSet.setEncryptedSign(null);
        return enigmaSet;
    }

    //szyfrowanie
    public EnigmaSettings encrypt(char sign) {
        if (sign >= 'A' && sign <= 'Z') {
            char c = rotorBlock.encodeChar(sign);
            enigmaSet.setEncryptedSign(c);
        } else {
            enigmaSet.setEncryptedSign('#');
        }

        enigmaSet.updatePositionRotors(rotorBlock);
        return enigmaSet;

    }

    //ustawianie
    // wirniki  postac endpointa
    //    /{locationRotor}/{position}
    public EnigmaSettings setRotorPosition(String rotorLocation, char position) {
        if (position >= 'A' && position <= 'Z') {
            switch (rotorLocation) {
                case "right":
                    rotorBlock.getRotorRight().setPositionRotor(Util.toInt(position));
                    enigmaSet.setEncryptedSign(null);
                    break;
                case "middle":
                    rotorBlock.getRotorMiddle().setPositionRotor(Util.toInt(position));
                    enigmaSet.setEncryptedSign(null);
                    break;
                case "left":
                    rotorBlock.getRotorLeft().setPositionRotor(Util.toInt(position));
                    enigmaSet.setEncryptedSign(null);
                    break;
                default:
                    enigmaSet.setEncryptedSign('#');
            }
        } else {
            enigmaSet.setEncryptedSign('#');
        }

        enigmaSet.updatePositionRotors(rotorBlock);
        return enigmaSet;
    }

    //ustawienie "włożenie" wirnika po numerze zapisanym w sposób rzymski do bloku wirników
    // endpoint
    // /rotor-block/{rotorLocation}/{nameRotor}
    public EnigmaSettings setRotorNumber(String rotorLocation, String nameRotor) {
        if (EnigmaConst.isKeyInRotors(nameRotor)) {
            switch (rotorLocation) {
                case "right":
                    rotorBlock.setRotorRight(
                            new Rotor(EnigmaConst.getRotorSettings(nameRotor).getEncryptionWiring(),
                                    rotorBlock.getRotorRight().getPositionRotor(),
                                    EnigmaConst.getRotorSettings(nameRotor).getIndentPosition(),
                                    EnigmaConst.getRotorSettings(nameRotor).getNameRotor()));
                    enigmaSet.setEncryptedSign(null);
                    enigmaSet.updateRotorsName(rotorBlock);
                    break;
                case "middle":
                    rotorBlock.setRotorMiddle(
                            new Rotor(EnigmaConst.getRotorSettings(nameRotor).getEncryptionWiring(),
                                    rotorBlock.getRotorMiddle().getPositionRotor(),
                                    EnigmaConst.getRotorSettings(nameRotor).getIndentPosition(),
                                    EnigmaConst.getRotorSettings(nameRotor).getNameRotor()));
                    enigmaSet.setEncryptedSign(null);
                    enigmaSet.updateRotorsName(rotorBlock);
                    break;
                case "left":
                    rotorBlock.setRotorLeft(
                            new Rotor(EnigmaConst.getRotorSettings(nameRotor).getEncryptionWiring(),
                                    rotorBlock.getRotorLeft().getPositionRotor(),
                                    EnigmaConst.getRotorSettings(nameRotor).getIndentPosition(),
                                    EnigmaConst.getRotorSettings(nameRotor).getNameRotor()));
                    enigmaSet.setEncryptedSign(null);
                    enigmaSet.updateRotorsName(rotorBlock);
                    break;
                default:
                    enigmaSet.setEncryptedSign('#'); // błąd
            }
        } else {
            enigmaSet.setEncryptedSign('#'); // błąd
        }

        return enigmaSet;
    }

    //ustawienie przelacznicy wtyczkowej - switch board
    //string w postaci "(AS) (DE) (JR)"
    //endpoint
    // /switchboard?wiring=(SD) (FG) (YT)
    public EnigmaSettings setSwitchBoard(String wirings){
        //sprawdzenie poprawnosci wirings ?????????? czy po stronie frontendu
        rotorBlock.setSwitchBoard(new SwitchBoard(wirings));
        enigmaSet.updateSwitchBord(rotorBlock);
        enigmaSet.setEncryptedSign(null);
        return enigmaSet;
    }
}
