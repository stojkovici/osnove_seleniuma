package Domaci_02_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BootstrapTableTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private String firstName;
    private String lastName;
    private String middleName;


    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        this.baseUrl = "https://s.bootsnipp.com";
        this.firstName = "Ivan";
        this.lastName = "Stojkovic";
        this.middleName = "Slavisa";
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
    }
    @Test
    @Description("Edit Row")
    public void editRow(){
        driver.get(baseUrl+"/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com","Title doesn't match.");
        driver.findElement(By.xpath("//tr[@id='d1']/td/button[@class='update btn btn-warning btn-sm']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Up')]")));
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='fn']"));
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='ln']"));
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        WebElement middleNameField = driver.findElement(By.xpath("//input[@id='mn']"));
        middleNameField.clear();
        middleNameField.sendKeys(middleName);
        driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[contains(text(),'Up')]")));
        String ime = driver.findElement(By.xpath("//td[@id='f1']")).getText();
        Assert.assertEquals(ime,firstName,"The first name doesn't match");
        String prezime = driver.findElement(By.xpath("//td[@id='l1']")).getText();
        Assert.assertEquals(prezime,lastName,"The last name doesn't match");
        String srednje = driver.findElement(By.xpath("//td[@id='m1']")).getText();
        Assert.assertEquals(srednje,middleName,"The middle name doesn't match");
    }
    @Test
    @Description("Delete row")
    public void deleteRow(){
        driver.get(baseUrl+"/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com","Title doesn't match.");
        driver.findElement(By.xpath("//tr[@id='d1']/td/button[@class='delete btn btn-danger btn-sm']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'De')]")));
        driver.findElement(By.xpath("//div[@class='modal-footer']/button[@class='btn btn-danger']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[contains(text(),'De')]")));
        WebElement row = driver.findElement(By.xpath("//tbody/tr[1]"));
        Assert.assertFalse(row.isDisplayed(),"Row is not deleted");

    }
    @Test
    @Description("Take a screenshot")
    public void takeAScreenshot() throws IOException {
        driver.get(baseUrl+"/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com","Title doesn't match.");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File folder = new File("C:\\Users\\Gebruiker\\Desktop\\github\\osnove_seleniuma\\screenshots");
        folder.mkdir();
        FileHandler.copy(screenshot,new File(folder,"screenshot1.jpg"));
    }
    @AfterMethod
    public void afterMethod(){

    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}
