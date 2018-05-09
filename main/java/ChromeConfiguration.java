/**
 * Created by Maor on 25/03/2018.
 */

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeConfiguration {

    public static void main(String [] args) throws InterruptedException{

        ExcelConfiguration excel = new ExcelConfiguration("C:\\Users\\Maor\\Desktop\\data driven\\Testdata.xlsx");

        String exePath = "C:\\Appium Jars and Drivers\\Selenium\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",exePath);
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        driver.get("https://www.facebook.com/");


        List<List<String>> data1 = excel.getList();
        for (List<String> credentials : data1) {
            WebElement hello = driver.findElement(By.id("email"));
            hello.sendKeys(credentials.get(0));


            WebElement hello1 = driver.findElement(By.id("password"));
            hello1.sendKeys(credentials.get(1));


            driver.findElement(By.xpath("//*[@id='loginbutton']")).click();

            Thread.sleep(5000);

            driver.findElement(By.id("userNavigationLabel")).click();
            driver.findElement(By.xpath("//li[12]/a/span/span")).click();

            Thread.sleep(5000);

        }
    }
}


