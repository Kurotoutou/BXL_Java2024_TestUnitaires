package bankDemo;

import be.digitalycity.java.exception.NonPositiveNumberException;
import be.digitalycity.java.exoBanqueEvent.Compte;
import be.digitalycity.java.exoBanqueEvent.Personne;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CompteTest {

    @Test
    public void positiveAmount_depositTest() {
        Personne personne = new Personne("Dupont", "Jean", LocalDate.EPOCH);
        Compte compte = new Compte("BE12 1234 1234 1234", personne) {
            @Override
            protected double calculInteret() {
                return 0;
            }
        };
        compte.setSolde(50);

        compte.depot(100);
        assertEquals(150, compte.getSolde());
    }

    @Test
    public void  negativeAmount_depositTest() {
        Personne personne = new Personne("Dupont", "Jean", LocalDate.EPOCH);
        Compte compte = new Compte("BE12 1234 1234 1234", personne) {
            @Override
            protected double calculInteret() {
                return 0;
            }
        };

        assertThrows(NonPositiveNumberException.class, () -> compte.depot(-50));
    }

    @Test
    public void zeroAmount_depositTest() {
        Personne personne = new Personne("Dupont", "Jean", LocalDate.EPOCH);
        Compte compte = new Compte("BE12 1234 1234 1234", personne) {
            @Override
            protected double calculInteret() {
                return 0;
            }
        };

        assertThrows(NonPositiveNumberException.class, () -> compte.depot(0));
    }

    @Test
    public void positiveAmount_retraitTest() {
        Personne personne = new Personne("Dupont", "Jean", LocalDate.EPOCH);
        Compte compte = new Compte("BE12 1234 1234 1234", personne) {
            @Override
            protected double calculInteret() {
                return 0;
            }
        };

        compte.setSolde(50);
        compte.retrait(100);
        assertEquals(-50, compte.getSolde());

    }

    @Test
    public void negativeAmount_retraitTest() {
        Personne personne = new Personne("Dupont", "Jean", LocalDate.EPOCH);
        Compte compte = new Compte("BE12 1234 1234 1234", personne) {
            @Override
            protected double calculInteret() {
                return 0;
            }
        };

        assertThrows(NonPositiveNumberException.class, () -> compte.retrait(-50));
    }

    @Test
    public void zeroAmount_retraitTest() {
        Personne personne = new Personne("Dupont", "Jean", LocalDate.EPOCH);
        Compte compte = new Compte("BE12 1234 1234 1234", personne) {
            @Override
            protected double calculInteret() {
                return 0;
            }
        };

        assertThrows(NonPositiveNumberException.class, () -> compte.retrait(0));
    }


}

