
package practica.uf3.pkg1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*2. Amplia el programa anterior per tal que:
a) Si el fitxer no existeix, que el generi.
b) Si el fitxer ja existeix, que afegeixi el contingut al final.
c) Si l’usuari escriu @ESBORRA, cal esborrar el contingut del fitxer.
*/

public class ex2 {
    
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
