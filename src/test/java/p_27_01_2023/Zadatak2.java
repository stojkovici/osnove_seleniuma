package p_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Gebruiker/Downloads/Zadatak4.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        for (int i = 0; i <5 ; i++) {
            driver.findElement(By.id("showInBtn")).click();
            try{
                driver.findElement(By.id("id-"+i));
            }
            catch (NoSuchElementException error){

            }
        }
        driver.quit();
    }
}
