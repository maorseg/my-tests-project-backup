/**
 * Created by Maor on 16/03/2018
 * Set the Desired Capabilities for Android device for the Appium Server
 */

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class DesiredCapabilitiesSetUp {
    AndroidDriver driver;
    DesiredCapabilities caps = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws Exception {

        caps.setCapability("no-reset", "true");
        caps.setCapability("full-reset", "False");
        caps.setCapability("deviceName", "G Flex");
        caps.setCapability("udid", "06cddb839b162851");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "4.4.2");
        caps.setCapability("appPackage", "com.cellebrite.testdiagnosticslibrary");
        caps.setCapability("appActivity", "com.cellebrite.testdiagnosticslibrary.newApp.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void testUntitled() {
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

