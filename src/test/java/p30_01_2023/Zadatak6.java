package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("https://tus.io/demo.html");
        List<WebElement> h = driver.findElements(By.tagName("h3"));
        for (int i = 0; i <h.size() ; i++) {
            new Actions(driver).scrollToElement(h.get(i)).perform();
            System.out.println(h.get(i).getText());
        }
        driver.quit();
    }
}
