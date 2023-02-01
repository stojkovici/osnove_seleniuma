package Domaci_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Domaci_drugi_zadatak {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://itbootcamp.rs/");
        WebElement vesti = driver.findElement(By.xpath("//li[@id='menu-item-6408']"));
        new Actions(driver).moveToElement(vesti).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-item-6408']/ul[@role='menu']")));
        WebElement kursevi = driver.findElement(By.xpath("//li[@id='menu-item-5362']"));
        new Actions(driver).moveToElement(kursevi).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-item-5362']/ul[@role='menu']")));
        WebElement prijava = driver.findElement(By.xpath("//li[@id='menu-item-5453']"));
        new Actions(driver).moveToElement(prijava).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-item-5453']/ul[@role='menu']")));
        driver.quit();
    }
}
