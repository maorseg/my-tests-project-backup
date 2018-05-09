/**
 * Created by Maor on 16/03/2018
 * Appium example with TestNG framework
 */

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import javax.imageio.ImageIO;

public class AndroidAppiumExample {
    AndroidDriver driver;
    DesiredCapabilities caps = new DesiredCapabilities();

    // Set the Desired Capabilities for Android device for the Appium Server
    @BeforeMethod
    public void setUp() throws Exception {

        caps.setCapability("no-reset", "true");
        caps.setCapability("full-reset", "False");
        caps.setCapability("deviceName", "G Flex");
        caps.setCapability("udid", "06cddb839b162851");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "4.4.2");
        caps.setCapability("appPackage", "com.cellebrite.testdiagnosticslibrary");
        caps.setCapability("appActivity", ".newApp.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    // Test Device Category
    public void Device() {

        // findElement(By.xpath) and takeScreenShot for the JSON result
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[5]\n")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView")).click();
        driver.findElement(By.id("android:id/alertTitle"));

        // Check if test finished with JSON's result or with an error
        String result = driver.findElement(By.id("android:id/alertTitle")).getText();
        assert result.equals("Test Finished") : "Test Finished did not match with Actual test result: " + result;

        // Print the JSON's test results
        String result2 = driver.findElement(By.id("android:id/message")).getText();
        System.out.println(result2);

        // Go back to main  app categories screen
        driver.findElement(By.id("android:id/button1")).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);

    }

    @Test
    // Take screenshot with the Robot class
    public void TakeScreenshot() {
        try {
            // Create a Robot object:
            Robot robot = new Robot();
            // PNG format
            String format = "png";
            // Path to the png taken
            String fileName = "C:\\Users\\Maor\\Desktop\\Screenshots" + format;

            //Creating screenshot requires Rectangle (java.awt.Rectangle)
            // object as an argument, as this is the specified area, from where the screenshot is taken.
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            //The result is BufferedImage (java.awt.image.BufferedImage) which can then
            // be handeled properly (analyzed, saved or whatever needs to be done).
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(fileName));

            System.out.println("Test result screenshot saved!");
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
    }
        @AfterMethod
        public void tearDown () {
            driver.quit();
        }
    }



