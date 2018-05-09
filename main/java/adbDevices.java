import java.io.IOException;

public class adbDevices {

    public static void main(String[] args) throws IOException, InterruptedException {

        String cmd = "adb push C:\\Users\\Maor\\Desktop\\TransferApp\\MM-Test-Pack\\Audio /sdcard";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
        System.out.println("Push completed");

        }
    }
