/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author olgac
 */
public class Lotteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //avvio lotteria
        System.out.println("Avvio Lotteria ");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di righe: ");
        int rows = scanner.nextInt();
        System.out.print("Inserisci il numero di colonne: ");
        int columns = scanner.nextInt();

        /*int N = scanner.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         */
        // Scelta del numero dei numeri da estrarre
        Estrazione e = new Estrazione(rows, columns);
        e.Matrice(rows, columns);

        // Istanza ed avvio del thread Estrazione
        e.start();
        Giocatore g = new Giocatore(1, e);
        Giocatore g1 = new Giocatore(2, e);
        Giocatore g2 = new Giocatore(3, e);

// Istanza di alcuni thread Giocatore
        g.start();
        g1.start();
        g2.start();

        try {
            g.join();
            g1.join();
            g2.join();

            // Avvio dei thread Giocatori
            //il thread lotteria aspetta che il g1 (thread muoia)
        } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("errore nel join");
        }

        e.stampaVincitori();
        e.assegnaPunteggio();

        // Comunicazione fine gioco
        System.out.println("Fine Lotteria ");
    }
}
