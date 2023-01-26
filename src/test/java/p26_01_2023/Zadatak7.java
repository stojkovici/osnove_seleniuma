package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak7 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://netoglasi.rs/");
        List<WebElement> niz = driver.findElements(By.xpath("//*[@class='category-list category-list-dark md list-md hydrated']"));
        for (int i = 0; i <niz.size() ; i++) {
            System.out.println(niz.get(i).getText());
        }
        WebElement auto = driver.findElement(By.xpath("//b[contains(text(),'Automobili')]"));
        Point location = auto.getLocation();
        int x = location.getX();
        int y = location.getY();
        if (x == 38 && y == 189) {
            System.out.println("The element is in the first place");
            System.out.println(""+x+y);
        } else {
            System.out.println("The element is not in the first place");
        }
        System.out.println(""+x+","+y);
        auto.click();
        List<WebElement> niz1 = driver.findElements(By.xpath("//*[@class='ion-hide-xl-down']/ion-list/div"));
        WebElement auto1 = driver.findElement(By.xpath("//*[@class='ion-hide-xl-down']/ion-item/a"));
        Point lokacija = auto1.getLocation();
        int a = lokacija.getX();
        int b = lokacija.getY();
        if (a == 38 && b == 189) {
            System.out.println("The element is in the first place");
        } else {
            System.out.println("The element is not in the first place");
        }
        System.out.println(""+a+","+b);
        driver.quit();
    }
}
