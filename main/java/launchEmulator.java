

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maor on 21/10/2017.
 */

public class launchEmulator {

    private static String sdkPath = "C:\\Users\\Maor\\AppData\\Local\\Android\\sdk";// or for windows D:/Android/adt-bundle-windows-x86_64-20140702/sdk/
    private static String adbPath = sdkPath + "platform-tools" + File.separator + "adb";
    private static String emulatorPath = sdkPath + File.separator + "" + "emulator";
    private  static String nameOfAVD;

    public static void main(String nameOfAVD) {
    //public static void launchEmulator() {
        System.out.println("Starting emulator for '" + nameOfAVD + "' ...");
        String[] aCommand = new String[]{emulatorPath, "emulator - avd Pixel_XL_API_25", nameOfAVD};
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.wait(4000);
            System.out.println("Emulator launched successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}