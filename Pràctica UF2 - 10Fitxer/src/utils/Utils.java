/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 * Llibreria d'utilitats
 *
 * @author Jheremy Pinto Crespo
 * @version version
 *
 */
public class Utils {
// <editor-fold defaultstate="collapsed" desc="Implementació de LlegirInt()">

    private static Scanner scan=null;
    public static Scanner s = new Scanner(System.in);
    /**Aquesta funcion llegeix un numero.
     * 
     * @return Devuelve el numero que se haya introducido. 
     */
    public static int LlegirInt() {
        int result;

        if (scan == null)
            scan = new Scanner(System.in);
        result = LlegirInt(scan);

        return result;
    }
    
    /**Aquesta funcion llegeix un numero amb un missatge que es tu vols que sorti al demanar el numero.
     * 
     * @param missatge El parametre missatge es el missatge que es vol que surti per pedir un numero.
     * @return Devuelve el entero introducido.
     */
    public static int LlegirInt(String missatge) {
        int result;

        if (scan == null)
            scan = new Scanner(System.in);
        result = LlegirInt(scan, missatge);
        
        return result;
    }
    
    /**Aquesta funcion llegeix un numero posant l'escan com a parametre.
     * 
     * @param scan Este parametro es para escanear el int que es vol verificar si es correcte o no.
     * @return Retorna el valor que finalment sigui correcte.
     */
    public static int LlegirInt(Scanner scan) {
        return LlegirInt(scan, null);
    }
    
    /**Aquesta funcion llegeix un numero posant l'escan com a parametre, amb un missatge per pantalla i amb un limit maxim i minim.
     * 
     * @param scan Pide al usuari un int.
     * @param missatge Es el missatge que servira per interactuar amb l'usuari.
     * @param valorMin Es el valor minim que volem del numero que llegim.
     * @param valorMax Es el valor maxim que volem del numero que llegim.
     * @return Retorna el valor que estigui entre els parametres 'valorMin' y 'valorMax'.
     */
    public static int LlegirInt(Scanner scan, String missatge, int valorMin, int valorMax)
    {
        int result =0;
        do {
            result = LlegirInt(scan, missatge);
        } while (result < valorMin || result > valorMax);
        
        return result;
    }
    
    /**Aquesta funcion llegeix un numero posant l'escan com a parametre i amb un missatge per pantalla.
     * 
     * @param scan Aquest parametre es el numero que es vol verificar si es correcte o no
     * @param missatge Es el missatge que apareix pero el usuari.
     * @return Retorna el valor int que finalment sigui correcte.
     */
    public static int LlegirInt(Scanner scan, String missatge) {
        boolean dadesCorrectes;
        int result = 0;
        do {
            if (missatge != null) {
                System.out.print(missatge);
            }
            dadesCorrectes = scan.hasNextInt();
            if (dadesCorrectes) {
                result = scan.nextInt();
            } else if (scan.hasNext()) {
                scan.nextLine();
            }
        } while (!dadesCorrectes);

        return result;
    }
    
    public static int demanarEnter(String mtj){
        int num;
        System.out.print(mtj);
        
        while(!s.hasNextInt()){
            s.next();
            System.out.println("Ha de ser enter.");
            System.out.print(mtj);
        }
        
        num = s.nextInt();
        return num;
    }

// </editor-fold>
}
