
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.apache.commons.io.filefilter.RegexFileFilter;

public class RegexFileFilterTest {

    public static void main(String[] args) throws IOException {
        File directory = new File(".");

        File[] files = directory.listFiles();
        //System.out.println("All files and directories:");
        //displayFiles(files);

        String pattern = "[tT]est[1-3].txt";
        System.out.println("\nFiles that match regular expression: " + pattern);
        FileFilter filter = new RegexFileFilter(pattern);
        files = directory.listFiles(filter);
        displayFiles(files);

    }

    public static void displayFiles(File[] files) {
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

}