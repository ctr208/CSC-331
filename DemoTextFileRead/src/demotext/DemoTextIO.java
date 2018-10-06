package demotext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoTextIO {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter file name: ");
        String filename = s.next();

        ArrayList<String> lines = new ArrayList<>();

        lines = readData("Resources/"+filename);
        
        int counter = 0;
        for(String ln: lines) {
            System.out.println("Line "+ (++counter) + ". " + ln);
            Scanner lineScanner = new Scanner(ln);
            lineScanner.useDelimiter(";");
            String w1 = lineScanner.next();
            String w2 = lineScanner.next();
            String w3 = lineScanner.next();
            System.out.println("\t"+w1 + w2 + w3);
        }

    }

    private static ArrayList<String> readData(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        Scanner s = null;
        File infile = new File(filename);
        try {
            s = new Scanner(infile, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNext()) 
            lines.add(s.nextLine());

        return lines;
    }

}
