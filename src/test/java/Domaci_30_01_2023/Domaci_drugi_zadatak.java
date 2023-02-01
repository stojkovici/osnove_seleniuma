package Domaci_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://docs.katalon.com/");
        String dataTheme=driver.findElement(By.xpath("/html")).getAttribute("data-theme");
        if (dataTheme.equals("light")){
            System.out.println("Tema je light");
        }
        else {
            System.out.println("Tema je dark");
        }
        driver.findElement(By.xpath("//button[@class='clean-btn toggleButton_rCf9']")).click();
        String dataThemeD=driver.findElement(By.xpath("/html")).getAttribute("data-theme");
        if (dataThemeD.equals("dark")){
            System.out.println("Tema je dark");
        }
        else {
            System.out.println("Tema je light");
        }
        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("k").keyUp(Keys.CONTROL).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@class='DocSearch-SearchBar']")));
        String type = driver.findElement(By.xpath("//*[@class='DocSearch-Input']")).getAttribute("type");
        if (type.equals("search")){
            System.out.println("Type is search");
        }
        else {
            System.out.println("Type is not search");
        }
        driver.quit();
    }
}
