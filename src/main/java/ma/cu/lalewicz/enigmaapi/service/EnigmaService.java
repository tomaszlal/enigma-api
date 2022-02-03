package ma.cu.lalewicz.enigmaapi.service;

import ma.cu.lalewicz.enigmaapi.elements.ReflectorReversing;
import ma.cu.lalewicz.enigmaapi.elements.Rotor;
import ma.cu.lalewicz.enigmaapi.elements.RotorBlock;
import ma.cu.lalewicz.enigmaapi.elements.SwitchBoard;
import ma.cu.lalewicz.enigmaapi.model.EnigmaSettings;
import ma.cu.lalewicz.enigmaapi.utils.EnigmaConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnigmaService {

    private RotorBlock rotorBlock;

    private EnigmaSettings enigmaSet;

    public EnigmaService(EnigmaConst enigmaConst) {
        SwitchBoard switchBoard = new SwitchBoard("(FR) (YE) (US) (QO) (FS) (GL) (KB)");
        Rotor rotorR = new Rotor(enigmaConst.getRotorSettings("I").getEncryptionWiring(),0,enigmaConst.getRotorSettings("I").getIndentPosition(),enigmaConst.getRotorSettings("I").getNameRotor());
        Rotor rotorM = new Rotor(enigmaConst.getRotorSettings("II").getEncryptionWiring(),0,enigmaConst.getRotorSettings("II").getIndentPosition(),enigmaConst.getRotorSettings("II").getNameRotor());
        Rotor rotorL = new Rotor(enigmaConst.getRotorSettings("III").getEncryptionWiring(),0,enigmaConst.getRotorSettings("III").getIndentPosition(),enigmaConst.getRotorSettings("III").getNameRotor());
        ReflectorReversing invertReflector = new ReflectorReversing(enigmaConst.getReflectorSettings("B").getEncryptionWiring(),"B");
        rotorBlock =  new RotorBlock(switchBoard,rotorR,rotorM,rotorL,invertReflector);
        enigmaSet = new EnigmaSettings(rotorBlock);


    }

    //pobranie aktualnych ustawien bebnkow
    public EnigmaSettings getEnigmaSet(){
        enigmaSet.setEncryptedSign(null);
        return enigmaSet;
    }

    //szyfrowanie
    public EnigmaSettings encrypt(char sign){
        char c = rotorBlock.encodeChar(sign);
        enigmaSet.setEncryptedSign(c);
        enigmaSet.updatePositionRotors(rotorBlock);
        return enigmaSet;

    }

}
