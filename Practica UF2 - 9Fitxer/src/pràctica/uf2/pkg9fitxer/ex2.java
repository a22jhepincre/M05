package pràctica.uf2.pkg9fitxer;

import java.util.Scanner;

public class ex2 {

    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int resultat = euclides(184, 412);
        System.out.println("El resultat es: " + resultat);
    }

    static int euclides(int num1, int num2) {
        
        if (num2 == 0) return num1;
        else return euclides(num2, num1 % num2);
       
    }

}
