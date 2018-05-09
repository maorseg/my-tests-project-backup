// https://www.tutorialspoint.com/javaexamples/dir_search_file.htm
import java.io.*;

public class FileFinder1 {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Maor\\Desktop\\Phone Support\\");
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept (File dir, String name) {
             //   return name.contains("NO_PIC");
   return name.endsWith("xml");

            }
        };
        String[] children = dir.list(filter);
        if (children == null) {
            System.out.println("Either dir does not exist or is not a directory");
        } else {
            for (int i=0; i< children.length; i++) {
                String filename = children[i];
                System.out.println(filename);
            }
        }
    }
}