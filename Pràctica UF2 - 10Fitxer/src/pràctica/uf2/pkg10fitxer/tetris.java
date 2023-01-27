package pràctica.uf2.pkg10fitxer;

import java.util.Random;
import static utils.Utils.*;
import java.util.Scanner;

public class tetris {

    public static Random rnd = new Random();
    public static Scanner s = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        //PIDO LAS FILAS Y LAS COLUMNAS QUE QUIERE EL USUARIO PARA EL TABLERO
        int filas = demanarEnter("Escribe el numero de filas que quieras: ") + 6;
        int columnas = demanarEnter("Escribe el numero de columnas que quieres: ");
        //CREO EL TABLERO
        int[][] tablero = new int[filas][columnas];
        //INICIALIZO MI TABLERO LLAMANDO A MI FUNCION inicializarTablero(tablero)
        tablero = inicializarTablero(tablero);

        //DECLARO MI BOOLEANO PARA VERIFICAR CUANDO SALIR DEL BUCLE WHILE
        boolean ganar = false;
        int opcion;
        //BUCLE WHILE QUE SALDRA CUANDO HAYA ALGUN 1(parte de pieza) EN LA FILA 5 QUE ES EL LIMITE
        while (!ganar) {
            opcion = rnd.nextInt(1, 5);
            //ESCOGERA ALGUNA DE LAS OPCIONES DE MANERA RANDOM
            switch (opcion) {
                //EL CASO 1 ES LA PIEZA DE UNA L
                case 1 -> {
                    tablero[4][1] = 1;
                    tablero[4][2] = 1;
                    tablero[3][2] = 1;
                    tablero[2][2] = 1;
                    //PRINTEO EL TABLERO PARA QUE EL USUARIO VEA QUE PIEZA LE HA TOCADO
                    printearTablero(tablero);
                    //MUEVO SI QUIERO LA FICHA DE IZQUIERDA A DERECHA CON MI FUNCION moverFichaL(tablero)
                    int posicion = moverFichaL(tablero);
                    if (posicion != -1) //CUANDO HAYA DECIDIDO DONDE MOVER LA FICHA DEJO CAERLA CON LA FUNCION colocarL(tablero)
                    {
                        colocarL(tablero, posicion);
                    } else {
                        ganar = true;
                    }
                }
                //CASO 2 ES UN CUDRADO
                case 2 -> {
                    tablero[4][1] = 1;
                    tablero[4][2] = 1;
                    tablero[3][2] = 1;
                    tablero[3][1] = 1;
                    //PRINTEO EL TABLERO PARA QUE EL USUARIO VEA QUE PIEZA LE HA TOCADO
                    printearTablero(tablero);
                    //MUEVO SI QUIERO LA FICHA DE IZQUIERDA A DERECHA CON MI FUNCION moverFichaCuadrado(tablero)
                    int posicion = moverFichaCuadrado(tablero);
                    if (posicion != -1) //CUANDO HAYA DECIDIDO DONDE MOVER LA FICHA DEJO CAERLA CON LA FUNCION colocarCuadrado(tablero)
                    {
                        colocarCuadrado(tablero, posicion);
                    } else {
                        ganar = true;
                    }
                }
                //CASO 3 2N TIPO DE L
                case 3 -> {
                    tablero[4][1] = 1;
                    tablero[4][2] = 1;
                    tablero[4][3] = 1;
                    tablero[3][1] = 1;
                    //PRINTEO EL TABLERO PARA QUE EL USUARIO VEA QUE PIEZA LE HA TOCADO
                    printearTablero(tablero);
                    //MUEVO SI QUIERO LA FICHA DE IZQUIERDA A DERECHA CON MI FUNCION moverFichaL2(tablero)
                    int posicion = moverFichaL2(tablero);
                    if (posicion != -1) //CUANDO HAYA DECIDIDO DONDE MOVER LA FICHA DEJO CAERLA CON LA FUNCION colocarCuadrado(tablero)
                    {
                        colocarL2(tablero, posicion);
                    } else {
                        ganar = true;
                    }
                }
                //CASO 4 LINEA
                case 4 -> {
                    tablero[4][1] = 1;
                    tablero[3][1] = 1;
                    tablero[2][1] = 1;
                    tablero[1][1] = 1;
                    //PRINTEO EL TABLERO PARA QUE EL USUARIO VEA QUE PIEZA LE HA TOCADO
                    printearTablero(tablero);
                    //MUEVO SI QUIERO LA FICHA DE IZQUIERDA A DERECHA CON MI FUNCION moverFichaLinea(tablero)
                    int posicion = moverFichaLinea(tablero);
                    if (posicion != -1) //CUANDO HAYA DECIDIDO DONDE MOVER LA FICHA DEJO CAERLA CON LA FUNCION colocarLinea(tablero)
                    {
                        colocarLinea(tablero, posicion);
                    } else {
                        ganar = true;
                    }
                }
            }
            //RESETEO LA PARTE DONDE SE PONEN LAS FICHAS PARA Y PRINTEO EL TABLERO
            tablero[4][1] = 0;
            tablero[4][2] = 0;
            tablero[3][2] = 0;
            tablero[3][1] = 0;
            tablero[2][2] = 0;
            tablero[2][1] = 0;
            boolean salir = false;
            int fila;
            //BUCLE WHILE QUE SALDRA CUANDO LA FILA SEA -1 QUE ES CUANDO  NO HAY FILAS LLENAS DE 1
            if (!ganar) {
                while (!salir) {
                    fila = verificarLineaLLena(tablero);
                    if (fila != -1) {
                        tablero = borrar(tablero, fila);
                    } else {
                        salir = true;
                    }
                }
                printearTablero(tablero);

                //VERIFICO SI HAY ALGUN 1 EN LA FILA 5
                if (perder(tablero)) {
                    ganar = true;
                    System.out.println("Lo siento. Has perdido.");
                } else {
                    System.out.println("Sigue jugando.");
                }
            }

        }

    }

    //FUNCION PARA RESETEAR LA PARTE DONDE SE PONEN LAS FICHAS DE LA FILA 0 A LA 5
    static int[][] resetear(int[][] tablero) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (i == 0 || j == 0 || i == 5 || j == tablero[0].length - 1) {
                    tablero[i][j] = 3;
                } else {
                    tablero[i][j] = 0;
                }
            }
        }
        return tablero;
    }

    //FUNCION QUE ME PERMITE MOVER DE IZQUIERDA A DERECHA LA FICHA L
    static int moverFichaL(int[][] tablero) {
        int posicion = 1;
        boolean salir = false;
        String movimiento;

        while (!salir) {

            System.out.print("Para mover izquierda[i], para mover derecha[d], para dejar caer la ficha[c] y para dejar la partida[s]: ");
            movimiento = s.next();
            resetear(tablero);

            switch (movimiento) {
                case "i", "I" -> {
                    if (posicion >= 2 && posicion < tablero[0].length - 1) {
                        posicion--;
                        tablero[4][posicion] = 1;
                        tablero[4][posicion + 1] = 1;
                        tablero[3][posicion + 1] = 1;
                        tablero[2][posicion + 1] = 1;
                        printearTablero(tablero);
                    } else {
                        System.out.println("No se puede crack");
                    }
                }
                case "d", "D" -> {
                    if (posicion < tablero[0].length - 3 && posicion > 0) {
                        posicion++;
                        tablero[4][posicion] = 1;
                        tablero[4][posicion + 1] = 1;
                        tablero[3][posicion + 1] = 1;
                        tablero[2][posicion + 1] = 1;
                        printearTablero(tablero);
                    } else {
                        System.out.println("No se puede crack");
                    }
                }
                case "c", "C" ->
                    salir = true;

                case "s", "S" -> {
                    salir = true;
                    posicion = -1;
                }

                default ->
                    System.out.println("Escribe 'i' o 'd'");
            }
        }
        return posicion;
    }

    //FUNCION QUE ME PERMITE MOVER DE IZQUIERDA A DERECHA LA FICHA CUADRADO
    static int moverFichaCuadrado(int[][] tablero) {
        int posicion = 1;
        boolean salir = false;
        String movimiento;

        while (!salir) {

            System.out.print("Para mover izquierda[i], para mover derecha[d], para dejar caer la ficha[c] y para dejar la partida[s]: ");
            movimiento = s.next();
            resetear(tablero);

            switch (movimiento) {
                case "i" -> {
                    if (posicion >= 2 && posicion < tablero[0].length - 1) {
                        posicion--;
                        tablero[4][posicion] = 1;
                        tablero[4][posicion + 1] = 1;
                        tablero[3][posicion] = 1;
                        tablero[3][posicion + 1] = 1;
                        printearTablero(tablero);
                    } else {
                        System.out.println("No se puede crack");
                    }
                }
                case "d" -> {
                    if (posicion < tablero[0].length - 3 && posicion > 0) {
                        posicion++;
                        tablero[4][posicion] = 1;
                        tablero[4][posicion + 1] = 1;
                        tablero[3][posicion] = 1;
                        tablero[3][posicion + 1] = 1;
                        printearTablero(tablero);
                    } else {
                        System.out.println("No se puede crack");
                    }
                }
                case "c", "C" ->
                    salir = true;

                case "s", "S" -> {
                    salir = true;
                    posicion = -1;
                }
                default ->
                    System.out.println("Escribe 'i' o 'd'");
            }
        }
        return posicion;
    }

    //FUNCION QUE ME PERMITE MOVER DE IZQUIERDA A DERECHA LA FICHA 2N L
    static int moverFichaL2(int[][] tablero) {
        int posicion = 1;
        boolean salir = false;
        String movimiento;

        while (!salir) {

            System.out.print("Para mover izquierda[i], para mover derecha[d], para dejar caer la ficha[c] y para dejar la partida[s]: ");
            movimiento = s.next();
            resetear(tablero);

            switch (movimiento) {
                case "i" -> {
                    if (posicion >= 2 && posicion < tablero[0].length - 1) {
                        posicion--;
                        tablero[4][posicion] = 1;
                        tablero[3][posicion] = 1;
                        tablero[4][posicion + 1] = 1;
                        tablero[4][posicion + 2] = 1;
                        printearTablero(tablero);
                    } else {
                        System.out.println("No se puede crack");
                    }
                }
                case "d" -> {
                    if (posicion < tablero[0].length - 4 && posicion > 0) {
                        posicion++;
                        tablero[4][posicion] = 1;
                        tablero[3][posicion] = 1;
                        tablero[4][posicion + 1] = 1;
                        tablero[4][posicion + 2] = 1;
                        printearTablero(tablero);
                    } else {
                        System.out.println("No se puede crack");
                    }
                }
                case "c", "C" ->
                    salir = true;

                case "s", "S" -> {
                    salir = true;
                    posicion = -1;
                }
                default ->
                    System.out.println("Escribe 'i' o 'd'");
            }
        }
        return posicion;
    }

    //FUNCION QUE ME PERMITE MOVER DE IZQUIERDA A DERECHA LA FICHA LINEA
    static int moverFichaLinea(int[][] tablero) {
        int posicion = 1;
        boolean salir = false;
        String movimiento;

        while (!salir) {

            System.out.print("Para mover izquierda[i], para mover derecha[d], para dejar caer la ficha[c] y para dejar la partida[s]: ");
            movimiento = s.next();
            resetear(tablero);

            switch (movimiento) {
                case "i" -> {
                    if (posicion >= 2 && posicion < tablero[0].length - 1) {
                        posicion--;
                        tablero[4][posicion] = 1;
                        tablero[3][posicion] = 1;
                        tablero[2][posicion] = 1;
                        tablero[1][posicion] = 1;
                        printearTablero(tablero);
                    } else {
                        System.out.println("No se puede crack");
                    }
                }
                case "d" -> {
                    if (posicion < tablero[0].length - 2 && posicion > 0) {
                        posicion++;
                        tablero[4][posicion] = 1;
                        tablero[3][posicion] = 1;
                        tablero[2][posicion] = 1;
                        tablero[1][posicion] = 1;
                        printearTablero(tablero);
                    } else {
                        System.out.println("No se puede crack");
                    }
                }
                case "c", "C" ->
                    salir = true;

                case "s", "S" -> {
                    salir = true;
                    posicion = -1;
                }
                default ->
                    System.out.println("Escribe 'i' o 'd'");
            }
        }
        return posicion;
    }

    //ESTA FUNCION INICIALIZA EL TABLERO GENERANDO LOS BORDER CON 3 Y EL RESTO CON 0 Y TAMBIEN SEPARA DONDE ESTA EL TABLERO Y DONDE
    //APARECEN LAS FICHAS
    static int[][] inicializarTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (i == 5 || j == 0 || i == tablero.length - 1 || j == tablero[0].length - 1 || i == 0) {
                    tablero[i][j] = 3;
                } else {
                    tablero[i][j] = 0;
                }
            }
        }
        return tablero;
    }

    //PRINTEO EL TABLERO
    static void printearTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == 3) {
                    System.out.print(ANSI_RED + tablero[i][j] + " " + ANSI_RESET);
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    //FUNCION QUE RECORRE LA LINEA 5 PARA VER SI HAY ALGUN 1 Y DEVOLVER SI HAY O NO HAY
    static boolean perder(int[][] tablero) {
        boolean result = false;
        boolean salir = false;
        int j = 0;
        while (!salir) {
            if (tablero[5][j] != 3) {
                salir = true;
                result = true;
            } else {
                if (j == tablero[0].length - 1) {
                    salir = true;
                } else {
                    j++;
                }
            }
        }

        return result;
    }

    //FUNCION PARA DEJAER CAER LA FICHA L
    static int[][] colocarL(int[][] tablero, int posicion) {
        boolean salir = false;
        int i = 6;

        while (!salir) {
            if (tablero[i][posicion] == 0 && tablero[i][posicion + 1] == 0) {
                i++;
            } else {
                salir = true;
                i--;
            }
        }
        tablero[i][posicion] = 1;
        tablero[i][posicion + 1] = 1;
        tablero[i - 1][posicion + 1] = 1;
        tablero[i - 2][posicion + 1] = 1;

        return tablero;
    }

    //FUNCION PARA DEJAER CAER LA FICHA CUADRADO
    static int[][] colocarCuadrado(int[][] tablero, int posicion) {
        boolean salir = false;
        int i = 6;
        while (!salir) {
            if (tablero[i][posicion] == 0 && tablero[i][posicion + 1] == 0) {
                i++;
            } else {
                salir = true;
                i--;
            }
        }
        tablero[i][posicion] = 1;
        tablero[i][posicion + 1] = 1;
        tablero[i - 1][posicion + 1] = 1;
        tablero[i - 1][posicion] = 1;

        return tablero;
    }

    //FUNCION PARA DEJAER CAER LA FICHA L 2
    static int[][] colocarL2(int[][] tablero, int posicion) {
        boolean salir = false;
        int i = 6;
        while (!salir) {
            if (tablero[i][posicion] == 0 && tablero[i][posicion + 1] == 0 && tablero[i][posicion + 2] == 0) {
                i++;
            } else {
                salir = true;
                i--;
            }
        }
        tablero[i][posicion] = 1;
        tablero[i][posicion + 1] = 1;
        tablero[i][posicion + 2] = 1;
        tablero[i - 1][posicion] = 1;

        return tablero;
    }

    //FUNCION PARA DEJAER CAER LA FICHA LINEA
    static int[][] colocarLinea(int[][] tablero, int posicion) {
        boolean salir = false;
        int i = 6;
        while (!salir) {
            if (tablero[i][posicion] == 0) {
                i++;
            } else {
                salir = true;
                i--;
            }
        }
        tablero[i][posicion] = 1;
        tablero[i - 1][posicion] = 1;
        tablero[i - 2][posicion] = 1;
        tablero[i - 3][posicion] = 1;

        return tablero;
    }

    //FUNCION QUE VERIFICA SI HAY ALGUNA FILA LLENA DE 1 DEVOLVERA -1 SI  O HAY Y SI HAY DEVOLVERA LA ULTIMA FILA QUE ESTE LLENA
    static int verificarLineaLLena(int[][] tablero) {
        int cont;
        int fila = -1;

        for (int i = 5; i < tablero.length; i++) {
            cont = 0;
            for (int j = 1; j < tablero[0].length - 1; j++) {
                if (tablero[i][j] == 1) {
                    cont++;
                }
            }
            if (cont == tablero[0].length - 2) {
                fila = i;
            }
        }

        return fila;
    }

    //FUNCION QUE BORRA UNA FILA Y BAJA EL RESTO
    static int[][] borrar(int[][] tablero, int fila) {

        for (int i = 1; i < tablero[0].length - 1; i++) {
            tablero[fila][i] = 0;
        }
        for (int i = fila; i > 5; i--) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i - 1][j] != 3) {
                    tablero[i][j] = tablero[i - 1][j];
                    tablero[i - 1][j] = 0;
                }
            }
        }
        return tablero;
    }

}
