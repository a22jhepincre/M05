package practica.uf3.pkg1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ex3 {

    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        File f = new File("C:\\ficheros/textos.txt");
        if (!f.exists()) {
            f.createNewFile();
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
        
        FileReader reader = new FileReader(f);
        BufferedReader buffer = new BufferedReader(reader);
        
        String linea = buffer.readLine();
        while(linea != null){
            System.out.println(linea);
            linea = buffer.readLine();
        }
    }

}
