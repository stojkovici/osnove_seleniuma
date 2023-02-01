package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.devtools.v106.network.model.Request;
import org.openqa.selenium.devtools.v106.network.model.Response;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://cms.demo.katalon.com/");
        List<WebElement> href = driver.findElements(By.xpath("//ul[@class=' nav-menu']/li"));
        for (int i = 0; i <href.size() ; i++) {
            String a = href.get(i).getAttribute("href");

        }
    }

}
