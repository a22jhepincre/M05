package pràctica.uf2.pkg9fitxer;

import java.util.Scanner;

public class ex2 {

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
        
        //PIDO AL USUARIO LOS DOS NUMEROS ENTEROS LLAMANDO A LA FUNCION escanearInt();
        int num = escanearInt("Introduce el primer numero entero: ");
        int num2 = escanearInt("Introduce el segundo numero entero: ");
        
        //BUSCO EL MCD DE LOS NUMEROS PEDIDOS LLAMANDO A LA FUNCION euclides();
        int resultat = euclides(num, num2);
        //IMPRIMO EL RESULTADO
        System.out.println("El resultat es: " + resultat);
    }

    static int euclides(int num1, int num2) {
        //UNA FUNCION RECURSIVA QUE TERMINARA CUANDO EL num2 = 0
        if (num2 == 0) return num1;
        //SI NO NOS QUEDAMOS CON EL num2 Y EL RESTO DE LA DIVISION DE num1/num2 Y ASI HASTA QUE num2=0
        else return euclides(num2, num1 % num2);
       
    }

}
