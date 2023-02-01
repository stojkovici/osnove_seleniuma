package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        String path = new File("test_data/Mac_Miller_-_The_Divine_Feminine.png").getAbsolutePath();
        driver.findElement(By.xpath("//input[@name='files[]']")).sendKeys(path);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr")));
        driver.findElement(By.xpath("//tbody/tr/td/button[@class='btn btn-primary start']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td/button[@class='btn btn-danger delete']")));
        driver.findElement(By.xpath("//tbody/tr/td/button[@class='btn btn-danger delete']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//tr[@class='template-download fade image in']")));
        driver.quit();


    }
}
