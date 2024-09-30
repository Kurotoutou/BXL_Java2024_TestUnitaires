package be.digitalycity.java.exoBanqueEvent;

import java.time.LocalDateTime;

public class Epargne extends Compte {


    private LocalDateTime dateDernierRetrait;


    //region Getters/Setters
    public LocalDateTime getDateDernierRetrait() {
        return dateDernierRetrait;
    }

    public void setDateDernierRetrait(LocalDateTime dateDernierRetrait) {
        this.dateDernierRetrait = dateDernierRetrait;
    }

    //endregion

    //region construcor
    public Epargne(String numero, Personne titulaire) {
        super(numero, titulaire);
    }
    //endregion

   /* void retrait(double montant) {
        if (getSolde() == 0) {
            System.out.println("Impossible d'aller en négatif.");
        }
        else {
            setSolde(- montant);
            dateDernierRetrait = LocalDateTime.now();
        }
    }*/

    @Override
    public void retrait(double montant) {
        if (getSolde() >= montant) {
            super.retrait(montant);
            setDateDernierRetrait(LocalDateTime.now());
        }
    }

    @Override
    public void depot(double montant) {
        super.depot(montant);
    }

    /*@Override
    protected double calculInteret() {
        return 4.5;
    }*/

    @Override
    protected double calculInteret() {
        return getSolde() * 0.03;
    }
}
