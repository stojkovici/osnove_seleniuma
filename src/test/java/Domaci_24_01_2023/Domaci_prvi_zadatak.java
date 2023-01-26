package Domaci_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Domaci_prvi_zadatak {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//form[@class='oxd-form']/div/div[1]/div[2]/input")).sendKeys("Admin");
        driver.findElement(By.xpath("//form[@class='oxd-form']/div[2]/div/div[2]/input")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Me");
        driver.findElement(By.xpath("//*[@href='/web/index.php/time/viewTimeModule']")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("oxd-userdropdown-img")).click();
        driver.findElement(By.xpath("//*[@href='/web/index.php/auth/logout']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
