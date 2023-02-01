package Domaci_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Domaci_prvi_zadatak {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        driver.findElement(By.xpath("//div[@id='active-face']")).click();
        driver.findElement(By.xpath("//div[@id='image-option-remove']")).click();
        driver.findElement(By.xpath("//div[@id='active-face']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-dEVLtI cdUMZB']")));
        String front =new File("domaci_31_01/front.jpg").getAbsolutePath();
        driver.findElement(By.xpath("//input[@id='imageUpload']")).sendKeys(front);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='sc-dIfARi usMKB']/div"),1));
        driver.findElement(By.xpath("//div[@class='sc-cwSeag eYPezj']/img")).click();
        driver.findElement(By.xpath("//button[@class='sc-eDWCr kmMZjW']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='active-face']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-dEVLtI cdUMZB']")));
        String right = new File ("domaci_31_01/right.jpg").getAbsolutePath();
        driver.findElement(By.xpath("//input[@id='imageUpload']")).sendKeys(right);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='sc-dIfARi usMKB']/div"),2));
        driver.findElement(By.xpath("//div[@class='sc-dIfARi usMKB']/div[1]/div/img")).click();
        driver.findElement(By.xpath("//button[@class='sc-eDWCr kmMZjW']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='active-face']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-dEVLtI cdUMZB']")));
        String left = new File("domaci_31_01/left.jpg").getAbsolutePath();
        driver.findElement(By.xpath("//input[@id='imageUpload']")).sendKeys(left);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='sc-dIfARi usMKB']/div"),3));
        driver.findElement(By.xpath("//div[@class='sc-dIfARi usMKB']/div[1]/div/img")).click();
        driver.findElement(By.xpath("//button[@class='sc-eDWCr kmMZjW']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='active-face']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-dEVLtI cdUMZB']")));
        String back = new File("domaci_31_01/back.jpg").getAbsolutePath();
        driver.findElement(By.xpath("//input[@id='imageUpload']")).sendKeys(back);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='sc-dIfARi usMKB']/div"),4));
        driver.findElement(By.xpath("//div[@class='sc-dIfARi usMKB']/div[1]/div/img")).click();
        driver.findElement(By.xpath("//button[@class='sc-eDWCr kmMZjW']")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='next-button']")));
        driver.findElement(By.xpath("//button[@id='next-button']")).click();
        driver.findElement(By.xpath("//textarea")).sendKeys("Four of my favorite albums");
        driver.findElement(By.xpath("//button[@id='next-button']")).click();
        driver.findElement(By.xpath("//button[@id='next-button']")).click();
        driver.findElement(By.xpath("//button[@id='next-button']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
