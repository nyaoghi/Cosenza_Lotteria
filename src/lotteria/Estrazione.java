/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import static java.lang.Math.random;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author olgac
 */
public class Estrazione extends Thread {

    // attributi
    private int numero;
    //private int vincitori[];
    private int rows;
    private int columns;
    private int[][] matrice;
// inizializzazione array vincitori
    ArrayList<Integer> gVincenti = new ArrayList<Integer>();

    /**
     *
     * Metodo costruttore
     */
    public Estrazione(int rows, int columns) {

        //ultima ver
        this.rows = rows;
        this.columns = columns;

    }
    //inserimento numeri

    public void Matrice(int rows, int columns) {
        matrice = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                Random random = new Random();
                matrice[i][j] = random.nextInt(100);
            }
        }
        stampaMatrice();
    }

    /**
     *
     * Metodo per visualizzare la matrice dei numeri estratti
     */
    public void stampaMatrice() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrice[i][j] + "\t ");
            }
            System.out.println();
        }
    }

    /**
     *
     * Metodo per visualizzare i vincitori dell'estrazione
     */
    public void stampaVincitori() {
        // stampa array dei vincitori

        System.out.println("Vincitori: " + gVincenti);

    }

    public void assegnaPunteggio() {
        int punteggio = 0;
        for (int k = 0; k < gVincenti.size(); k++) {
            if (gVincenti.get(k) != null) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (matrice[i][j] == numero) {
                            punteggio = i * j;
                            
                            System.out.println("Giocatore" + gVincenti.get(k) + " Hai ottenuto un punteggio di " + punteggio);
                            return;
                        }
                    }

                }
            } else {
            }

        }
    }

    /**
     *
     * Metodo per verificare il numero scelto dal giocatore e determinare i
     * vincitori
     */
    public void verifica(int numero, int idGiocatore) {

        boolean flag = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (numero == matrice[i][j]) {
                    flag = true;
                    System.out.println("Giocatore " + idGiocatore + " hai scelto il numero " + numero + " e hai vinto");
                    while (gVincenti.size() < 3) {
                        gVincenti.add(idGiocatore);
                        return;
                    }
                }
            }
        }
        if (!flag) {
            System.out.println("Giocatore " + idGiocatore + " hai perso");
        }

    }
}
/*  if (numero == this.numero) {
            System.out.println("Giocatore " + idGiocatore + "hai scelto il numero " + numero + " e hai vinto");
        } else {
            System.out.println("Hai perso");
        }
 */
