package practica.uf3.pkg1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ex1 {

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
        pw.println(cadena);
        pw.flush();

        writer.close();
    }

}
