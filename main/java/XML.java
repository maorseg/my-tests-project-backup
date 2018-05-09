import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

public class XML {
    public static void main(String[] args) throws Exception {
        File root = new File("C:\\Users\\Maor\\Desktop\\Demo_3");

        String[] extensions = { "jpg" };
        boolean recursive = true;

        Collection files = FileUtils.listFiles(root, extensions, recursive);

        for (Iterator iterator = files.iterator(); iterator.hasNext();) {
            File file = (File) iterator.next();
            System.out.println("File = " + file.getAbsolutePath());
        }
    }
}