package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://cms.demo.katalon.com/product/flying-ninja/");
        String href = driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/wp-content/uploads/2019/08/poster_2_up.jpg']")).getAttribute("href");
        URL url = new URL(href);
        ReadableByteChannel r = Channels.newChannel(url.openStream());
        File folder = new File("C:\\Users\\Gebruiker\\Desktop\\github\\osnove_seleniuma\\downloads");
        folder.mkdir();
        FileOutputStream f = new FileOutputStream(new File(folder,"flying-ninja.jpg"));
        f.getChannel().transferFrom(r,0,Long.MAX_VALUE);
        driver.quit();

    }
}
