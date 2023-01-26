package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/z80en");
        List<WebElement> niz = driver.findElements(By.xpath("//div[@class='tab-pane fade show active']/table[@class='table table-bordered']/tbody/tr[1]"));
        for (int i = 0; i <niz.size() ; i++) {
           List<WebElement>niz1 = niz.get(i).findElements(By.xpath("//td"));
            for (int j = 0; j <niz1.size() ; j++) {
                System.out.println(niz1.get(j).getText());
            }
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
