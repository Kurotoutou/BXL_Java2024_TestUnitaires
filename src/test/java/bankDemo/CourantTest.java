package bankDemo;

import be.digitalycity.java.exception.NonPositiveNumberException;
import be.digitalycity.java.exoBanqueEvent.Courant;
import be.digitalycity.java.exoBanqueEvent.Personne;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CourantTest {

    @Test
    public void positiveSetLigneDeCredit_ligneDeCreditTest() {
        double ligneDeCredit = 40;
        Courant courant = new Courant("", new Personne("", "", LocalDate.now()));

        courant.setLigneDeCredit(ligneDeCredit);
        assertEquals(40, courant.getLigneDeCredit());
    }

    @Test
    public void negativeSetLigneDeCredit_ligneDeCreditTest() {
        Courant courant = new Courant("", new Personne("", "", LocalDate.now()));

        assertThrows(NonPositiveNumberException.class, () -> courant.setLigneDeCredit(-40));
    }

    @Test
    public void zeroSetLigneDeCredit_ligneDeCreditTest() {
        Courant courant = new Courant("", new Personne("", "", LocalDate.now()));

        assertEquals(100, courant.getLigneDeCredit());
    }

    @Test
    public void positiveRetrait_positiveLigneDeCredit_retraitTest() {
        Courant courant = new Courant("", new Personne("", "", LocalDate.now()));
        int ligneDeCredit = 100;

        courant.depot(100);
        courant.retrait(200);
        assertEquals(-100, courant.getSolde());
    }

    @Test
    public void negativeRetrait_positiveLigneDeCredit_retraitTest() {
        Courant courant = new Courant("", new Personne("", "", LocalDate.now()));
        int ligneDeCredit = 100;

        assertThrows(NonPositiveNumberException.class, () ->
                courant.retrait(-50));
    }

    @Test
    public void zeroRetrait_positiveLigneDeCredit_retraitTest() {
        Courant courant = new Courant("", new Personne("", "", LocalDate.now()));
        int ligneDeCredit = 100;

        assertThrows(NonPositiveNumberException.class, () ->
                courant.retrait(0));
    }

    @Test
    public void positiveRetrait_negativeLigneDeCredit_retraitTest() {
        Courant courant = new Courant("", new Personne("", "", LocalDate.now()));

        assertThrows(NonPositiveNumberException.class, () ->
                courant.setLigneDeCredit(-100));
    }

    @Test
    public void positiveRetrait_zeroLigneDeCredit_retraitTest() {
        Courant courant = new Courant("", new Personne("", "", LocalDate.now()));
        int ligneDeCredit = 0;

        courant.depot(100);
        courant.setLigneDeCredit(ligneDeCredit);
        courant.retrait(100);

        assertEquals(0, courant.getSolde());
    }

    @Test
    public void negativeRetrait_negativeLigneDeCredit_retraitTest() {
        Courant courant = new Courant("", new Personne("", "", LocalDate.now()));

        assertThrows(NonPositiveNumberException.class, () ->
                courant.setLigneDeCredit(-100));
    }
}
