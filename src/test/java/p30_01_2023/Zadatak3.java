package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.findElement(By.xpath("//button[@id='basic-primary-trigger']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Primary Basic Example')]")));
        String txt = driver.findElement(By.xpath("//div[contains(text(),'Primary Basic Example')]")).getText();
        System.out.println(txt);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Primary Basic Example')]")));
        System.out.println("Element se izgubio");
        driver.findElement(By.xpath("//button[@id='basic-primary-trigger']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Primary Basic Example')]")));
        System.out.println("Element se pojavio");
        driver.findElement(By.xpath("//div[@class='toast-header toast-primary']/button")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Primary Basic Example')]")));
        System.out.println("Element se izgubio");
        driver.quit();
    }
}
