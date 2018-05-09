// "C:\\Users\\Maor\\Desktop\\Phone Support\\DetectRules.txt";

// Need the input/output package when handling files.
import java.io.*;

public class ReadFile {
    public static void main(String args[]) {

        // Check to see if they supplied the search phrase as a parameter.
        // If so, set our searchword from the parameter passed and begin searching.
        if (args.length > 0) {

            // Set the searchword to our parameter
            // (eg if they type 'java searchfile "hello"' then the search word would be "hello")
            String searchword = args[0];

            try {

                // Keep track of the line we are on and what the line is.
                int LineCount = 0;
                String line = "";


                // Create a reader which reads our file. In this example searchfile.txt is the file we are searching.
                BufferedReader bReader = new BufferedReader(new FileReader("C:\\\\Users\\\\Maor\\\\Desktop\\\\Phone Support\\\\DetectRules.txt"));


                // While we loop through the file, read each line until there is nothing left to read.
                // This assumes we have carriage returns ending each text line.

                while ((line = bReader.readLine()) != null) {
                    LineCount++;

                    // See if the searchword is in this line, if it is, it will return a position.
                    int posFound = line.indexOf(searchword);


                    // If we found the word, print the position and our current line.
                    if (posFound > - 1) {
                        System.out.println("Search word found at position " + posFound + " on line " + LineCount);
                    }
                }


                // Close the reader.
                bReader.close();

            }
            catch (IOException e) {
                // We encountered an error with the file, print it to the user.
                System.out.println("Error: " + e.toString());
            }
        }
        else {
            // They obviosly didn't provide a search term when starting the program.
            System.out.println("Please provide a word to search the file for.");
        }
    }
}