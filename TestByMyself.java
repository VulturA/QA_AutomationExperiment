package testsByMe;

//Using a random web page for automation testing

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestByMyself {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Setting the Chromedriver as Webdriver
		 //Chromedriver Class is implementing the Webdriver interface 
		
		System.setProperty("webdriver.chrome.driver", "/home/adriana/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		//Set  the url of the page we want to test
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		//Test the user sign-in workflow
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input[type*='submit']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.cssSelector("div[class='shopping_cart_container']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[id='remove-sauce-labs-backpack']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button#checkout")).click();
	
		
		
		
		
		

	}

}
