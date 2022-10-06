package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class yaziYazma {

    public static void main(String[] args) {

        FileWriter fw= null;
        String path="src/test/java/urunDetaylari";
        try {
            fw = new FileWriter(path);
            PrintWriter  pw=new PrintWriter(fw);
            pw.println("ahmet");
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
