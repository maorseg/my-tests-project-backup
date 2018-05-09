import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadWithScanner {

    public static void main(String... aArgs) throws IOException {
        ReadWithScanner parser = new ReadWithScanner("C:\\Users\\Maor\\Desktop\\Phone Support\\DetectRules.txt");
        parser.processLineByLine();
       // log("\n"+ "END OF FILE");
    }

    /**
     Constructor.
     @param aFileName full name of an existing, readable file.
     */
    public ReadWithScanner(String aFileName){
        fFilePath = Paths.get(aFileName);
    }


    /** Template method that calls {@link #processLine(String)}.  */
    public final void processLineByLine() throws IOException {
        try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){
            while (scanner.hasNextLine()){
                processLine(scanner.nextLine());
            }
        }
    }

    /**

     Expects simple name-value pairs, separated by an
     ':' sign.In case there is no valid  name-value pair separated by an
     ':' sign return an error

     Examples of valid input:

     FamilyID            : 40
     ModelAutoPK         : 2139
     Family              : "Apple"
     Model               : "iPhone 8"
     VID                 : 0x05AC
     Model_GMM           : "8015"
     Info_ATI3           : "0A"
     */

    protected void processLine(String aLine){
        //use a second Scanner to parse the content of each line
        Scanner scanner = new Scanner(aLine);
        scanner.useDelimiter(":");
        if (scanner.hasNext()){
            //assumes the line has a certain structure
            String name = scanner.next();
            String value = scanner.next();
            log("" + quote(name.trim()) + ": " + quote(value.trim()));
        }


        else {
                log("");

            }
        }

    // PRIVATE
    private final Path fFilePath;
    private final static Charset ENCODING = StandardCharsets.UTF_8;
    private static void log(Object aObject){
        System.out.println(String.valueOf(aObject));
    }

    private String quote(String aText){
        String QUOTE = "";
        return QUOTE + aText + QUOTE;
    }
} 