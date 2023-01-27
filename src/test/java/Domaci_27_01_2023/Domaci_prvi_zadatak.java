package Domaci_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Domaci_prvi_zadatak {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.findElement(By.xpath("//button[contains(text(),'Primary')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Secondary')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Success')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Danger')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Warning')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Info')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Light')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Dark')]")).click();
        Thread.sleep(1000);
        boolean toasts = true;
        try{
          driver.findElement(By.xpath("//div[contains(@class, 'toast fade mx-auto toast')]"));
        }
        catch (NoSuchElementException error){
            toasts=false;
        }
        if (toasts){
            System.out.println("Sve ok");
        }
        else{
            System.out.println("Ne pojavljuje se");
        }
        driver.quit();
    }
}
