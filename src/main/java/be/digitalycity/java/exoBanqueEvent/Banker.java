package be.digitalycity.java.exoBanqueEvent;

public interface Banker extends Customer {

    Personne getTitulaire();
    String getNumero();
    void appliquerInteret();
}
