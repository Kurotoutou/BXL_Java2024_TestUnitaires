package be.digitalycity.java.exoBanqueEvent;

public interface Customer {

    double getSolde();
    void depot(double montant);
    void retrait(double montant);
}
