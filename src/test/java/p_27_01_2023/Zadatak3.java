package p_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");
        driver.findElement(By.id("type-options")).click();
    //    Select select = new Select(selectElement);
     //   select.selectByVisibleText("Public");
        driver.findElement(By.xpath("//*[@class='SelectMenu-item'][2]")).click();
        boolean vidljiv = true;
        try {
            driver.findElement(By.xpath("//*[contains(@class,'issues-reset-query te')]"));
        }
        catch (NoSuchElementException error){
            vidljiv=false;
        }
        if (vidljiv){
            driver.findElement(By.xpath("//*[contains(@class,'issues-reset-query te')]")).click();
            System.out.println("Vidi se");
        }
        else {
            System.out.println("Ne vidi se");
        }
        driver.quit();
    }
}
