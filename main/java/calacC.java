

// "C:\\Program Files (x86)\\FreeStopwatch\\FreeStopwatch.exe"
// driver.findElementById("132942").click();

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;

/**
 Created by Maor S on 14/11/2017.
 Winium.Desktop overview -> https://github.com/2gis/Winium.Desktop
 List of supported commands -> https://github.com/2gis/Winium.Desktop/wiki/Supported-Commands
 Youtube guide -> https://www.youtube.com/watch?v=juRKu9cBwQ0&t=10s
 to inspect elements use -> https://msdn.microsoft.com/en-us/library/windows/desktop/dd318521(v=vs.85).aspx
 */

public class calacC {

    @Test
    public void Notepad() throws IOException {

        DesktopOptions options = new DesktopOptions();
        // The absolute local path to an .exe file to be started
        options.setApplicationPath("C:\\Program Files (x86)\\FreeStopwatch\\FreeStopwatch.exe");
        WiniumDriver driver = null;
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        try {
            //
            driver = new WiniumDriver(new URL("http://localhost:9999"), options);


            driver.findElementById("132942").click();

            // Takes Screenshot of the screen
            File scrFile = driver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Maor\\Desktop\\test.png"));

            // Close the associated application
            driver.quit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}



