package Domaci_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.ArrayList;

public class Domaci_drugi_zadatak {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ArrayList<String> niz = new ArrayList<>();
        niz.add("Visit Paris");
        niz.add("Visit Prague");
        niz.add("Visit London");
        niz.add("Visit New York");
        niz.add("Visit Belgrade");
        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");
        for (int i = 0; i <niz.size() ; i++) {
            driver.findElement(By.className("new-todo")).sendKeys(niz.get(i));
            driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
