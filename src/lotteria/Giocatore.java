/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olga cosenza
 */
public class Giocatore extends Thread {

    // attributi
    private int idGiocatore;
    private String nomeGiocatore;
    private Estrazione estrazione;

    /**
     *
     * Metodo costruttore
     *
     * @param idGiocatore codice del giocatore
     * @param estrazione riferimento dell'oggetto Estrazione
     */
    public Giocatore(int idGiocatore, Estrazione estrazione) {

        // inizializzazione attributi
        this.idGiocatore = idGiocatore;
        this.estrazione = estrazione;
    }

    Random n = new Random();

    /**
     *
     * Metodo per eseguire il thread
     */
    public void run() {

        //System.out.println("ID giocatore:" + idGiocatore);
        // scelta del numero da giocare
        int nScelto = n.nextInt(50);

        //conto alla rovescia
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("errore sleep");
            }

        }
        try {
            // estrazione.verifica(nScelto, idGiocatore);

            // stampa fine verifica
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Giocatore ID: " + idGiocatore + " ho verificato il numero");

        estrazione.verifica(nScelto, idGiocatore);

    } //morte del trhead 

}
