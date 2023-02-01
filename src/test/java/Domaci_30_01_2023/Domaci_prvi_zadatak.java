package Domaci_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Domaci_prvi_zadatak {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
        WebElement selectElement = driver.findElement(By.id("delay-select"));
        Select select = new Select(selectElement);
        select.selectByValue("2000");
        new Actions(driver).scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();
        new Actions(driver).scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'C')]"))).perform();
        Thread.sleep(2000);
        new Actions(driver).scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("infinite-scroll-button")));
        driver.findElement(By.id("infinite-scroll-button")).click();
        new Actions(driver).scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("item"),8));
        driver.quit();


    }
}
