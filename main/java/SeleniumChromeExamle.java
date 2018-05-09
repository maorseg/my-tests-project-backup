import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Maor on 15/11/2017.
 */

public class SeleniumChromeExamle {
    // Instantiate a ChromeDriver class
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void SetUp() throws InterruptedException, IOException {
        // Setting the webdriver.chrome.driver property to its executable's location
        String exePath = "C:\\Appium Jars and Drivers\\Selenium\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",exePath);
}

@Test
public void DemoSite() throws InterruptedException, IOException {

        // Sets the amount of time to wait for a page load to complete before throwing an error
        driver.manage().timeouts().pageLoadTimeout(60, SECONDS);

        // Storing the Application Url in the String variable
        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("search")).sendKeys("mini inline vertical crossbow");


//
//        // Takes Screenshot
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("C:\\Users\\Maor\\Desktop\\Screenshot.png"));

        ///////////////////////////////////////////////////////////////////////

        //Thread.sleep just for user to notice the event
        Thread.sleep(3000);

        // Than Close the browser
        driver.quit();
    }
}


