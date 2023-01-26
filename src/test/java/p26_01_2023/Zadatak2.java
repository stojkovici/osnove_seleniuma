package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/z80en");
        List<WebElement> niz = driver.findElements(By.xpath("//div[@class='tab-pane fade show active']/table/tbody/tr/td[1]"));
        Thread.sleep(1000);
        for (int i = 0; i < niz.size(); i++) {
            System.out.println(niz.get(i).getText());
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
