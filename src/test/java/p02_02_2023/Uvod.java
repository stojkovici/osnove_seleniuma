package p02_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Uvod {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver= new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod(){
    }
    @Test
    @Description("Test #1: Visit Login Page from Nav bar")
    public void visitLoginPageFromNavBar(){
        driver.get("https://cms.demo.katalon.com");
        driver.findElement(By.xpath("//li[@class='page_item page-item-10']/a")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title,"My account – Katalon Shop","Title of my account page");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://cms.demo.katalon.com/my-account/","Url of my account page");
    }
    @Test
    @Description("Test #2: Check input types")
    public void checkInputTypes(){
        driver.get("https://cms.demo.katalon.com/my-account/");
        String type = driver.findElement(By.xpath("//input[@name='username']")).getAttribute("type");
        Assert.assertEquals(type,"text","Type of field for email input");
        String password = driver.findElement(By.xpath("//input[@name='password']")).getAttribute("type");
        Assert.assertEquals(password,"password","Type of field for password input");
        String checkbox = driver.findElement(By.xpath("//input[@name='rememberme']")).getAttribute("type");
        Assert.assertEquals(checkbox,"checkbox","Checkbox type for checkbox");
        WebElement checkboxx = driver.findElement(By.xpath("//input[@name='rememberme']"));
        Assert.assertFalse(checkboxx.isSelected(),"Checkbox is checked.");

    }
    @Test
    @Description("Test #3: Display error when credentials are wrong")
    public void displayErroeWhenCredentialsAreWrong(){
        driver.get("https://cms.demo.katalon.com/my-account/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("invalid123");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        WebElement error = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']"));
        Assert.assertTrue(error.isDisplayed(),"Error message is not visible");
        String invalidEmail = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']/ul/li")).getText();
        Assert.assertEquals(invalidEmail,"ERROR: Invalid email address. Lost your password?","Message is not about email");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://cms.demo.katalon.com/my-account/","Not on a same page");


    }
    @AfterMethod
    public void afterMethod(){


    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
