package ma.cu.lalewicz.enigmaapi.model;


import ma.cu.lalewicz.enigmaapi.elements.RotorBlock;
import org.springframework.stereotype.Component;

@Component
public class EnigmaSettings {
    //klasa do komunikacji z frontendem służy do ustawiania bebenkow
    // lub do wyswietlania aktualnych ustawien i pozycji bebenkow
    private String switchBoard;  //postac stringu ustawienia przelacznicy kablowej
    private String rotorRight;  //aktualny nr bebenka
    private String rotorRightPosition; //aktualna pozycja bebenka

    private String rotorMiddle;  //aktualny nr bebenka
    private String rotorMiddlePosition; //aktualna pozycja bebenka

    private String rotorLeft;  //aktualny nr bebenka
    private String rotorLeftPosition; //aktualna pozycja bebenka


    public EnigmaSettings() {
    }

    public EnigmaSettings(RotorBlock rotorBlock) {
        this.switchBoard = rotorBlock.getSwitchBoard().toString();
    }


    public String getSwitchBoard() {
        return switchBoard;
    }

    public void setSwitchBoard(String switchBoard) {
        this.switchBoard = switchBoard;
    }

    public String getRotorRight() {
        return rotorRight;
    }

    public void setRotorRight(String rotorRight) {
        this.rotorRight = rotorRight;
    }

    public String getRotorRightPosition() {
        return rotorRightPosition;
    }

    public void setRotorRightPosition(String rotorRightPosition) {
        this.rotorRightPosition = rotorRightPosition;
    }


    public String getRotorMiddle() {
        return rotorMiddle;
    }

    public void setRotorMiddle(String rotorMiddle) {
        this.rotorMiddle = rotorMiddle;
    }

    public String getRotorMiddlePosition() {
        return rotorMiddlePosition;
    }

    public void setRotorMiddlePosition(String rotorMiddlePosition) {
        this.rotorMiddlePosition = rotorMiddlePosition;
    }

    public String getRotorLeft() {
        return rotorLeft;
    }

    public void setRotorLeft(String rotorLeft) {
        this.rotorLeft = rotorLeft;
    }

    public String getRotorLeftPosition() {
        return rotorLeftPosition;
    }

    public void setRotorLeftPosition(String rotorLeftPosition) {
        this.rotorLeftPosition = rotorLeftPosition;
    }
}
