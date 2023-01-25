package p24_01_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ArrayList<String> sajt = new ArrayList<>();
        sajt.add("https://google.com/");
        sajt.add("https://youtube.com/");
        sajt.add("https://www.ebay.com/");
        sajt.add("https://www.kupujemprodajem.com/");
        //driver.getTitle()
        for (int i = 0; i <sajt.size() ; i++) {
            driver.get(sajt.get(i));
            System.out.println(driver.getTitle());
        }
        driver.quit();
    }
}
