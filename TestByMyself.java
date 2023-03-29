package testsByMe;

import java.time.Duration;

//Using a random web page for automation testing

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestByMyself {
	
	
	public static void testUserSignIn(WebDriver drivObj) throws InterruptedException {
		//Test the user sign-in workflow
		drivObj.findElement(By.id("user-name")).sendKeys("standard_user");
		drivObj.findElement(By.name("password")).sendKeys("secret_sauce");
		drivObj.findElement(By.cssSelector("input[type*='submit']")).click();
	}
	
	public static void testUserLogout(WebDriver drivObj) throws InterruptedException {
		
		drivObj.findElement(By.id("react-burger-menu-btn")).click();
		//Thread.sleep(1000);
		//drivObj.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
		//drivObj.findElement(By.id("about_sidebar_link")).click();
		//drivObj.findElement (By.linkText("Logout")).click();
		WebElement logoutButtonDelay = new WebDriverWait(drivObj, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
		// Print the first result
		System.out.println(logoutButtonDelay.getText());
		logoutButtonDelay.click();
		
	}
	
	
	
	
	
	public static void testUserShoppingCart(WebDriver drivObj) throws InterruptedException {
		
		testUserSignIn(drivObj);
		
		drivObj.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
		drivObj.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
		//Thread.sleep(2000);
		drivObj.findElement(By.xpath("//button[@id='continue-shopping']")).click();
		//Thread.sleep(2000);
		drivObj.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		drivObj.findElement(By.cssSelector("div[class='shopping_cart_container']")).click();
		//Thread.sleep(2000);
		drivObj.findElement(By.cssSelector("button[id='remove-sauce-labs-backpack']")).click();
		//Thread.sleep(1000);
		drivObj.findElement(By.cssSelector("button#checkout")).click();
	
		
	}
	
	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		//Setting the Chromedriver as Webdriver
		 //Chromedriver Class is implementing the Webdriver interface 
		
		System.setProperty("webdriver.chrome.driver", "/home/adriana/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
	
		//Set  the url of the page we want to test
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	
		
		
		testUserSignIn(driver);
		testUserLogout(driver);
		
		testUserShoppingCart(driver);

	}

}
