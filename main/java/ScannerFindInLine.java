import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*
 * Example java source code on the usage of findInLine(String pattern) method
 * of Scanner class to find a specific pattern on the scanner buffer
 */

public class ScannerFindInLine {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\Maor\\Desktop\\TransferApp\\TransferApp.txt");
        // initialize the scanner
        Scanner scan = new Scanner(file);

        // iterate through the file line by line
        while(scan.hasNextLine()){
            // scan for names on the content of the file

            // Example:

            String str = scan.findInLine(".*(error|Error|Exception).*");
           //assertFalse(str.matches(".*(FamilyID|ModelAutoPK|Family|Model|VID|Model_GMM|Info_ATI3).*"));

            if(str != null){
                // print the string content that satisfies the pattern
                // specified on the method argument
                System.out.println(str);
             //   assertTrue(str.matches(".*(error|Error).*"));


              //  assertEquals("failure - strings are not equal", str, "FamilyID" );
            }
            // advance to the next line
            scan.nextLine();
        }
        // close the scanner object;
        scan.close();

    }
}