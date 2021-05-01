package Gittigidiyor.Selenium;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


import org.apache.log4j.Logger;

public class LoginTest {

static WebDriver driver;
final static Logger logger = Logger.getLogger(LoginTest.class);
	
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
		driver.get("https://www.gittigidiyor.com/");
		String expectedTitle = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";

		if(driver.getTitle() != null && driver.getTitle().contains(expectedTitle)){
		logger.info("HomePage is opened");
		}
		else{
		logger.info("HomePage could not open.");
		}
	
		driver.get("https://www.gittigidiyor.com/uye-girisi");
		WebElement username=driver.findElement(By.id("L-UserNameField"));
		WebElement password=driver.findElement(By.id("L-PasswordField"));
		WebElement login=driver.findElement(By.id("gg-login-enter"));
		username.sendKeys("aycasinemy@gmail.com");
		password.sendKeys("Mavenproject1");
		login.click();
		
		String actualUrl="https://www.gittigidiyor.com/"; 
		String expectedUrl= driver.getCurrentUrl(); 
		
		if(actualUrl.equalsIgnoreCase(expectedUrl)) { 
		  logger.info("Login successful"); } 
		else { 
		  logger.info("Login failed"); 
		}

        WebElement searchBox = driver.findElement(By.name("k"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        driver.findElement(By.className("hKfdXF")).click();
        
        WebElement secondpage = driver.findElement(By.xpath(".//*[@class='clearfix']//*[text()='2']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", secondpage);
        
		String actualUrl2="https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2"; 
		String expectedUrl2= driver.getCurrentUrl(); 
		
		if(actualUrl2.equalsIgnoreCase(expectedUrl2)) { 
			  logger.info("Login to second page successful"); } 
			else { 
			  logger.info("Login to second page failed"); 
        	  
		}

        List<WebElement> productElems = driver.findElements(By.cssSelector("li[product-id]"));
        int maxProducts = productElems.size();
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        productElems.get(randomProduct).click();

        driver.findElement(By.id("add-to-basket")).sendKeys("Sepete Ekle");
        WebElement basketBtn = driver.findElement(By.id("add-to-basket"));
        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse2.executeScript("arguments[0].click()", basketBtn);
        basketBtn.click();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = driver.getTitle();
        Assert.assertEquals(ExpectedTitle, ActualTitle);

        WebElement cartBtn = driver.findElement(By.className("header-cart-hidden-link"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", cartBtn);
        cartBtn.click();
	
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement delete = driver.findElement(By.className("btn-delete"));
        JavascriptExecutor jse6 = (JavascriptExecutor)driver;
        jse6.executeScript("arguments[0].click()", delete);
        delete.click(); 

    }

		


	    @After
	    public void quitDriver(){
	        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	        driver.quit();
	    }
}
    

	
		
	

