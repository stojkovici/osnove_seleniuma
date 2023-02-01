package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://youtube.com");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("kendrick lamar");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(" ");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//li[@role='presentation']"),3));
        driver.quit();

    }
}
