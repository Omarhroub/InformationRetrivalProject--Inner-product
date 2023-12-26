import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        InnerProductCalculator doc = new InnerProductCalculator();
//        doc.insertDocuments();
//        doc.insertQuery();
//        doc.innerProductFunction();

        InnerProductCalculator ex = new InnerProductCalculator();
        ex.insertFromFile();
        ex.printDocuments();
        ex.insertQuery();
        ex.innerProductFunction();
        System.out.println("Press 'Enter' key to exit.");
        new Scanner(System.in).nextLine();


    }
}
