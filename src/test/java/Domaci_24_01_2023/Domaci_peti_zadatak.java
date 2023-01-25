package Domaci_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Domaci_peti_zadatak {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://artplayer.org/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@class='art-icon art-icon-play hint--rounded hint--top']")).click();
        driver.findElement(By.xpath("//i[@class='art-icon art-icon-volume hint--rounded hint--top']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@class='art-icon art-icon-screenshot']")).click();
        driver.findElement(By.xpath("//i[@class='art-icon art-icon-pip']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[@class='art-icon art-icon-pip']")).click();
        driver.findElement(By.xpath("//i[@class='art-icon art-icon-fullscreenOn']")).click();
        driver.findElement(By.xpath("//i[@class='art-icon art-icon-fullscreenOff']")).click();
        Thread.sleep(5000);
        driver.quit();

    }
}
