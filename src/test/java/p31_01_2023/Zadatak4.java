package p31_01_2023;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://cms.demo.katalon.com/");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File folder = new File("C:\\Users\\Gebruiker\\Desktop\\github\\osnove_seleniuma\\screenshots");
        folder.mkdir();
        FileHandler.copy(screenshot,new File(folder,"screenshot1.jpg"));
        driver.quit();
    }
}
