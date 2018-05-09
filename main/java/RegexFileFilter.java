// RegexFileFilter

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class A {
    public static void main(String[] args) throws Exception
    {
        //  directory path
        Path dir = Paths.get("C:\\Users\\Maor\\Desktop\\Phone Support");

        /**
         *
         * Create a new DirectoryStream for the above path.
         *
         * List all files within this directory that begin
         * with the letters A or B i.e "[AB)]*"
         *
         */
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "[__]"))
        {
            // Print all the files to output stream
            for(Path p: stream)
            {
                System.out.println(p.getFileName());
            }
        }
        catch(Exception e)
        {
            System.out.println("problems locating directory");
        }
    }
}