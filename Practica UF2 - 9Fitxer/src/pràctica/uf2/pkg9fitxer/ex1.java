
package pràctica.uf2.pkg9fitxer;
import java.util.Scanner;

public class ex1 {

    public static Scanner s = new Scanner(System.in);
    static int escanearInt(String mtj){
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
    public static void main(String[] args) {
        
        //PIDO UN NUMERO AL USUARIO
        int num = escanearInt("Escribe un numero: ");
        int resultat;
        
        //LLAMO A MI FUNCION m1 Y IMPRIMO EL RESULTADO
        resultat = m1(num);
        System.out.println("Resultado del apartado a: " + resultat);
        
        //LLAMO A MI FUNCION m2 Y IMPRIMO EL RESULTADO
        resultat = m2(1, num);
        System.out.println("Resultado del apartado b: " + resultat);
        
        //LLAMO A MI FUNCION m3 Y IMPRIMO EL RESULTADO
        resultat = m3(num);
        System.out.println("Resultado del apartado c: " + resultat);
        
        //LLAMO A MI FUNCION m4Y IMPRIMO EL RESULTADO
        resultat = m4(num);
        System.out.println("Resultado del apartado d: " + resultat);
        
    }
    //a)
    static int m1 (int n){
        int resultat = n;
        //while QUE SALE CUANDO N = 1;
        while(n != 1){
            //SE IRA MULTIPLICANDO LA N * (N-1) Y SE RESTARA LA N
            n--;
            resultat *= n;
        }
        //DEVUELVO EL RESULTADO
        return resultat;
    }
    
    //b
    static int m2(double x, int n){
        boolean salir = false;
        int resultat = 0;
        
        //while QUE SALDRA CUANDO LA N = 0
        while(!salir){
            if(n == 0){
                salir = true;
            } else {
                //SI NO ES 0 IRA SUMANDO A UNA VARIABLE LA N Y SE IRA RESTANDO LA N HASTA LLEGAR A 0
                resultat += n;
                n--;
            }
        }
        //DEVUELVO EL RESULTADO
        return resultat;
    }
    
    //c)
    static int m3(int n){
        boolean salir = false;
        int cont = 0;
        //while QUE SALDRA CUANDO LA N < 2
        while(!salir){
            if(n < 2){
                salir = true;
            }else{
                //MIENTRAS NO SEA N < 2 IRE DIVIENDO LA MISMA N ENTRE 2 (N/2) Y IRE CONTANDO CUANTAS VECES SE PUEDE HACER
                cont++;
                n /= 2;
            }
        }
        //DEVOLVERE EL CONTADOR DE CUANTAS VECES SE PUDO DIVIDIR ENTRE 2
        return cont;
    }
    
    //d)
    static int m4 (int n){
        boolean salir = false;
        int divisor = 1;
        int aux;
        int sumador = 0;
        
        //while QUE SALDRA CUANDO LA N/DIVISOR = 0;
        while(!salir){
            aux = n / divisor;
            if(aux == 0){
                salir = true;
            } else {
                //IRE SUMANDO NUMERO POR NUMERO SEPARANDOLOS, ES DECIR, N = 1234 RESULTADO = 1+2+3+4
                sumador += aux % 10;
                divisor *= 10;
            }
        }
        //DEVUELVO LA SUMA DE TODOS LOS NUMEROS
        return sumador;
    }
}
