package be.digitalycity.java.exoBanqueEvent;

import be.digitalycity.java.exception.NonPositiveNumberException;

public class Courant extends Compte {

    private double ligneDeCredit;


    //region getters/Setters
    public double getLigneDeCredit() {
        return ligneDeCredit;
    }


    /**
     * Method who set the LigneDeCredit and throw an exception if negative number
     * is inputted
     * @param ligneDeCredit
     * @throws NonPositiveNumberException
     * @Modify this && this.ligneDeCredit
     */
    public void setLigneDeCredit(double ligneDeCredit) {
        if (ligneDeCredit < 0) {
            throw new NonPositiveNumberException("Pas possible en dessous de 0");
        }
        else {
            this.ligneDeCredit = ligneDeCredit;
        }
    }
    //endregion


    //region constructor
    public Courant(String numero, Personne titulaire) {
        super(numero, titulaire);
        this.ligneDeCredit = 100;
    }

    public Courant(String numero, Personne titulaire, double ligneDeCredit) {
        super(numero, titulaire);
        setLigneDeCredit(ligneDeCredit);
    }
    //endregion


    /*public void retrait(double montant){
        if(montant > 0 && montant <= getSolde() + ligneDeCredit){
            setSolde(montant);
        }
    }*/

    /**
     * Method that withdrawal an amount with the lignDeCredit that puts a limit
     * to how much you can go below zero on your account
     * @param montant double > 0
     * @throws NonPositiveNumberException
     * @modify this && this.total
     */
    @Override
    public void retrait(double montant) {
        if (montant > 0 && montant <= getSolde() + ligneDeCredit) {
            super.retrait(montant);
        }
        else {
            throw new NonPositiveNumberException("Blabla");
        }
    }


    @Override
    public void depot(double montant) {
        super.depot(montant);
    }

    /*@Override
    protected double calculInteret() {
        if (getSolde() > 0) {
            return 3;
        }
        else {
            return 9.75;
        }
    }*/

    @Override
    protected double calculInteret() {
        return (getSolde() > 0 ? 00.0 : 0.0975) * getSolde();
    }
}
