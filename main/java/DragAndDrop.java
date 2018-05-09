import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

    public static WebDriver driver;

    public static void main(String[] args) {

        // chromedriver server path
        String exePath = "C:\\Appium Jars and Drivers\\Selenium\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        // Instantiate a ChromeDriver class
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://store.demoqa.com/products-page/");

        WebElement element = driver.findElement(By.linkText("Product Category"));

        Actions action = new Actions(driver);

        action.moveToElement(element).perform();

        WebElement subElement = driver.findElement(By.linkText("iPads"));

        action.moveToElement(subElement);

        action.click();

        action.perform();

    }

}