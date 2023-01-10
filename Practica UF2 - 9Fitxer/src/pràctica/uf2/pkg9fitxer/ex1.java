
package pràctica.uf2.pkg9fitxer;
import java.util.Scanner;

public class ex1 {

    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        
        int num = s.nextInt();
        int resultat = m1(num);
        System.out.println("Resultat: " + resultat);
    }
    static int m1 (int n){
        int resultat = n;
        
        while(n != 1){
            n--;
            resultat *= n;
        }
        
        return resultat;
    }
    static int m3(int n){
        int result = 0;
        int divisor = 2;
        
        while(n < 2){
            result = 1 + (n/divisor);
            divisor += 2;
        }
        
        return result;
    }
    static int m4 (int n){
        int result = 0;
        int divisor = 10;
        while(n != 0){
            result = n % divisor + n/10;
            divisor += 10;
        }
        
        return result;
    }
}
