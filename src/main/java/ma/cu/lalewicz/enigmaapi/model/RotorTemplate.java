package ma.cu.lalewicz.enigmaapi.model;


public class RotorTemplate {
        private final String encryptionWiring;
        private final int indentPosition;

    public RotorTemplate(String encryptionWiring, int indentPosition) {
        this.encryptionWiring = encryptionWiring;
        this.indentPosition = indentPosition;
    }

    public String getEncryptionWiring() {
        return encryptionWiring;
    }

    public int getIndentPosition() {
        return indentPosition;
    }
}
