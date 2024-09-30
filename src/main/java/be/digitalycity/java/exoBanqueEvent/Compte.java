package be.digitalycity.java.exoBanqueEvent;

import be.digitalycity.java.exception.NonPositiveNumberException;

public abstract class Compte implements Banker {

    private String numero;
    private double solde;
    private Personne titulaire;
//    private final List<PassageEnNegatifSubscriber> passageEnNegatifEvent;

    //region Getters/Setters
    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        boolean estPositif = this.solde >= 0;
        this.solde = solde;
//        if(estPositif && this.solde < 0) {
//            raisePassageEnNegtifEvent();
//        }
    }

    @Override
    public Personne getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Personne titulaire) {
        this.titulaire = titulaire;
    }
    //endregion

    //region contructor
    public Compte(){

    }
    protected Compte(String numero, Personne titulaire) {
        this.numero = numero;
        this.titulaire = titulaire;
    }
    //endregion


    /**
     * Method used to add an amout to total account
     * @param montant double > 0
     * @throws be.digitalycity.java.exception.NonPositiveNumberException / montant <= 0
     * @modify this && this.total
     */
    @Override
    public void depot(double montant) {
        if (montant <= 0) {
            throw  new NonPositiveNumberException("Amounr must be > 0");
        }
        else {
            solde += montant;
        }
    }

    /**
     * Methode used to substract amount to total account
     * @param montant double > 0
     * @throws be.digitalycity.java.exception.NonPositiveNumberException | compte <= 0
     * @modify this && this.total
     */
    @Override
    public void retrait(double montant) {
        if (montant > 0) {
            solde -= montant;
        }
        else {
            throw new NonPositiveNumberException("Amount must be > 0");
        }
    }

    protected abstract double calculInteret();

    /*public double appliquerInteret(double retourInteret) {
        return solde += ((solde / 100) * retourInteret);
    }*/

    @Override
    public void appliquerInteret() {
        setSolde(getSolde() + calculInteret());
    }

//    @Override
//    public String toString() {
//        return appliquerInteret(calculInteret());
//    }
//    public void subscribePassageEnNegatifEvent(PassageEnNegatifSubscriber subscriber) {
//        passageEnNegatifEvent.add(subscriber);
//    }
//
//    private void raisePassageEnNegtifEvent() {
//        for(PassageEnNegatifSubscriber subscriber : passageEnNegatifEvent) {
//            subscriber.execute(this);
//        }
    }


