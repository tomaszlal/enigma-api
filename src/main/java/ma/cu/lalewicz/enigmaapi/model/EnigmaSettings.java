package ma.cu.lalewicz.enigmaapi.model;


import ma.cu.lalewicz.enigmaapi.elements.RotorBlock;
import ma.cu.lalewicz.enigmaapi.utils.Util;
import org.springframework.stereotype.Component;

@Component
public class EnigmaSettings {
    //klasa do komunikacji z frontendem służy do ustawiania bebenkow
    // lub do wyswietlania aktualnych ustawien i pozycji bebenkow
    private Character encryptedSign;
    private String switchBoard;  //postac stringu ustawienia przelacznicy kablowej
    private String rotorRightName;  //aktualny nr bebenka
    private String rotorRightPosition; //aktualna pozycja bebenka

    private String rotorMiddleName;  //aktualny nr bebenka
    private String rotorMiddlePosition; //aktualna pozycja bebenka

    private String rotorLeftName;  //aktualny nr bebenka
    private String rotorLeftPosition; //aktualna pozycja bebenka

    private String reflectorReversingName;  //nazwa relektora odwracajacego
    private String reflectorReversing; //postac strigu ustawien reflektroa odwracajacego


    public EnigmaSettings() {
    }

    public EnigmaSettings(RotorBlock rotorBlock) {
        this.switchBoard = rotorBlock.getSwitchBoard().toString();
        this.rotorRightName = rotorBlock.getRotorRight().getRotorName();
        this.rotorRightPosition = Character.toString(Util.toChar(rotorBlock.getRotorRight().getPositionRotor()));
        this.rotorMiddleName = rotorBlock.getRotorMiddle().getRotorName();
        this.rotorMiddlePosition = Character.toString(Util.toChar(rotorBlock.getRotorMiddle().getPositionRotor()));
        this.rotorLeftName = rotorBlock.getRotorLeft().getRotorName();
        this.rotorLeftPosition = Character.toString(Util.toChar(rotorBlock.getRotorLeft().getPositionRotor()));
        this.reflectorReversingName = rotorBlock.getReflectorRev().getName();
        this.reflectorReversing = rotorBlock.getReflectorRev().toString();

    }

    public void updatePositionRotors(RotorBlock rotorBlock){
        this.rotorRightPosition = Character.toString(Util.toChar(rotorBlock.getRotorRight().getPositionRotor()));
        this.rotorMiddlePosition = Character.toString(Util.toChar(rotorBlock.getRotorMiddle().getPositionRotor()));
        this.rotorLeftPosition = Character.toString(Util.toChar(rotorBlock.getRotorLeft().getPositionRotor()));

    }

    public void updateRotorsName(RotorBlock rotorBlock){
        this.rotorRightName = rotorBlock.getRotorRight().getRotorName();
        this.rotorMiddleName = rotorBlock.getRotorMiddle().getRotorName();
        this.rotorLeftName = rotorBlock.getRotorLeft().getRotorName();
    }

    public void updateSwitchBord(RotorBlock rotorBlock){
        this.switchBoard = rotorBlock.getSwitchBoard().toString();
    }

    public void updateReflectorReversing(RotorBlock rotorBlock){
        this.reflectorReversingName = rotorBlock.getReflectorRev().getName();
        this.reflectorReversing = rotorBlock.getReflectorRev().toString();
    }

    public String getSwitchBoard() {
        return switchBoard;
    }

    public String getRotorRightName() {
        return rotorRightName;
    }

    public String getRotorRightPosition() {
        return rotorRightPosition;
    }

    public String getRotorMiddleName() {
        return rotorMiddleName;
    }

    public String getRotorMiddlePosition() {
        return rotorMiddlePosition;
    }

    public String getRotorLeftName() {
        return rotorLeftName;
    }

    public String getRotorLeftPosition() {
        return rotorLeftPosition;
    }

    public String getReflectorReversingName() {
        return reflectorReversingName;
    }

    public String getReflectorReversing() {
        return reflectorReversing;
    }

    public Character getEncryptedSign() {
        return encryptedSign;
    }

    public void setEncryptedSign(Character encryptedSign) {
        this.encryptedSign = encryptedSign;
    }
}
