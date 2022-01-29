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

    @Autowired
    private RotorBlock rotorBlock;


    private EnigmaSettings enigmaSet;



    public EnigmaService(EnigmaConst enigmaConst) {
        SwitchBoard switchBoard = new SwitchBoard("(FR) (YE) (US) (QO) (FS) (GL) (KB)");
        Rotor rotorR = new Rotor(enigmaConst.getRotorSettings("I").getEncryptionWiring(),0,enigmaConst.getRotorSettings("I").getIndentPosition());
        Rotor rotorM = new Rotor(enigmaConst.getRotorSettings("II").getEncryptionWiring(),0,enigmaConst.getRotorSettings("II").getIndentPosition());
        Rotor rotorL = new Rotor(enigmaConst.getRotorSettings("III").getEncryptionWiring(),0,enigmaConst.getRotorSettings("III").getIndentPosition());
        ReflectorReversing invertReflector = new ReflectorReversing("(AY) (BR) (CU) (DH) (EQ) (FS) (GL) (IP) (JX) (KN) (MO) (TZ) (VW)");
        rotorBlock =  new RotorBlock(switchBoard,rotorR,rotorM,rotorL,invertReflector);
        System.out.println(rotorBlock.getRotorLeft());
        enigmaSet = new EnigmaSettings(rotorBlock);
        System.out.println(enigmaSet.getSwitchBoard());

    }

    public EnigmaSettings getEnigmaSet(){
        System.out.println(enigmaSet.getSwitchBoard());
        return enigmaSet;
    }


}
