package p03_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class KatalonShopTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        this.baseUrl ="https://cms.demo.katalon.com";
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
    }
    @Test(priority = 10)
    @Description("Adding product with quantity to the cart")
    public void addinfProductWithQuantityToTheCart(){
        driver.get(baseUrl+"/product/flying-ninja/");
        driver.findElement(By.xpath("//div[@class='quantity-button quantity-up']")).click();
        driver.findElement(By.xpath("//div[@class='quantity-button quantity-up']")).click();
        driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();
        String flying = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();
        Assert.assertTrue(flying.contains("Flying Ninja"),"This message doesn't contain Flying Ninja");
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/cart/']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"),"This url doesn't contain /cart");
        WebElement tbody = driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']/tbody"));
        List<WebElement> number = tbody.findElements(By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
        int numberOfItems = number.size();
        Assert.assertEquals(numberOfItems,1,"There are more or less than 1 item in the cart");

    }

    @Test(priority = 20)
    @Description("Removing product from cart")
    public void removingProductFromCart(){
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/cart/']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"),"This url doesn't contain /cart");
        WebElement tbody = driver.findElement(By.xpath("//tbody/tr[@class='woocommerce-cart-form__cart-item cart_item']"));
        List<WebElement> number = tbody.findElements(By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
        int numberOfItems = number.size();
        Assert.assertEquals(numberOfItems,1,"There are more than 1 item in the cart");
        driver.findElement(By.xpath("//a[@class='remove']")).click();
        WebElement tbody1 = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']"));
        List<WebElement> number1 = tbody1.findElements(By.tagName("tr"));
        int numbers = number1.size();
        Assert.assertEquals(numbers,0,"There are more than 0 items");
    }
    @Test(priority = 30)
    @Description("Verify error is displayed when username is missing")
    public void verifyErrorIsDisplayedWhenUsernameIsMissing(){
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.xpath("//button[@name='login']")).click();
        String error = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']/ul/li")).getText();
        Assert.assertEquals(error,"Error: Username is required.");
    }
    @Test(priority = 40)
    @Description("Verify error is displayed when password is missing")
    public void verifyErrorIsDisplayedWhenPasswordIsMissing(){
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("customer");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        String error = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']/ul/li")).getText();
        Assert.assertEquals(error,"ERROR: The password field is empty.");
    }
    @Test(priority = 50)
    @Description("Verify error is displayed when password is wrong")
    public void verifyErrorIsDisplayedWhenPasswordIsWrong(){
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("customer");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("invalidpassword");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        String error = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']/ul/li")).getText();
        Assert.assertEquals(error,"ERROR: The password you entered for the username customer is incorrect. Lost your password?");
    }
    @Test(priority = 60)
    @Description("Verify error is displayed when user does not exist")
    public void verifyErrorIsDisplayedWhenUserDoesNotExist(){
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("invaliduser");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("pass12334");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        String error = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']/ul/li")).getText();
        Assert.assertEquals(error,"ERROR: Invalid username. Lost your password?");
    }
    @Test(priority = 70)
    @Description("Verify successful login")
    public void verifySuccessfulLogin(){
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("customer");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("crz7mrb.KNG3yxv1fbn");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        String welcome = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/p[1]")).getText();
        Assert.assertTrue(welcome.contains("Hello Katalon Parlitul_Changed"));
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
