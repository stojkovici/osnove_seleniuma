package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.findElement(By.xpath("//button[@id='basic-primary-trigger']")).click();
        driver.findElement(By.xpath("//button[@id='basic-secondary-trigger']")).click();
        driver.findElement(By.xpath("//button[@id='basic-success-trigger']")).click();
        driver.findElement(By.xpath("//button[@id='basic-danger-trigger']")).click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[contains(@class,'toast fade mx-auto toast-')]"),4));
        System.out.println("Toasts su prikazani");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'toast fade mx-auto toast-')]")));
        System.out.println("Toasts su se izgubili");
        driver.quit();
    }
}
