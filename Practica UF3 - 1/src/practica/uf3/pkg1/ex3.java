package practica.uf3.pkg1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static utils.Utils.*;

public class ex3 {

    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        File f = new File("C:\\ficheros/textos.txt");
        boolean existe = false;

        if (!f.exists()) {
            f.createNewFile();
            existe = true;
        }

        FileWriter writer = new FileWriter(f, true);
        PrintWriter pw = new PrintWriter(writer);

        String cadena;

        cadena = s.nextLine();

        if (cadena.equals("@ESBORRAR")) {
            pw.flush();
            writer.close();
            f.delete();
        } else {
            pw.println(cadena);
        }
        pw.flush();

        writer.close();

        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("1. Leer fichero\n2. Mostrar x linea\n3. Insertar una linea al comencament del fitxer\n");
            opcion = demanarEnter("Introduce tu opcion: ");
            switch (opcion) {
                case 1 -> {
                    FileReader reader = new FileReader(f);
                    BufferedReader buffer = new BufferedReader(reader);

                    String linea = buffer.readLine();
                    while (linea != null) {
                        System.out.println(linea);
                        linea = buffer.readLine();
                    }
                    buffer.close();
                    reader.close();
                }
                case 2 -> {
                    int numLinea = demanarEnter("Que linea quieres leer? ");
                    FileReader reader = new FileReader(f);
                    BufferedReader buffer = new BufferedReader(reader);
                    System.out.println("Tiene " + buffer.lines().count() + " lineas");
                    String[] lineasFichero = new String[10];
                    String linea = buffer.readLine();
                    int i = 0;
                    
                    while(linea != null){
                        lineasFichero[i] = linea;
                        System.out.println(lineasFichero[i]);
                        i++;
                        linea = buffer.readLine();
                    }
                    buffer.close();
                    reader.close();
                    
                    System.out.println("La linea pone: " + lineasFichero[numLinea]);
                }
            }

        }
    }

}
