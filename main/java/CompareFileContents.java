import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CompareFileContents {

    public static void main(String[] args) throws IOException {

        File file1 = new File("C:\\Users\\Maor\\Desktop\\Phone Support\\__Oppo1.xml");
        File file2 = new File("C:\\Users\\Maor\\Desktop\\Phone Support\\__Oppo2.xml");

        boolean compare1and2 = FileUtils.contentEquals(file1, file2);

        System.out.println("Are both files are the same? " + compare1and2);


    }

}