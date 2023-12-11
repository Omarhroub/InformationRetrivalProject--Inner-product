import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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



    }
}
