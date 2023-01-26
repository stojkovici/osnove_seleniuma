package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://cms.demo.katalon.com/my-account/");
        WebElement checkbox = driver.findElement(By.id("rememberme"));
        checkbox.click();
        boolean isChecked = checkbox.isSelected();
        if (isChecked==true){
            System.out.println("Jeste");
        }
        else {
            System.out.println("Nije");
        }
        driver.quit();

    }
}
