package Domaci_31_01_2023;

import Helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.Duration;
import java.util.List;

public class Domaci_treci_zadatak {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://itbootcamp.rs/");
        WebElement slider = driver.findElement(By.xpath("//div[@class='tcowl-wrap tc-carousel-container']"));
        new Actions(driver).scrollToElement(slider).perform();
        List<WebElement> slajder = driver.findElements(By.xpath("//div[@class='carousel-item']/img"));
        for (int i = 0; i <slajder.size() ; i++) {
            String url=slajder.get(i).getAttribute("src");
            try{
                int statusCode = new Helper().getHTTPResponseStatusCode(url);
                if (statusCode >= 200 && statusCode < 300){
                    URL dd = new URL(url);
                    ReadableByteChannel r = Channels.newChannel(dd.openStream());
                    File folder = new File("C:\\Users\\Gebruiker\\Desktop\\github\\osnove_seleniuma\\itbootcamp_slider");
                    folder.mkdir();
                    FileOutputStream f = new FileOutputStream(new File(folder,"slider"+i+".jpg"));
                    f.getChannel().transferFrom(r,0,Long.MAX_VALUE);
                    driver.quit();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        driver.quit();
    }
}
