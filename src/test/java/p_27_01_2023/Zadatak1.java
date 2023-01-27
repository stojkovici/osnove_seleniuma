package p_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/modal-dialogs");
        driver.findElement(By.id("showLargeModal")).click();
        boolean vidljiv = true;
        try{
            driver.findElement(By.xpath("//*[@class='modal-body']/p"));
        }
        catch (NoSuchElementException error){
            vidljiv=false;
        }
        if (vidljiv){
            System.out.println("Vidi se");
        }
        else {
            System.out.println("Ne vidi se");
        }
        driver.quit();
    }

}
