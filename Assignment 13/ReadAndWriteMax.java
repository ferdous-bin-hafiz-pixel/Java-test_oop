import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadAndWriteMax {

    public static void main(String[] args) {

        try {
   
            File inputFile = new File("Input.txt");
            Scanner sc = new Scanner(inputFile);
            sc.useDelimiter(","); 

            int max = Integer.MIN_VALUE; 

            
            while (sc.hasNext()) {
                String value = sc.next().trim(); 
                if (!value.isEmpty()) {
                    int num = Integer.parseInt(value);
                    if (num > max) {
                        max = num;
                    }
                }
            }
            sc.close();

            
            PrintWriter pw = new PrintWriter("Output.txt");
            pw.println(max);
            pw.close();

            System.out.println("Maximum value written to Output.txt successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
