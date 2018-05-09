// ValidateTxtFile

import java.io.*;

public class ValidateTxtFile {

    private final int MAX_LINES_TO_READ = 10;

    private final String REGEX = (".*[_A-Za-z0-9-]");

    public void testFile(String fileName) {

        int lineCounter = 1;

        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line = br.readLine();

            while ((line != null) && (lineCounter <= MAX_LINES_TO_READ)) {

                // Validate the line is formatted correctly based on regular expressions
                if (line.matches(REGEX)) {
                    System.out.println("Line " + lineCounter + " formatted correctly");
                }
                else {
                    System.out.println("Invalid format on line " + lineCounter + " (" + line + ")");
                }

                line = br.readLine();
                lineCounter++;
            }

        } catch (Exception ex) {
            System.out.println("Exception occurred: " + ex.toString());
        }
    }

    public static void main(String args[]) {

        ValidateTxtFile vtf = new ValidateTxtFile();

        vtf.testFile("C:\\Users\\Maor\\Desktop\\Phone Support\\DetectExample.txt");
    }
}