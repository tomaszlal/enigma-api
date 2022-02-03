package ma.cu.lalewicz.enigmaapi.model;

// klasa reprezentująca bebenek czyli polączenia przewodów w irniku w postaci stringa i pozycje wciecia bebenka
public class RotorTemplate {
        private final String encryptionWiring;
        private final int indentPosition;
        private final String nameRotor;

    public RotorTemplate(String encryptionWiring, int indentPosition, String nameRotor) {
        this.encryptionWiring = encryptionWiring;
        this.indentPosition = indentPosition;
        this.nameRotor = nameRotor;
    }

    public String getEncryptionWiring() {
        return encryptionWiring;
    }

    public int getIndentPosition() {
        return indentPosition;
    }

    public String getNameRotor() {
        return nameRotor;
    }
}
