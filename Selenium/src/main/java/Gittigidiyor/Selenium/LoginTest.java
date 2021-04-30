package Gittigidiyor.Selenium;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

static WebDriver driver;
	
	@BeforeClass
	public static void BrowserOpen()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); 
	    driver= new ChromeDriver() ;
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gittigidiyor.com/uye-girisi");
		WebElement username=driver.findElement(By.id("L-UserNameField"));
		WebElement password=driver.findElement(By.id("L-PasswordField"));
		WebElement login=driver.findElement(By.id("gg-login-enter"));
		username.sendKeys("aycasinemy@gmail.com");
		password.sendKeys("Mavenproject1");
		login.click();

        WebElement searchBox = driver.findElement(By.name("k"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        driver.findElement(By.className("hKfdXF")).click();
        

        WebElement secondpage = driver.findElement(By.xpath(".//*[@class='clearfix']//*[text()='2']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", secondpage);

        List<WebElement> productElems = driver.findElements(By.cssSelector("li[product-id]"));
        int maxProducts = productElems.size();
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        productElems.get(randomProduct).click();
       
        WebElement basketBtn = driver.findElement(By.id("add-to-basket"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", basketBtn);
        basketBtn.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 
       
	}
	    @After
	    public void quitDriver(){
	        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	        driver.quit();
	    }
	
    }
	

	
		
	

