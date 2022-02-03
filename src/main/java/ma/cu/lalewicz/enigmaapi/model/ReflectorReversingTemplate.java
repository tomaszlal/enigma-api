package ma.cu.lalewicz.enigmaapi.model;

//klasa reprezentujaca bebenek odwracający
public class ReflectorReversingTemplate {
    private final String encryptionWiring;
    private final String nameRotor;

    public ReflectorReversingTemplate(String encryptionWiring, String nameRotor) {
        this.encryptionWiring = encryptionWiring;
        this.nameRotor = nameRotor;
    }

    public String getEncryptionWiring() {
        return encryptionWiring;
    }

    public String getNameRotor() {
        return nameRotor;
    }
}
