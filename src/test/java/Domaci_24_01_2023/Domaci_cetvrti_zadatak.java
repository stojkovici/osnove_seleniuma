package Domaci_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Domaci_cetvrti_zadatak {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
        for (int i = 0; i <5 ; i++) {
            driver.findElement(By.xpath("//button[@class='btn btn-info add-new']")).click();
            driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Ivan");
            driver.findElement(By.xpath("//input[@name='department']")).sendKeys("QA");
            driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("0601111111221");
            driver.findElement(By.xpath("//a[@class='add']/i")).click();//???
        }
        Thread.sleep(500);
        driver.quit();
    }
}
