import java.io.IOException;

public class RunBatchFile {
    public static void main(String[] args) throws IOException {

        String cmd = "cmd.exe /c start ";
        String file = "c:\\Users\\Maor\\Desktop\\runner\\run.bat";
        //String file = "http://www.google.com";
        // String file = "mailto:author@my.com";
        Runtime.getRuntime().exec(cmd + file);
    }

}